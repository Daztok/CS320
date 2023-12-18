package Appointment;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class AppointmentService {
    private ArrayList<Appointment> appointmentList = new ArrayList<>();

    // Display the full list of appointments to the console for error checking.
    public void displayAppointmentList() {
        for (Appointment appointment : appointmentList) {
            System.out.println("\t Appointment ID: " + appointment.getAppointmentID());
            System.out.println("\t Appointment Date: " + appointment.getAppointmentDate());
            System.out.println("\t Appointment Description: " + appointment.getAppointmentDesc());
        }
    }

    public String addAppointment(Date appointmentDate, String appointmentDesc) {
        // Ensure appointmentDate is in the future
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Cannot set appointment date in the past.");
        }

        // Ensure appointmentDesc is not null
        if (appointmentDesc == null) {
            throw new IllegalArgumentException("Appointment description cannot be null.");
        }

        // Create a new Appointment with the provided date
        Appointment appointment = new Appointment(appointmentDate, appointmentDesc);

        // Set the creation time
        long creationTime = System.currentTimeMillis();
        appointment.setCreationTime(creationTime);

        appointmentList.add(appointment);

        // Return the appointment ID
        return appointment.getAppointmentID();
    }
    
    // Using Appointment ID, return an appointment object
    public Appointment getAppointment(String appointmentID) {
        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointmentID().equals(appointmentID)) {
                return appointment;
            }
        }
        return null; // Return null if not found
    }

 // Delete appointment.
    public boolean deleteAppointment(String appointmentID) {
        Iterator<Appointment> iterator = appointmentList.iterator();
        while (iterator.hasNext()) {
            Appointment appointment = iterator.next();
            if (appointment.getAppointmentID().equals(appointmentID)) {
                iterator.remove();
                return true; // Appointment found and deleted
            }
        }
        return false; // Appointment not found
    }

    // Update the appointment description.
    public void updateAppointmentDesc(String updatedString, String appointmentID) {
        boolean found = false;

        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointmentID().equals(appointmentID)) {
                appointment.setAppointmentDesc(updatedString);
                found = true;
                break;
            }
        }

        if (!found) {
            throw new IllegalArgumentException("Appointment ID: " + appointmentID + " not found.");
        }
    }

    // Update the appointment date.

    public void updateAppointmentDate(Date newDate, String appointmentID) {
        Appointment appointmentToUpdate = getAppointment(appointmentID);

        if (appointmentToUpdate != null) {
            // Update the appointment date
            appointmentToUpdate.setAppointmentDate(newDate);
            System.out.println("Appointment date updated successfully.");
        } else {
            throw new IllegalArgumentException("Appointment ID: " + appointmentID + " not found.");
        }
    }
    
    public ArrayList<Appointment> getAppointmentList() {
        return new ArrayList<>(appointmentList);
    }
}
