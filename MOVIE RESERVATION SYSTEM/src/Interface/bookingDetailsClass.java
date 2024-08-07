package Interface;

import java.sql.*;
import java.util.ArrayList;
import Resources.*;
import Utilities.*;

public class bookingDetailsClass implements bookingDetailsDAO {
    static Connection con = connection.dbConnection();
    private statusHolder status;

    public bookingDetailsClass(statusHolder status) {
        this.status = status;
    }

    public Object insertDetails(bookingDetails obj) throws Exception {
        PreparedStatement preparedStatement = null;
        String query = "insert into booking_details(numberOfTickets,user_id,show_id) values(?,?,?)";
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1, obj.getNumberOfTickets());
        preparedStatement.setInt(2, findUserId(obj.getUserEmail()));
        preparedStatement.setInt(3, obj.getShowId());
        int rs = preparedStatement.executeUpdate();
        if (rs > 0) {
            status.setStatusHolder("\nBooking Confirmed!!\n");
        } else {
            status.setStatusHolder("\nBooking Not Confirmed!!\n");
        }
        return status;
    }

    public int findUserId(String email) throws Exception {
        java.sql.PreparedStatement st1 = con
                .prepareStatement("Select user_id from user_details where user_email=?");
        st1.setString(1, email);
        ResultSet rs = st1.executeQuery();
        if (rs.next()) {
            int u_id = rs.getInt(1);
            return u_id;
        } else {
            throw new Exception("User not found over booking");
        }
    }

    public Object findBookingId(bookingDetails obj) throws Exception {
        java.sql.PreparedStatement st1 = con
                .prepareStatement(
                        "Select booking_id from booking_details where numberOfTickets=? and user_id=? and show_id=?");
        st1.setInt(1, obj.getNumberOfTickets());
        st1.setInt(2, findUserId(obj.getUserEmail()));
        st1.setInt(3, obj.getShowId());
        ResultSet rs = st1.executeQuery();
        if (rs.next()) {
            obj.setBookingId(rs.getInt(1));
        } else {
            throw new Exception("Booking Id not found over payment");
        }
        return obj;
    }

    public ArrayList<bookingHistory> findBookingHistory(bookingHistory obj) {
        ArrayList<bookingHistory> al = new ArrayList<>();
        try (PreparedStatement st1 = con.prepareStatement(
                "SELECT m.movie_name AS \"Movie Name\", m.movie_language AS \"Movie Language\", " +
                        "s.show_id AS \"Screen No\", s.show_date AS \"Show Date\", " +
                        "s.show_time AS \"Show Timing\", s.show_session AS \"Show Session\", " +
                        "p.payment_id AS \"Payment Id\", p.payment_status AS \"Status\" " +
                        "FROM payment_details p " +
                        "JOIN booking_details b ON p.booking_id = b.booking_id " +
                        "JOIN show_details s ON s.show_id = b.show_id " +
                        "JOIN movie m ON m.movie_id = s.movie_id " +
                        "WHERE b.user_id = ?")) {

            st1.setInt(1, obj.getUserId());
            ResultSet rs = st1.executeQuery();

            while (rs.next()) {
                bookingHistory b = new bookingHistory();
                String m_name = rs.getString("Movie Name");
                String m_language = rs.getString("Movie Language");
                String s_no = rs.getString("Screen No");
                String s_date = rs.getString("Show Date");
                String s_time = rs.getString("Show Timing");
                String s_session = rs.getString("Show Session");
                String payment_id = rs.getString("Payment Id");
                String payment_status = rs.getString("Status");

                b.setMovieName(m_name);
                b.setMovieLanguage(m_language);
                b.setScreenNo(s_no);
                b.setShowTime(s_time);
                b.setShowDate(s_date);
                b.setShowSession(s_session);
                b.setPaymentId(payment_id);
                b.setPaymentStatus(payment_status);

                al.add(b);
            }
        } catch (Exception e) {
            System.out.println("Error --> " + e);
        }
        return al;
    }

}
