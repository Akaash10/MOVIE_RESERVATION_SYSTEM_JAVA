package Interface;

import java.util.ArrayList;
import Resources.bookingDetails;
import Resources.bookingHistory;

public interface bookingDetailsDAO {
    Object insertDetails(bookingDetails obj) throws Exception;

    int findUserId(String n) throws Exception;

    Object findBookingId(bookingDetails obj) throws Exception;

    ArrayList<bookingHistory> findBookingHistory(bookingHistory obj) throws Exception;
}
