package model;

public class Doctor extends User implements Notifiable {
    private String specialization;
    private String department;
    private double consultationFee;
    private ScheduleSlot[] slots; // Composition + Array of objects

    public Doctor(String userId, String name, String phone, String specialization, String department, double consultationFee, int maxSlots) {
        super(userId, name, phone);
        this.specialization = specialization;
        this.department = department;
        this.consultationFee = consultationFee;
        this.slots = new ScheduleSlot[maxSlots];
    }

    public void addSlot(int index, ScheduleSlot slot) {
        if (index >= 0 && index < slots.length) {
            slots[index] = slot;
        }
    }

    // Method Overloading 1: Find first available slot
    public ScheduleSlot findSlot() {
        for (ScheduleSlot s : slots) {
            if (s != null && !s.isBooked()) {
                return s;
            }
        }
        return null;
    }

    // Method Overloading 2: Find specific slot by slotId
    public ScheduleSlot findSlot(String slotId) {
        for (ScheduleSlot s : slots) {
            if (s != null && s.getSlotId().equalsIgnoreCase(slotId)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public String getRoleSummary() {
        return super.getBasicProfile() + " | Role: Doctor (" + specialization + " - " + department + ") | Fee: PKR " + consultationFee;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("[Doctor Portal Alert for Dr. " + getName() + "]: " + message);
    }

    @Override
    public String getNotificationChannel() {
        return "Doctor Dashboard & SMS";
    }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public double getConsultationFee() { return consultationFee; }
    public void setConsultationFee(double consultationFee) { this.consultationFee = consultationFee; }
    public ScheduleSlot[] getSlots() { return slots; }
}