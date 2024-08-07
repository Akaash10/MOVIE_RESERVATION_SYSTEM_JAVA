package Resources;

public class bookingHistory {
    private int user_id;
    private String movie_name;
    private String movie_language;
    private String screen_no;
    private String show_time;
    private String show_date;
    private String show_session;
    private String payment_id;
    private String payment_status;

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public int getUserId() {
        return user_id;
    }
    
    public void setMovieName(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovieName() {
        return movie_name;
    }

    public void setMovieLanguage(String movie_language) {
        this.movie_language = movie_language;
    }

    public String getMovieLanguage() {
        return movie_language;
    }

    public void setScreenNo(String screen_no) {
        this.screen_no = screen_no;
    }

    public String getScreenNo() {
        return screen_no;
    }

    public void setShowTime(String show_time) {
        this.show_time = show_time;
    }

    public String getShowTime() {
        return show_time;
    }

    public void setShowDate(String show_date) {
        this.show_date = show_date;
    }

    public String getShowDate() {
        return show_date;
    }

    public void setShowSession(String show_session) {
        this.show_session = show_session;
    }

    public String getShowSession() {
        return show_session;
    }

    public void setPaymentId(String payment_id) {
        this.payment_id = payment_id;
    }

    public String getPaymentId() {
        return payment_id;
    }

    public void setPaymentStatus(String payment_status) {
        this.payment_status = payment_status;
    }

    public String getPaymentStatus() {
        return payment_status;
    }
}
