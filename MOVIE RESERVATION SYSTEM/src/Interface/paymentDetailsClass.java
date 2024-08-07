package Interface;

import java.sql.*;
import Resources.*;
import Utilities.*;

public class paymentDetailsClass implements paymentDetailsDAO {

    static Connection con = connection.dbConnection();
    private statusHolder status;

    public paymentDetailsClass(statusHolder status) {
        this.status = status;
    }

    public Object insertDetails(paymentDetails obj) throws Exception {
        PreparedStatement preparedStatement = null;
        String query = "insert into payment_details(payment_price, payment_modeofpay,payment_status,booking_id) values(?,?,?,?)";
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1, obj.getPaymentPrice());
        preparedStatement.setString(2, obj.getModeOfPay());
        preparedStatement.setString(3, obj.getPaymentStatus());
        preparedStatement.setInt(4, obj.getBookingId());
        int rs = preparedStatement.executeUpdate();
        if (rs > 0) {
            status.setStatusHolder("\nPayment Successful!!\n");
        } else {
            status.setStatusHolder("\nPayment Not Successful!!\n");
        }
        return status;
    }

}
