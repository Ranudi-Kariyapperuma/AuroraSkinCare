public class Dermatologist {
    private String name;
    private int sessionDuration;// as example 15 minutes

    public Dermatologist(String name, int sessionDuration) {
        this.name = name;
        this.sessionDuration = sessionDuration;
    }

    public String getName() {
        return name;
    }

    public int getSessionDuration() {
        return sessionDuration;
    }
}


