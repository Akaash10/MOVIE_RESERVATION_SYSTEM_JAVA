package Resources;

public class movieDetails {
    private int movie_id;
    private String movie_name;
    private String movie_description;
    private String movie_genre;
    private String movie_language;
    private String movie_release_date;
    private int movie_duration;
    private String updateColumnName;
    private String updateColumnValue;

    public movieDetails(){}

    public movieDetails(int movie_id, String movie_name, String movie_description, String movie_genre, String movie_language,
            String movie_release_date, int movie_duration) {
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.movie_description = movie_description;
        this.movie_genre=movie_genre;
        this.movie_language = movie_language;
        this.movie_release_date = movie_release_date;
        this.movie_duration = movie_duration;
    }

    public void setMovieId(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getMovieId() {
        return movie_id;
    }

    public void setMovieName(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovieName() {
        return movie_name;
    }

    public void setMovieDescription(String movie_description) {
        this.movie_description = movie_description;
    }

    public String getMovieDescription() {
        return movie_description;
    }

    public void setMovieGenre(String movie_genre) {
        this.movie_genre = movie_genre;
    }

    public String getMovieGenre() {
        return movie_genre;
    }

    public void setMovieLanguage(String movie_language) {
        this.movie_language = movie_language;
    }

    public String getMovieLanguage() {
        return movie_language;
    }

    public void setMovieReleaseDate(String movie_release_date) {
        this.movie_release_date = movie_release_date;
    }

    public String getMovieReleaseDate() {
        return movie_release_date;
    }
    
    public void setMovieDuration(int movie_duration) {
        this.movie_duration = movie_duration;
    }
    
    public int getMovieDuration() {
        return movie_duration;
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