package Interface;

import java.util.*;
import java.sql.*;
import Resources.*;
import Utilities.*;

public class multiplexDetailsClass implements multiplexDetailsDAO {
    static Connection con = connection.dbConnection();
    private statusHolder status;

    public multiplexDetailsClass(statusHolder status) {
        this.status = status;
    }

    public Object insertDetails(multiplexDetails obj) throws Exception {
        PreparedStatement preparedStatement = null;
        String query = "insert into multiplex_details(multiplex_id,multiplex_name,multiplex_totalscreens,multiplex_City,multiplex_Zipcode) values(?,?,?,?,?)";
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, obj.getMultiplexId());
        preparedStatement.setString(2, obj.getMultiplexName());
        preparedStatement.setInt(3, obj.getMultiplexTotalScreens());
        preparedStatement.setString(4, obj.getMultiplexCity());
        preparedStatement.setString(5, obj.getMultiplexZipcode());
        int rs = preparedStatement.executeUpdate();
        if (rs > 0) {
            status.setStatusHolder("\nMultiplex added successfully!!\n");
        } else {
            status.setStatusHolder("\nMultiplex not added successfully!!\n");
        }
        return status;
    }

    public Object deleteDetails(multiplexDetails obj) throws Exception {
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM multiplex_details WHERE multiplex_id=?";
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, obj.getMultiplexId());
        int rs = preparedStatement.executeUpdate();
        if (rs > 0) {
            status.setStatusHolder("\nMultiplex Deleted Successfully\n");
        } else {
            status.setStatusHolder("\nMultiplex Not Exists\n");
        }
        return status;
    }

    public Object updateDetails(multiplexDetails obj) throws Exception {
        int flag = 0;
        try {
            String query = "SELECT " + obj.getColumnName() + " FROM multiplex_details";
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
            String query1 = "SELECT * FROM multiplex_details WHERE multiplex_id=?";
            preparedStatement1 = con.prepareStatement(query1);
            preparedStatement1.setString(1, obj.getMultiplexId());
            resultSet1 = preparedStatement1.executeQuery();

            if (resultSet1.next()) {
                PreparedStatement preparedStatement2 = null;
                String query2 = "UPDATE multiplex_details SET " + obj.getColumnName() + "=? WHERE multiplex_id=?";
                preparedStatement2 = con.prepareStatement(query2);
                if (obj.getColumnName().equals("multiplex_totalscreens")) {
                    preparedStatement2.setInt(1, obj.getMultiplexTotalScreens());
                } else {
                    preparedStatement2.setString(1, obj.getColumnValue());
                }
                preparedStatement2.setString(2, obj.getMultiplexId());
                int rs = preparedStatement2.executeUpdate();
                if (rs > 0) {
                    status.setStatusHolder("\nMultiplex Updated Successfully\n");
                } else {
                    status.setStatusHolder("\nMultiplex Not Updated Successfully\n");
                }
            } else {
                status.setStatusHolder("Invalid Multiplex ID");
            }
        }
        return status;
    }

    public ArrayList<multiplexDetails> viewDetails() throws Exception {
        ArrayList<multiplexDetails> al = new ArrayList<>();
        java.sql.Statement st1;
        ResultSet rs = null;
        try {
            st1 = con.createStatement();
            String query = "Select * from multiplex_details";
            rs = ((java.sql.Statement) st1).executeQuery(query);
        } catch (Exception e) {
            System.out.println("Error-->" + e);
        }
        while (rs.next()) {
            multiplexDetails m = new multiplexDetails();
            String m_id = rs.getString(1);
            String m_name = rs.getString(2);
            String m_tscreens = rs.getString(3);
            String m_city = rs.getString(4);
            String m_zipcode = rs.getString(5);
            m.setMultiplexId(m_id);
            m.setMultiplexName(m_name);
            m.setMultiplexTotalScreens(Integer.parseInt(m_tscreens));
            m.setMultiplexCity(m_city);
            m.setMultiplexZipcode(m_zipcode);
            al.add(m);
        }
        return al;
    }

}
