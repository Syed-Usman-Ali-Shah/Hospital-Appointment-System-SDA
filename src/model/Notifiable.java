package model;

public interface Notifiable {
    void sendNotification(String message);
    String getNotificationChannel();
}