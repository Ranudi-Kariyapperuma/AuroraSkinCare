public class Treatment {
    private static final double TAX_RATE = 0.025;

    public static double calculateTotalFee(double treatmentCost) {
        return Math.round((treatmentCost + (treatmentCost * TAX_RATE)) * 100.0) / 100.0;
    }

    public static void generateInvoice(Appointment appointment, String treatmentType) {
        double treatmentCost = getTreatmentCost(treatmentType);
        double totalFee = calculateTotalFee(treatmentCost);
        System.out.println("\n----- Invoice -----");
        System.out.println("Appointment ID: " + appointment.getAppointmentId());
        System.out.println("Patient Name: " + appointment.getPatient().getName());
        System.out.println("Treatment Type: " + treatmentType);
        System.out.println("Treatment Cost: LKR " + treatmentCost);
        System.out.println("\n----------------------");
        System.out.println("Total Fee (with tax): LKR " + totalFee);
        System.out.println("\n----------------------");
    }

    public static double getTreatmentCost(String treatmentType) {
        switch (treatmentType.toLowerCase()) {
            case "acne treatment":
                return 2750.00;
            case "skin whitening":
                return 7650.00;
            case "mole removal":
                return 3850.00;
            case "laser treatment":
                return 12500.00;
            default:
                return 0.0;
        }
    }
}





