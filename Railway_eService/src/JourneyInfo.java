public class JourneyInfo {
    public String j_date, t_name, startTime, endTime, c_name, fare;
    public int j_id, j_train, j_coach, j_vacancy, t_id, from_st, to_st, c_id, c_fare;

    public JourneyInfo(int j_id, int j_train, int j_coach, int j_vacancy, String j_date, String t_name, String startTime, String endTime, String c_name, int t_id, int from_st, int to_st, int c_id, int c_fare, String fare) {
        this.j_id = j_id;
        this.j_train = j_train;
        this.j_coach = j_coach;
        this.j_vacancy = j_vacancy;
        this.j_date = j_date;
        this.t_name = t_name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.c_name = c_name;
        this.t_id = t_id;
        this.from_st = from_st;
        this.to_st = to_st;
        this.c_id = c_id;
        this.c_fare = c_fare;
        this.fare=fare;
    }

    public JourneyInfo(){

    }
}
