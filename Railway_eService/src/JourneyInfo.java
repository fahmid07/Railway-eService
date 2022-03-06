public class JourneyInfo {
    public String date, from, to, train, coach, vacancy, sttime, endtime;
    public int tarin_id, coach_id, vacancy_id, from_id, to_id, journey_id;

    public JourneyInfo(String date, String from, String to, String train, String coach, String vacancy, int tarin_id, int coach_id, int vacancy_id, int from_id, int to_id, int journey_id, String sttime, String endtime) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.train = train;
        this.coach = coach;
        this.vacancy = vacancy;
        this.tarin_id = tarin_id;
        this.coach_id = coach_id;
        this.vacancy_id = vacancy_id;
        this.from_id = from_id;
        this.to_id = to_id;
        this.journey_id = journey_id;
        this.sttime = sttime;
        this.endtime = endtime;
    }

    public JourneyInfo(){
        
    }
}
