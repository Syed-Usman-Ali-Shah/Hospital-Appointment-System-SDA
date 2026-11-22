package model;

public abstract class User {
    private String userId;
    private String name;
    private String phone;

    public User(String userId, String name, String phone) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
    }

    // Concrete method
    public String getBasicProfile() {
        return "ID: " + userId + " | Name: " + name + " | Phone: " + phone;
    }

    // Abstract method (must be overridden by child classes)
    public abstract String getRoleSummary();

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}