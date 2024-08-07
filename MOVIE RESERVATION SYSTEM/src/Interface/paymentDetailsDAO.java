package Interface;

import Resources.paymentDetails;

public interface paymentDetailsDAO {
    Object insertDetails(paymentDetails obj) throws Exception;
}
