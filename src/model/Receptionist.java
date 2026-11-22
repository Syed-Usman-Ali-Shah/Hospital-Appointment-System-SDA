package model;

public class Receptionist extends User {
    private String deskNumber;
    private String shift;
    private int checkInsHandled;

    public Receptionist(String userId, String name, String phone, String deskNumber, String shift) {
        super(userId, name, phone);
        this.deskNumber = deskNumber;
        this.shift = shift;
        this.checkInsHandled = 0;
    }

    public void processWalkInCheckIn(Appointment app) {
        if (app != null && app.getStatus().equals("Confirmed")) {
            app.setStatus("Checked-In");
            checkInsHandled++;
            System.out.println("Receptionist " + getName() + " checked in Appointment #" + app.getAppointmentId());
        }
    }

    @Override
    public String getRoleSummary() {
        return super.getBasicProfile() + " | Role: Receptionist (Desk: " + deskNumber + ", Shift: " + shift + ")";
    }

    public String getDeskNumber() { return deskNumber; }
    public void setDeskNumber(String deskNumber) { this.deskNumber = deskNumber; }
    public String getShift() { return shift; }
    public void setShift(String shift) { this.shift = shift; }
    public int getCheckInsHandled() { return checkInsHandled; }
}