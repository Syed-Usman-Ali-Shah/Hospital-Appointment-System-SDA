package main;

import java.util.Scanner;
import model.*;

public class Main {

    // Passing an array to a method (Requirement 4)
    public static int countConfirmedAppointments(Appointment[] list) {
        int count = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null && list[i].getStatus().equals("Confirmed")) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Runtime Polymorphism: Parent class array holding different Child objects
        User[] users = new User[6];
        Patient p1 = new Patient("P-101", "Syed Usman Ali Shah", "0300-1112233", 21, "B+", "usman@nu.edu.pk");
        Doctor d1 = new Doctor("D-201", "Kamran Ahmed", "0333-4445566", "Cardiologist", "Cardiology", 2500.0, 3);
        Doctor d2 = new Doctor("D-202", "Sara Malik", "0321-9998877", "Dermatologist", "Skin Care", 2000.0, 2);
        Receptionist r1 = new Receptionist("R-301", "Bilal Khan", "0345-5556677", "Desk-1", "Morning");

        users[0] = p1;
        users[1] = d1;
        users[2] = d2;
        users[3] = r1;

        // Populating Doctor Slots
        d1.addSlot(0, new ScheduleSlot("SL-1", "2026-11-23", "10:00 AM - 10:30 AM"));
        d1.addSlot(1, new ScheduleSlot("SL-2", "2026-11-23", "11:00 AM - 11:30 AM"));
        d2.addSlot(0, new ScheduleSlot("SL-3", "2026-11-23", "02:00 PM - 02:30 PM"));

        Appointment[] appointments = new Appointment[10];
        int appCount = 0;
        int choice;

        do {
            System.out.println("\n=== Hospital Appointment System (Console) ===");
            System.out.println("1. Search Doctors & View Free Slots (UC-03)");
            System.out.println("2. Book Appointment (UC-04)");
            System.out.println("3. Cancel Appointment (UC-06)");
            System.out.println("4. View All System Users (Runtime Polymorphism Demo)");
            System.out.println("5. View Active Appointments Count");
            System.out.println("6. Exit");
            System.out.print("Select option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Doctor Specialization or Name to search: ");
                    String query = sc.nextLine().toLowerCase();
                    boolean foundDoc = false;
                    for (User u : users) {
                        if (u instanceof Doctor) {
                            Doctor doc = (Doctor) u;
                            if (doc.getName().toLowerCase().contains(query) || doc.getSpecialization().toLowerCase().contains(query)) {
                                foundDoc = true;
                                System.out.println("\n" + doc.getRoleSummary());
                                for (ScheduleSlot s : doc.getSlots()) {
                                    if (s != null) System.out.println("   -> " + s.getSlotDetails());
                                }
                            }
                        }
                    }
                    if (!foundDoc) System.out.println("No matching doctor found.");
                    break;

                case 2:
                    System.out.print("Enter Doctor ID (D-201 or D-202): ");
                    String docId = sc.nextLine();
                    Doctor selectedDoc = null;
                    for (User u : users) {
                        if (u instanceof Doctor && u.getUserId().equalsIgnoreCase(docId)) {
                            selectedDoc = (Doctor) u;
                        }
                    }

                    if (selectedDoc == null) {
                        System.out.println("Invalid Doctor ID!");
                    } else {
                        System.out.print("Enter Slot ID (e.g., SL-1): ");
                        String slotId = sc.nextLine();
                        ScheduleSlot slot = selectedDoc.findSlot(slotId); // Overloaded method

                        if (slot != null && !slot.isBooked()) {
                            System.out.print("Enter Visit Reason: ");
                            String reason = sc.nextLine();
                            String appId = "APP-" + (100 + appCount + 1);
                            Appointment newApp = new Appointment(appId, p1, selectedDoc, slot, reason);
                            appointments[appCount++] = newApp;

                            System.out.println("Booking Confirmed! " + newApp.getSummary());
                            p1.sendNotification("Your appointment " + appId + " with Dr. " + selectedDoc.getName() + " is Confirmed.");
                        } else {
                            System.out.println("Slot is either invalid or already taken!");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Appointment ID to cancel (e.g., APP-101): ");
                    String cancelId = sc.nextLine();
                    boolean appFound = false;
                    for (int i = 0; i < appCount; i++) {
                        if (appointments[i] != null && appointments[i].getAppointmentId().equalsIgnoreCase(cancelId)) {
                            appFound = true;
                            System.out.print("How many hours remain before appointment? ");
                            int hrs = sc.nextInt();
                            sc.nextLine();
                            appointments[i].cancelAppointment(hrs);
                        }
                    }
                    if (!appFound) System.out.println("Appointment ID not found.");
                    break;

                case 4:
                    System.out.println("\n--- System Users (Dynamic Binding Output) ---");
                    for (User u : users) {
                        if (u != null) {
                            // Calls overridden getRoleSummary() for Patient, Doctor, and Receptionist
                            System.out.println(u.getRoleSummary());
                        }
                    }
                    break;

                case 5:
                    int active = countConfirmedAppointments(appointments);
                    System.out.println("Total Confirmed Appointments: " + active);
                    break;

                case 6:
                    System.out.println("Exiting Hospital Appointment System...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);

        sc.close();
    }
}
