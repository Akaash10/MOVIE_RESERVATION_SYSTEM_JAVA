package Interface;

import java.util.*;
import java.sql.*;

import Resources.availableShows;
import Resources.showDetails;
import Utilities.*;

public class showDetailsClass implements showDetailsDAO {
    static Connection con = connection.dbConnection();
    private statusHolder status;

    public showDetailsClass(statusHolder status) {
        this.status = status;
    }

    public Object insertDetails(showDetails obj) throws Exception {
        PreparedStatement preparedStatement = null;
        String query = "insert into Show_Details(show_time,show_session,show_date,movie_id,screen_id) values(?,?,?,?,?)";
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, obj.getShowTime());
        preparedStatement.setString(2, obj.getShowSession());
        preparedStatement.setString(3, obj.getShowDate());
        preparedStatement.setInt(4, obj.getMovieId());
        preparedStatement.setInt(5, obj.getScreenId());
        int rs = preparedStatement.executeUpdate();
        if (rs > 0) {
            status.setStatusHolder("\nShow added successfully!!\n");
        } else {
            status.setStatusHolder("\nShow not added successfully!!\n");
        }
        return status;
    }

    public Object deleteDetails(showDetails obj) throws Exception {
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM Show_Details WHERE show_id=?";
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1, obj.getShowId());
        int rs = preparedStatement.executeUpdate();
        if (rs > 0) {
            status.setStatusHolder("\nShow Deleted Successfully\n");
        } else {
            status.setStatusHolder("\nShow Not Exists\n");
        }
        return status;
    }

    public Object updateDetails(showDetails obj) throws Exception {
        int flag = 0;
        try {
            String query = "SELECT " + obj.getColumnName() + " FROM Show_Details";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            System.out.println("Error-->" + e);
            flag = 1;
            status.setStatusHolder("Invalid Column Name");
        }
        if (flag == 0) {
            PreparedStatement preparedStatement1 = null;
            ResultSet resultSet1 = null;
            String query1 = "SELECT * FROM Show_Details WHERE show_id=?";
            preparedStatement1 = con.prepareStatement(query1);
            preparedStatement1.setInt(1, obj.getShowId());
            resultSet1 = preparedStatement1.executeQuery();

            if (resultSet1.next()) {
                PreparedStatement preparedStatement2 = null;
                String query2 = "UPDATE Show_Details SET " + obj.getColumnName() + "=? WHERE show_id=?";
                preparedStatement2 = con.prepareStatement(query2);
                preparedStatement2.setString(1, obj.getColumnValue());
                if (obj.getColumnValue().equals("movie_id") || obj.getColumnValue().equals("screen_id")) {
                    preparedStatement2.setInt(2, obj.getShowId());
                } else {
                    preparedStatement2.setString(2, obj.getColumnValue());
                }
                int rs = preparedStatement2.executeUpdate();
                if (rs > 0) {
                    status.setStatusHolder("\nShow Updated Successfully\n");
                } else {
                    status.setStatusHolder("\nShow Not Updated Successfully\n");
                }
            } else {
                status.setStatusHolder("Invalid Show ID");
            }
        }
        return status;
    }

    public ArrayList<showDetails> viewDetails() throws Exception {
        ArrayList<showDetails> al = new ArrayList<>();
        java.sql.Statement st1;
        ResultSet rs = null;
        try {
            st1 = con.createStatement();
            String query = "Select * from Show_Details";
            rs = ((java.sql.Statement) st1).executeQuery(query);
        } catch (Exception e) {
            System.out.println("Error-->" + e);
        }
        while (rs.next()) {
            showDetails s = new showDetails();
            int s_id = rs.getInt(1);
            String s_time = rs.getString(2);
            String s_session = rs.getString(3);
            String s_date = rs.getString(4);
            int s_mid = rs.getInt(5);
            int s_sid = rs.getInt(6);
            s.setShowId(s_id);
            s.setShowTime(s_time);
            s.setShowSession(s_session);
            s.setShowDate(s_date);
            s.setMovieId(s_mid);
            s.setMovieName(findMovieName(s_mid));
            s.setScreenId(s_sid);
            al.add(s);
        }
        return al;
    }

    public String findMovieName(int id) throws Exception {
        java.sql.PreparedStatement st1 = con.prepareStatement("Select movie_name from movie where movie_id = ?");
        st1.setInt(1, id);
        ResultSet rs = st1.executeQuery();
        if (rs.next()) {
            String u_id = rs.getString(1);
            return u_id;
        } else {
            throw new Exception("Movie not found");
        }
    }

    public ArrayList<availableShows> findAvailableShows(availableShows obj) throws Exception {
        ArrayList<availableShows> al = new ArrayList<>();
        java.sql.Statement st1;
        ResultSet rs = null;
        try {
            st1 = con.createStatement();
            String query = "Select screen_name,screen_count,mu.multiplex_id,show_time,show_session,show_id,show_date,movie_name,movie_duration from screen_details as sc join show_details as sh on sc.screen_id=sh.screen_id join movie as m on sh.movie_id=m.movie_id join multiplex_details as mu on mu.multiplex_id=sc.multiplex_id where m.movie_id=? and mu.multiplex_id=?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, obj.getMovieId());
            preparedStatement.setString(2, obj.getMultiplexId());
            rs = preparedStatement.executeQuery();
        } catch (Exception e) {
            System.out.println("Error-->" + e);
        }
        while (rs.next()) {
            availableShows a = new availableShows();
            String s_name = rs.getString("screen_name");
            String s_time = rs.getString("show_time");
            String s_session = rs.getString("show_session");
            String s_date = rs.getString("show_date");
            String m_name = rs.getString("movie_name");
            String s_id = rs.getString("show_id");
            a.setScreenName(s_name);
            a.setShowTime(s_time);
            a.setShowSession(s_session);
            a.setShowDate(s_date);
            a.setMovieName(m_name);
            a.setShowId(s_id);
            al.add(a);
        }
        return al;
    }

}
