package Resources;

import java.util.ArrayList;

public class userDetails {
    private int user_id;
    private String user_name;
    private String user_role;
    private String user_email;
    private String user_password;
    private String user_conformpassword;
    private String user_dob;
    private String user_number;
    private int user_flagcheck;

    public userDetails(String user_name, String user_email, String user_password, String user_conformpassword,
            String user_dob, String user_number) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_conformpassword = user_conformpassword;
        this.user_dob = user_dob;
        this.user_number = user_number;
    }

    public userDetails(String checkEmail, String checkPassword) {
        this.user_email=checkEmail;
        this.user_password=checkPassword;
    }

    public userDetails() {}

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserName(String user_name) {
        this.user_name = user_name;
    }

    public String getUserName() {
        return user_name;
    }

    public void setUserRole(String user_role) {
        this.user_role = user_role;
    }

    String getUserRole() {
        return user_role;
    }

    public void setUserEmail(String user_email) {
        this.user_email = user_email;
    }

    public String getUserEmail() {
        return user_email;
    }

    public void setUserPassword(String user_password) {
        this.user_password = user_password;
    }

    public String getUserPassword() {
        return user_password;
    }

    void setUserConformPassword(String user_conformpassword) {
        this.user_conformpassword = user_conformpassword;
    }

    public String getUserConformPassword() {
        return user_conformpassword;
    }

    public void setUserDateOfBirth(String user_dob) {
        this.user_dob = user_dob;
    }

    public String getUserDateOfBirth() {
        return user_dob;
    }

    public void setUserNumber(String user_number) {
        this.user_number = user_number;
    }

    public String getUserNumber() {
        return user_number;
    }

    public void setUserFlagCheck(int user_flagcheck) {
        this.user_flagcheck = user_flagcheck;
    }

    public int getUserFlagCheck() {
        return user_flagcheck;
    }

    public static ArrayList<userDetails> findUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findUsers'");
    }
}
