public class Patient {
    private String nic;
    private String name;
    private String email;
    private String telephone;

    public Patient(String nic, String name, String email, String telephone) {
        this.nic = nic;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public String getNic() {
        return nic;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }
}



