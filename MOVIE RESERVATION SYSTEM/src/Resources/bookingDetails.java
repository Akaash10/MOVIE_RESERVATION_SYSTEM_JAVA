package Resources;

public class bookingDetails {
    private int booking_id;
    private int booking_numberOfTickets;
    private int user_id;
    private int show_id;
    private String email;

    public bookingDetails(int booking_numberOfTickets, String email, int show_id) {
        this.booking_numberOfTickets = booking_numberOfTickets;
        this.email=email;
        this.show_id = show_id;
    }

    public bookingDetails(){}
    public void setBookingId(int booking_id) {
        this.booking_id = booking_id;
    }

    public int getBookingId() {
        return booking_id;
    }

    void setNumberOfTickets(int booking_numberOfTickets) {
        this.booking_numberOfTickets = booking_numberOfTickets;
    }

    public int getNumberOfTickets() {
        return booking_numberOfTickets;
    }

    void setUserId(int user_id) {
        this.user_id = user_id;
    }

    int getUserId() {
        return user_id;
    }

    void setShowId(int show_id) {
        this.show_id = show_id;
    }

    public int getShowId() {
        return show_id;
    }

    public void setUserEmail(String email){
        this.email=email;
    }

    public String getUserEmail(){
        return email;
    }
}
