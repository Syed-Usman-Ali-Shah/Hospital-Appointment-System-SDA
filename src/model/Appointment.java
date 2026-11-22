package model;

public class Appointment {
    private String appointmentId;
    private Patient patient;       // Composition
    private Doctor doctor;         // Composition
    private ScheduleSlot slot;     // Composition
    private String visitReason;
    private String status;         // Confirmed, Checked-In, Completed, Cancelled, No-Show

    public Appointment(String appointmentId, Patient patient, Doctor doctor, ScheduleSlot slot, String visitReason) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.slot = slot;
        this.visitReason = visitReason;
        this.status = "Confirmed";
        this.slot.setBooked(true);
    }

    // Arithmetic operator + Type Casting
    public int calculateTotalBillWithTax() {
        double taxRate = 0.05; // 5% hospital service tax
        double total = doctor.getConsultationFee() + (doctor.getConsultationFee() * taxRate);
        return (int) total; // Explicit type casting from double to int
    }

    // UC-06 Cancel Appointment (2-hour rule from Assignment 2)
    public boolean cancelAppointment(int hoursRemaining) {
        // Relational and Logical operators
        if (status.equals("Confirmed") && hoursRemaining >= 2) {
            this.status = "Cancelled";
            this.slot.setBooked(false); // Release slot
            patient.sendNotification("Appointment " + appointmentId + " cancelled. Slot " + slot.getSlotId() + " released.");
            doctor.sendNotification("Appointment " + appointmentId + " cancelled by patient.");
            return true;
        } else {
            System.out.println("Cancellation blocked! Less than 2 hours remaining or invalid status. Please contact reception.");
            return false;
        }
    }

    public String getSummary() {
        return "Appt ID: " + appointmentId + " | Patient: " + patient.getName() +
               " | Dr. " + doctor.getName() + " | Slot: " + slot.getTimeRange() +
               " | Reason: " + visitReason + " | Status: " + status +
               " | Bill: PKR " + calculateTotalBillWithTax();
    }

    public String getAppointmentId() { return appointmentId; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public ScheduleSlot getSlot() { return slot; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}