package Interface;

import java.util.*;
import java.sql.*;
import Resources.movieDetails;
import Utilities.*;

public class movieDetailsClass implements movieDetailsDAO {
    static Connection con = connection.dbConnection();
    private statusHolder status;

    public movieDetailsClass(statusHolder status) {
        this.status = status;
    }

    public Object insertDetails(movieDetails obj) throws Exception {
        PreparedStatement preparedStatement = null;
        String query = "insert into movie(movie_id, movie_name, movie_description,movie_genre, movie_language, movie_release_date, movie_duration) values(?,?,?,?,?,?,?)";
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setLong(1, obj.getMovieId());
        preparedStatement.setString(2, obj.getMovieName());
        preparedStatement.setString(3, obj.getMovieDescription());
        preparedStatement.setString(4, obj.getMovieGenre());
        preparedStatement.setString(5, obj.getMovieLanguage());
        preparedStatement.setString(6, obj.getMovieReleaseDate());
        preparedStatement.setLong(7, obj.getMovieDuration());
        int rs = preparedStatement.executeUpdate();
        if (rs > 0) {
            status.setStatusHolder("\nMovie added successfully!!\n");
        } else {
            status.setStatusHolder("\nMovie not added successfully!!\n");
        }
        return status;
    }

    public Object deleteDetails(movieDetails obj) throws Exception {
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM movie WHERE movie_id=?";
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setLong(1, obj.getMovieId());
        int rs = preparedStatement.executeUpdate();
        if (rs > 0) {
            status.setStatusHolder("\nMovie Deleted Successfully\n");
        } else {
            status.setStatusHolder("\nMovie not exists!!\n");
        }
        return status;
    }

    public Object updateDetails(movieDetails obj) throws Exception {
        int flag = 0;
        try {
            String query = "SELECT " + obj.getColumnName() + " FROM movie";
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
            String query1 = "SELECT * FROM movie WHERE movie_id=?";
            preparedStatement1 = con.prepareStatement(query1);
            preparedStatement1.setLong(1, obj.getMovieId());
            resultSet1 = preparedStatement1.executeQuery();

            if (resultSet1.next()) {
                PreparedStatement preparedStatement2 = null;
                String query2 = "UPDATE movie SET " + obj.getColumnName() + "=? WHERE movie_id=?";
                preparedStatement2 = con.prepareStatement(query2);
                preparedStatement2.setString(1, obj.getColumnValue());
                preparedStatement2.setLong(2, obj.getMovieId());
                int rs = preparedStatement2.executeUpdate();
                if (rs > 0) {
                    status.setStatusHolder("\nMovie Updated Successfully!!\n");
                } else {
                    status.setStatusHolder("\nMovie Not Updated Successfully!!\n");
                }
            } else {
                status.setStatusHolder("Invalid Movie ID");
            }
        }
        return status;
    }

    public ArrayList<movieDetails> viewDetails() throws Exception {
        ArrayList<movieDetails> al = new ArrayList<>();
        java.sql.Statement st1;
        ResultSet rs = null;
        try {
            st1 = con.createStatement();
            String query = "Select * from movie";
            rs = ((java.sql.Statement) st1).executeQuery(query);
        } catch (Exception e) {
            System.out.println("Error-->" + e);
        }
        while (rs.next()) {
            movieDetails m = new movieDetails();
            int m_id = rs.getInt(1);
            String m_name = rs.getString(2);
            String m_description = rs.getString(3);
            String m_genre = rs.getString(4);
            String m_language = rs.getString(5);
            String m_releasedate = rs.getString(6);
            int m_duration = rs.getInt(7);
            m.setMovieId(m_id);
            m.setMovieName(m_name);
            m.setMovieDescription(m_description);
            m.setMovieGenre(m_genre);
            m.setMovieLanguage(m_language);
            m.setMovieReleaseDate(m_releasedate);
            m.setMovieDuration(m_duration);
            al.add(m);
        }
        return al;
    }

}
