package Interface;

import java.util.*;
import java.sql.*;
import Resources.screenDetails;
import Utilities.*;

public class screenDetailsClass implements screenDetailsDAO {
    static Connection con = connection.dbConnection();
    private statusHolder status;

    public screenDetailsClass(statusHolder status) {
        this.status = status;
    }

    public Object insertDetails(screenDetails obj) throws Exception {
        PreparedStatement preparedStatement = null;
        String query = "insert into screen_details(screen_name, screen_count,multiplex_id) values(?,?,?)";
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, obj.getScreenName());
        preparedStatement.setInt(2, obj.getScreenCount());
        preparedStatement.setString(3, obj.getMultiplexId());
        int rs = preparedStatement.executeUpdate();
        if (rs > 0) {
            status.setStatusHolder("\nScreen added successfully!!\n");
        } else {
            status.setStatusHolder("\nScreen not added successfully!!\n");
        }
        return status;
    }

    public Object deleteDetails(screenDetails obj) throws Exception {
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM screen_details WHERE screen_id=?";
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1, obj.getScreenId());
        int rs = preparedStatement.executeUpdate();
        if (rs > 0) {
            status.setStatusHolder("\nScreen Deleted Successfully\n");
        } else {
            status.setStatusHolder("\nScreen Not Exists\n");
        }
        return status;
    }

    public Object updateDetails(screenDetails obj) throws Exception {
        int flag = 0;
        try {
            String query = "SELECT " + obj.getColumnName() + " FROM screen_details";
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
            String query1 = "SELECT * FROM screen_details WHERE screen_id=?";
            preparedStatement1 = con.prepareStatement(query1);
            preparedStatement1.setInt(1, obj.getScreenId());
            resultSet1 = preparedStatement1.executeQuery();

            if (resultSet1.next()) {
                PreparedStatement preparedStatement2 = null;
                String query2 = "UPDATE screen_details SET " + obj.getColumnName() + "=? WHERE screen_id=?";
                preparedStatement2 = con.prepareStatement(query2);
                if (obj.getColumnValue().equals("screen_count")) {
                    preparedStatement2.setInt(1, obj.getScreenCount());
                } else {
                    preparedStatement2.setString(1, obj.getColumnValue());
                }
                preparedStatement2.setInt(2, obj.getScreenId());
                int rs = preparedStatement2.executeUpdate();
                if (rs > 0) {
                    status.setStatusHolder("\nScreen Updated Successfully\n");
                } else {
                    status.setStatusHolder("\nScreen Not Updated Successfully\n");
                }
            } else {
                status.setStatusHolder("Invalid Screen ID");
            }
        }
        return status;
    }

    public ArrayList<screenDetails> viewDetails() throws Exception {
        ArrayList<screenDetails> al = new ArrayList<>();
        java.sql.Statement st1;
        ResultSet rs = null;
        try {
            st1 = con.createStatement();
            String query = "Select * from screen_details";
            rs = ((java.sql.Statement) st1).executeQuery(query);
        } catch (Exception e) {
            System.out.println("Error-->" + e);
        }
        while (rs.next()) {
            screenDetails s = new screenDetails();
            String s_id = rs.getString(1);
            String s_name = rs.getString(2);
            String s_count = rs.getString(3);
            String m_id = rs.getString(4);
            s.setScreenId(Integer.parseInt(s_id));
            s.setScreenName(s_name);
            s.setScreenCount(Integer.parseInt(s_count));
            s.setMultiplexName(findMultiplexName(m_id));
            al.add(s);
        }
        return al;
    }

    public String findMultiplexName(String id) throws Exception {
        java.sql.PreparedStatement st1 = con
                .prepareStatement("Select multiplex_name from multiplex_details where multiplex_id = ?");
        st1.setString(1, id);
        ResultSet rs = st1.executeQuery();
        if (rs.next()) {
            String u_id = rs.getString(1);
            return u_id;
        } else {
            throw new Exception("Multiplex not found");
        }
    }

}
