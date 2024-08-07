package Resources;

public class showDetails {
    private int show_id;
    private String show_time;
    private String show_session;
    private String show_date;
    private int movie_id;
    private int screen_id;
    private String movie_name;
    private String updateColumnName;
    private String updateColumnValue;

    public showDetails(String show_time, String show_session, String show_date, int movie_id, int screen_id) {
        this.show_time = show_time;
        this.show_session = show_session;
        this.show_date = show_date;
        this.movie_id = movie_id;
        this.screen_id = screen_id;
    }

    public showDetails() {}

    public void setShowId(int show_id) {
        this.show_id = show_id;
    }

    public int getShowId() {
        return show_id;
    }

    public void setShowTime(String show_time) {
        this.show_time = show_time;
    }

    public String getShowTime() {
        return show_time;
    }

    public void setShowSession(String show_session) {
        this.show_session = show_session;
    }

    public String getShowSession() {
        return show_session;
    }

    public void setShowDate(String show_date) {
        this.show_date = show_date;
    }

    public String getShowDate() {
        return show_date;
    }

    public void setMovieId(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getMovieId() {
        return movie_id;
    }

    public void setScreenId(int screen_id) {
        this.screen_id = screen_id;
    }

    public int getScreenId() {
        return screen_id;
    }

    public void setMovieName(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovieName() {
        return movie_name;
    }
    
    public void setColumnName(String updateColumnName) {
        this.updateColumnName = updateColumnName;
    }

    public String getColumnName() {
        return updateColumnName;
    }

    public void setColumnValue(String updateColumnValue) {
        this.updateColumnValue = updateColumnValue;
    }

    public String getColumnValue() {
        return updateColumnValue;
    }
}
