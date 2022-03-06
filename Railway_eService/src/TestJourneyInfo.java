public class TestJourneyInfo {
    public String t_name, startTime, endTime, c_name;
    public int c_fare;

    public TestJourneyInfo(String t_name, String startTime, String endTime, String c_name, int c_fare) {
        this.t_name = t_name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.c_name = c_name;
        this.c_fare = c_fare;
    }

    public TestJourneyInfo() {
        
    }

    public String get_t_name() {
        return this.t_name;
    }

    public String get_startTime() {
        return this.startTime;
    }

    public String get_endTime() {
        return this.endTime;
    }

    public String get_c_name() {
        return this.c_name;
    }

    public int get_c_fare() {
        return this.c_fare;
    }

    public void set_t_name(String t_name) {
        this.t_name = t_name;
    }

    public void set_startTime(String startTime) {
        this.startTime = startTime;
    }

    public void set_endTime(String endTime) {
        this.endTime = endTime;
    }

    public void set_c_name(String c_name) {
        this.c_name = c_name;
    }

    public void set_c_fare(int c_fare) {
        this.c_fare = c_fare;
    }

    
}
