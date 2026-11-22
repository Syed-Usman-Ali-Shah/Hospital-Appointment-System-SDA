package model;

public class ScheduleSlot {
    private String slotId;
    private String date;
    private String timeRange;
    private boolean isBooked;

    // Constructor 1 (Overloaded)
    public ScheduleSlot(String slotId, String date, String timeRange) {
        this.slotId = slotId;
        this.date = date;
        this.timeRange = timeRange;
        this.isBooked = false;
    }

    // Constructor 2 (Overloaded)
    public ScheduleSlot(String slotId, String date, String timeRange, boolean isBooked) {
        this.slotId = slotId;
        this.date = date;
        this.timeRange = timeRange;
        this.isBooked = isBooked;
    }

    public String getSlotDetails() {
        return slotId + " | Date: " + date + " | Time: " + timeRange + " | Status: " + (isBooked ? "Booked" : "Free");
    }

    public String getSlotId() { return slotId; }
    public void setSlotId(String slotId) { this.slotId = slotId; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getTimeRange() { return timeRange; }
    public void setTimeRange(String timeRange) { this.timeRange = timeRange; }
    public boolean isBooked() { return isBooked; }
    public void setBooked(boolean booked) { isBooked = booked; }
}