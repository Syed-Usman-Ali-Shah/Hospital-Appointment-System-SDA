# Hospital Appointment System (Console Version)

## Student Details
- **Name:** Syed Usman Ali Shah
- **Registration Number:** 24P-0698
- **Course:** Software Design & Analysis (SDA) - Assignment #04
- **Semester:** Fall-2026

## Project Overview
This Java console application implements the design of the **Hospital Appointment System** using Object-Oriented Programming principles (Classes, Encapsulation, Composition, Arrays, Hierarchical Inheritance, Abstract Classes, Interfaces, and Runtime Polymorphism).

## List of Classes & Packages
### 1. `model` Package
- **`Notifiable` (Interface):** Defines notification contracts (`sendNotification()`, `getNotificationChannel()`) for system alerts.
- **`User` (Abstract Class):** Base class storing common user attributes (`userId`, `name`, `phone`) and profile methods.
- **`Patient` (Concrete Class):** Extends `User` and implements `Notifiable`; represents patients booking or cancelling appointments.
- **`Doctor` (Concrete Class):** Extends `User` and implements `Notifiable`; manages doctor profiles, fees, and `ScheduleSlot[]` arrays.
- **`Receptionist` (Concrete Class):** Extends `User`; handles front-desk walk-in patient check-ins.
- **`ScheduleSlot` (Concrete Class):** Represents individual date/time slots and availability status.
- **`Appointment` (Concrete Class):** Connects `Patient`, `Doctor`, and `ScheduleSlot` via composition and enforces the 2-hour cancellation rule.

### 2. `main` Package
- **`Main` (Concrete Class):** Entry point containing `public static void main(String[] args)` and the interactive console menu demonstrating UC-03 (Search Doctor), UC-04 (Book Appointment), UC-06 (Cancel Appointment), and Runtime Polymorphism.

## How to Run the Program
1. Open **Eclipse IDE** (`Eclipse IDE for Java Developers`).
2. Import or open the project folder containing `src/model` and `src/main`.
3. Navigate to `src/main/Main.java`.
4. Right-click inside `Main.java` and select **Run As -> Java Application**.
5. Use the console menu options (`1` to `6`) to search doctors, book/cancel appointments, and view polymorphic user summaries.
