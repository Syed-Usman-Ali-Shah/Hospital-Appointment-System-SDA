package model;

public class Patient extends User implements Notifiable {
    private int age;
    private String bloodGroup;
    private String email;

    // Constructor 1 (Overloaded)
    public Patient(String userId, String name, String phone, int age) {
        super(userId, name, phone);
        this.age = age;
        this.bloodGroup = "Unknown";
        this.email = "not-provided@hospital.pk";
    }

    // Constructor 2 (Overloaded)
    public Patient(String userId, String name, String phone, int age, String bloodGroup, String email) {
        super(userId, name, phone);
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.email = email;
    }

    @Override
    public String getRoleSummary() {
        return super.getBasicProfile() + " | Role: Patient | Age: " + age + " | Blood: " + bloodGroup;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("[SMS/Email to Patient " + getName() + " (" + email + ")]: " + message);
    }

    @Override
    public String getNotificationChannel() {
        return "SMS & Email (" + getPhone() + ")";
    }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}