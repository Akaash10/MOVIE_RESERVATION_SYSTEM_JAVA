package Interface;

import java.sql.*;
import java.util.ArrayList;

import Resources.*;
import Utilities.*;

public class userDetailsClass implements userDetailsDAO {
    static Connection con = connection.dbConnection();
    private statusHolder status;

    public userDetailsClass(statusHolder status) {
        this.status = status;
    }

    public userDetailsClass() {
    }

    public Object registrationDetails(userDetails obj) throws Exception {
        PreparedStatement preparedStatement = null;
        if (obj.getUserPassword().equals(obj.getUserConformPassword())) {
            String query = "insert into user_details(user_name,user_email,user_password,user_dob,user_number) values(?,?,?,?,?)";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, obj.getUserName());
            preparedStatement.setString(2, obj.getUserEmail());
            preparedStatement.setString(3, obj.getUserPassword());
            preparedStatement.setString(4, obj.getUserDateOfBirth());
            preparedStatement.setString(5, obj.getUserNumber());
            int rs = preparedStatement.executeUpdate();
            if (rs > 0) {
                status.setStatusHolder("Registration Successful");
            } else {
                status.setStatusHolder("Registration Not Successful");
            }
        } else {
            status.setStatusHolder("Passwords didn't match");
        }
        return status;
    }

    public Object loginDetails(userDetails obj) throws Exception {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "SELECT user_password,user_role FROM user_details WHERE user_email=?";
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, obj.getUserEmail());
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String fetchedPassword = resultSet.getString("user_password");
            String fetchedRole = resultSet.getString("user_role");

            if (fetchedPassword.equals(obj.getUserPassword())) {
                if (fetchedRole.equals("user")) {
                    obj.setUserRole("user");
                    obj.setUserFlagCheck(2);
                    status.setStatusHolder("User login Successful");
                } else if (fetchedRole.equals("admin")) {
                    obj.setUserRole("admin");
                    obj.setUserFlagCheck(1);
                    status.setStatusHolder("Admin login Successful");
                }
            } else {
                status.setStatusHolder("Password not matched");
                obj.setUserFlagCheck(0);
            }
        } else {
            status.setStatusHolder("Do Register your account");
            obj.setUserFlagCheck(-1);
        }
        return status;
    }

    public ArrayList<userDetails> findUsers() throws Exception {
        ArrayList<userDetails> al = new ArrayList<>();
        java.sql.Statement st1;
        ResultSet rs = null;
        try {
            st1 = con.createStatement();
            String query = "Select * from user_details";
            rs = ((java.sql.Statement) st1).executeQuery(query);
        } catch (Exception e) {
            System.out.println("Error-->" + e);
        }
        while (rs.next()) {
            userDetails s = new userDetails();
            String u_id = rs.getString(1);
            String u_name = rs.getString(2);
            String u_email = rs.getString(4);
            String u_dob = rs.getString(6);
            String u_mnumber = rs.getString(7);
            s.setUserId(Integer.parseInt(u_id));
            s.setUserName(u_name);
            s.setUserEmail(u_email);
            s.setUserDateOfBirth(u_dob);
            s.setUserNumber(u_mnumber);
            al.add(s);
        }
        return al;
    }

}
