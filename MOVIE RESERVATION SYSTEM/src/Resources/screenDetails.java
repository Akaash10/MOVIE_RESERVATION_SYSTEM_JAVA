package Resources;

public class screenDetails {
    private int screen_id;
    private String screen_name;
    private int screen_count;
    private String multiplex_id;
    private String multiplex_name;
    private String updateColumnName;
    private String updateColumnValue;

    public screenDetails(String screen_name, int screen_count, String multiplex_id) {
        this.screen_name = screen_name;
        this.screen_count = screen_count;
        this.multiplex_id = multiplex_id;
    }

    public screenDetails() {
    }

    public void setScreenId(int screen_id) {
        this.screen_id = screen_id;
    }

    public int getScreenId() {
        return screen_id;
    }

    public void setScreenName(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getScreenName() {
        return screen_name;
    }

    public void setScreenCount(int screen_count) {
        this.screen_count = screen_count;
    }

    public int getScreenCount() {
        return screen_count;
    }

    void setMultiplexId(String multiplex_id) {
        this.multiplex_id = multiplex_id;
    }

    public String getMultiplexId() {
        return multiplex_id;
    }

    public void setMultiplexName(String multiplex_name) {
        this.multiplex_name = multiplex_name;
    }

    public String getMultiplexName() {
        return multiplex_name;
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
