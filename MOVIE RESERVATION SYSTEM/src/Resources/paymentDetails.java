package Resources;

public class paymentDetails {
    private int payment_id;
    private int payment_price;
    private String payment_modeofpay;
    private String payment_status;
    private int booking_id;

    public paymentDetails(int payment_price, String payemnt_modeofpay, String payment_status, int booking_id) {
        this.payment_price = payment_price;
        this.payment_modeofpay = payemnt_modeofpay;
        this.payment_status = payment_status;
        this.booking_id = booking_id;
    }

    void setPaymentId(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getPaymentId() {
        return payment_id;
    }

    void setPaymentPrice(int payment_price) {
        this.payment_price = payment_price;
    }

    public int getPaymentPrice() {
        return payment_price;
    }

    void setModeOfPay(String payment_modeofpay) {
        this.payment_modeofpay = payment_modeofpay;
    }

    public String getModeOfPay() {
        return payment_modeofpay;
    }

    void setPaymentStatus(String payment_status) {
        this.payment_status = payment_status;
    }

    public String getPaymentStatus() {
        return payment_status;
    }

    void setBookingId(int booking_id) {
        this.booking_id = booking_id;
    }

    public int getBookingId() {
        return booking_id;
    }
}
