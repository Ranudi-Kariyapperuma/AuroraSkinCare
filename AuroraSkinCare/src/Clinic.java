import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Clinic {
    private String name;
    private String location;
    private ArrayList<Dermatologist> dermatologists;
    private HashMap<String, String> consultationSchedule;

    public Clinic(String name, String location) {
        this.name = name;
        this.location = location;
        this.dermatologists = new ArrayList<>();
        this.consultationSchedule = new HashMap<>();

        // Define consultation schedule
        consultationSchedule.put("Monday", "10:00am - 01:00pm");
        consultationSchedule.put("Wednesday", "02:00pm - 05:00pm");
        consultationSchedule.put("Friday", "04:00pm - 08:00pm");
        consultationSchedule.put("Saturday", "09:00am - 01:00pm");
    }

    public void addDermatologist(Dermatologist dermatologist) {
        dermatologists.add(dermatologist);
    }

    public ArrayList<Dermatologist> getDermatologists() {
        return dermatologists;
    }

    public String getConsultationTime(String day) {
        return consultationSchedule.get(day);
    }

    public List<String> getConsultationDays() {
        return new ArrayList<>(consultationSchedule.keySet());
    }

    public boolean isTimeAvailable(String day, String time) {
        String availableTime = consultationSchedule.get(day);
        return availableTime != null && availableTime.contains(time);
    }
}
