import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuroraMain {
    public static void main(String[] args) {
        Clinic clinic = new Clinic("Aurora Skin Care Clinic", "Colombo");
        Dermatologist dermatologist1 = new Dermatologist("Dr. Kumara", 15);
        Dermatologist dermatologist2 = new Dermatologist("Dr. Pubudu", 15);
        clinic.addDermatologist(dermatologist1);
        clinic.addDermatologist(dermatologist2);

        List<Appointment> appointments = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to Aurora Skin Care!");

        while (true) {
            System.out.println("\n1. Make Appointment");
            System.out.println("2. Update Appointment Details");
            System.out.println("3. Search Appointment");
            System.out.println("4. View Appointments by Date");
            System.out.println("5. Generate Invoice");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    makeAppointment(scanner, clinic, appointments);
                    break;

                case 2:
                    System.out.print("\nEnter Appointment ID to update: ");
                    String appointmentId = scanner.next();
                    updateAppointmentDetails(appointmentId, scanner, appointments);
                    break;

                case 3:
                    System.out.print("\nSearch by (1) Name or (2) Appointment ID: ");
                    int searchChoice = scanner.nextInt();
                    if (searchChoice == 1) {
                        System.out.print("\nEnter patient name: ");
                        scanner.nextLine(); // Consume newline
                        String name = scanner.nextLine();
                        searchAppointmentByName(name, appointments);
                    } else if (searchChoice == 2) {
                        System.out.print("\nEnter Appointment ID: ");
                        String id = scanner.next();
                        searchAppointmentById(id, appointments);
                    }
                    break;

                case 4:
                    System.out.print("\nEnter date (e.g., Monday): ");
                    String date = scanner.next();
                    viewAppointmentsByDate(date, appointments);
                    break;

                case 5:
                    System.out.print("\nEnter Appointment ID: ");
                    appointmentId = scanner.next();
                    generateInvoice(appointmentId, appointments);
                    break;

                case 6:
                    System.out.println("\n Thank you for choosing our service!");
                    System.out.println("---------------------------------------");
                    System.out.println("\nThank you for choosing our service!");
                    System.out.println("We look forward to welcoming you back!\n\n");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void makeAppointment(Scanner scanner, Clinic clinic, List<Appointment> appointments) {
        System.out.print("\nEnter patient NIC: ");
        String nic = scanner.next();
        System.out.print("Enter patient name: ");
        scanner.nextLine(); 
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.next();
        System.out.print("Enter telephone: ");
        String telephone = scanner.next();

        Patient patient = new Patient(nic, name, email, telephone);

        System.out.println("\nChoose a dermatologist:");
        for (int i = 0; i < clinic.getDermatologists().size(); i++) {
            System.out.println((i + 1) + ". " + clinic.getDermatologists().get(i).getName());
        }
        System.out.print("\nEnter choice: ");
        int dermatologistChoice = scanner.nextInt();
        Dermatologist dermatologist = clinic.getDermatologists().get(dermatologistChoice - 1);

        System.out.println("\nAvailable consultation times:");
        for (String day : clinic.getConsultationDays()) {
            System.out.println(day + ": " + clinic.getConsultationTime(day));
        }

        System.out.print("\nEnter preferred day (e.g., Monday): ");
        String day = scanner.next();
        System.out.print("Enter preferred time (e.g., 10:00am): ");
        String time = scanner.next();

        if (!clinic.isTimeAvailable(day, time)) {
            System.out.println("\nSelected time is not available. Please choose another time.");
            return;
        }

        // If already booked a slot it will be checking here
        for (Appointment appointment : appointments) {
            if (appointment.getDermatologist().equals(dermatologist) &&
                appointment.getDate().equals(day) && appointment.getTime().equals(time)) {
                System.out.println("\nSlot already booked. Please choose a different time.");
                return;
            }
        }

        // Creating the appointment Id and Add the appointment
        String appointmentId = "A" + (appointments.size() + 1); 
        Appointment appointment = new Appointment(appointmentId, patient, dermatologist, day, time);
        appointment.payRegistrationFee();
        appointments.add(appointment);

        System.out.println("\nAppointment booked successfully! Registration fee of LKR 500 has been paid.");
        System.out.println("Your Appointment ID is: " + appointmentId); 
    }

    private static void updateAppointmentDetails(String appointmentId, Scanner scanner, List<Appointment> appointments) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                System.out.print("Enter new date: ");
                String newDate = scanner.next();
                System.out.print("Enter new time: ");
                String newTime = scanner.next();

                appointment.setDate(newDate);
                appointment.setTime(newTime);

                System.out.println("\nAppointment updated successfully!");
                return;
            }
        }
        System.out.println("\nAppointment not found.");
    }

    private static void searchAppointmentByName(String name, List<Appointment> appointments) {
        System.out.println("\nSearching for appointments with patient name: " + name);
        for (Appointment appointment : appointments) {
            if (appointment.getPatient().getName().equalsIgnoreCase(name)) {
                System.out.println(appointment);
            }
        }
    }

    private static void searchAppointmentById(String appointmentId, List<Appointment> appointments) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                System.out.println(appointment);
                return;
            }
        }
        System.out.println("Appointment not found.");
    }

    private static void viewAppointmentsByDate(String date, List<Appointment> appointments) {
        System.out.println("Appointments on " + date + ":");
        for (Appointment appointment : appointments) {
            if (appointment.getDate().equals(date)) {
                System.out.println(appointment);
            }
        }
    }

    private static void generateInvoice(String appointmentId, List<Appointment> appointments) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                Scanner scanner = new Scanner(System.in);
          
                System.out.println("\nAvailable Treatments:");
                System.out.println("\n1. Acne Treatment");
                System.out.println("2. Skin Whitening");
                System.out.println("3. Mole Removal");
                System.out.println("4. Laser Treatment");
                
                System.out.print("\nEnter treatment type (1-4): ");
                int treatmentChoice = scanner.nextInt();
                
               
                String treatmentType = "";
                switch (treatmentChoice) {
                    case 1:
                        treatmentType = "Acne Treatment";
                        break;
                    case 2:
                        treatmentType = "Skin Whitening";
                        break;
                    case 3:
                        treatmentType = "Mole Removal";
                        break;
                    case 4:
                        treatmentType = "Laser Treatment";
                        break;
                    default:
                        System.out.println("\nInvalid choice. No treatment selected.");
                        return;
                }
    
               
                Treatment.generateInvoice(appointment, treatmentType);
                return;
            }
        }
        System.out.println("Appointment not found.");
    }
}