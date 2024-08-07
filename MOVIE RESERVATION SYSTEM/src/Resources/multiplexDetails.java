package Resources;

public class multiplexDetails {
    private String multiplex_id;
    private String multiplex_name;
    private int multiplex_totalscreens;
    private String multiplex_city;
    private String multiplex_zipcode;
    private String updateColumnName;
    private String updateColumnValue;

    public multiplexDetails(String multiplex_id, String multiplex_name, int multiplex_totalscreens, String multiplex_city,
            String multiplex_zipcode) {
        this.multiplex_id = multiplex_id;
        this.multiplex_name = multiplex_name;
        this.multiplex_totalscreens = multiplex_totalscreens;
        this.multiplex_city = multiplex_city;
        this.multiplex_zipcode = multiplex_zipcode;
    }

    public multiplexDetails() {}

    public void setMultiplexId(String multiplex_id) {
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

    public void setMultiplexTotalScreens(int multiplex_totalscreens) {
        this.multiplex_totalscreens = multiplex_totalscreens;
    }

    public int getMultiplexTotalScreens() {
        return multiplex_totalscreens;
    }

    public void setMultiplexCity(String multiplex_city) {
        this.multiplex_city = multiplex_city;
    }

    public String getMultiplexCity() {
        return multiplex_city;
    }

    public void setMultiplexZipcode(String multiplex_zipcode) {
        this.multiplex_zipcode = multiplex_zipcode;
    }

    public String getMultiplexZipcode() {
        return multiplex_zipcode;
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
