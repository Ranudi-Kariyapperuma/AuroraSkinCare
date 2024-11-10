public class Appointment {
    private String appointmentId;
    private Patient patient;
    private Dermatologist dermatologist;
    private String date;
    private String time;
    private static final double REGISTRATION_FEE = 500.0;
    private boolean isFeePaid = false;

    public Appointment(String appointmentId, Patient patient, Dermatologist dermatologist, String date, String time) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.dermatologist = dermatologist;
        this.date = date;
        this.time = time;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Dermatologist getDermatologist() {
        return dermatologist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void payRegistrationFee() {
        this.isFeePaid = true;
    }

    public boolean isFeePaid() {
        return isFeePaid;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + appointmentId + ", Patient: " + patient.getName() + ", Dermatologist: " + dermatologist.getName() + ", Date: " + date + ", Time: " + time;
    }
}
