package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Calendar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Appointment.Appointment;

class AppointmentTest {

    // Helper method to create a Date object
    private Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }

    @Test
    @DisplayName("Appointment ID cannot have more than 10 characters")
    void testAppointmentIDLength() {
        // Create an Appointment with a valid date (current date) to avoid IllegalArgumentException
        Appointment appointment = new Appointment(createDate(2024, Calendar.FEBRUARY, 2), "Description");

        // Debug information
        String appointmentID = appointment.getAppointmentID();
        System.out.println("Actual Appointment ID: " + appointmentID);
        System.out.println("Actual Appointment ID length: " + appointmentID.length());

        assertTrue(appointmentID.length() <= 10, "Appointment ID length exceeds 10 characters.");
    }
    
    @Test
    @DisplayName("Task Description cannot have more than 50 characters")
    void testAppointmentDescLength() {
        // Create an Appointment with a valid date (current date) to avoid IllegalArgumentException
        Appointment appointment = new Appointment(createDate(2024, Calendar.FEBRUARY, 2),
                "123456789 is nine characters long" +
                        "123456789 is another nine characters long" +
                        "123456789 is another nine characters long" +
                        "123456789 is another nine characters long");
        assertTrue(appointment.getAppointmentDesc().length() <= 50, "Appointment Description length exceeds 50 characters.");
    }

    @Test
    @DisplayName("Appointment Date cannot be before current date")
    void testAppointmentDateNotBeforeCurrent() {
        Appointment appointment = new Appointment(createDate(2024, Calendar.FEBRUARY, 2), "Description");
        assertFalse(appointment.getAppointmentDate().before(new Date()), "Appointment Date is before current date.");
    }

    @Test
    @DisplayName("Task Date shall not be null")
    void testAppointmentDateNotNull() {
        Appointment appointment = new Appointment(null, "Description");
        assertNotNull(appointment.getAppointmentDate(), "Appointment Date was null.");
    }

    @Test
    @DisplayName("Task Description shall not be null")
    void testAppointmentDescNotNull() {
        Appointment appointment = new Appointment(createDate(2024, Calendar.FEBRUARY, 2), null);
        assertNotNull(appointment.getAppointmentDesc(), "Appointment Description was null.");
    }
}
