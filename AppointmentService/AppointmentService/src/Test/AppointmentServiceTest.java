package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import Appointment.AppointmentService;
import Appointment.Appointment;

class AppointmentServiceTest {

    private AppointmentService service;
    
    private Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }

    @BeforeEach
    void setUp() {
        service = new AppointmentService();

        // Add an appointment for testing
        Date appointmentDate = createDate(2024, Calendar.JANUARY, 2);
        String appointmentDesc = "Meeting with Client.";
        service.addAppointment(appointmentDate, appointmentDesc);
    }

    @Test
    @Order(2)
    @DisplayName("Test to Update appointment date")
    void testUpdateAppointmentDate() {
        // Display the current state of the appointment list before the update
        System.out.println("Before Update in Test:");
        service.displayAppointmentList();

        // Ensure that the appointment with ID "1" exists before trying to update its date
        assertNotNull(service.getAppointment("3"), "Appointment with ID '3' should exist before updating date.");

        // Update appointment date
        service.updateAppointmentDate(createDate(2024, Calendar.FEBRUARY, 3), "3");

        // Display the current state of the appointment list after the update
        System.out.println("After Update in Test:");
        service.displayAppointmentList();

        // Validate the updated date
        Appointment updatedAppointment = service.getAppointment("3");
        Date expectedDate = createDate(2024, Calendar.FEBRUARY, 3);
        Date actualDate = updatedAppointment.getAppointmentDate();

        // Print details for better debugging
        System.out.println("Expected Date: " + expectedDate);
        System.out.println("Actual Date: " + actualDate);

        // Adjust the comparison to consider time in milliseconds
        assertEquals(expectedDate.getTime(), actualDate.getTime(), "Appointment date was not updated.");
    }

    @Test
    @Order(3)
    @DisplayName("Test to Update appointment description")
    void testUpdateAppointmentDesc() {
        // Display the current state of the appointment list before the update
        System.out.println("Before Update in Test:");
        service.displayAppointmentList();

        // Ensure that the appointment with ID "4" exists before trying to update its description
        assertNotNull(service.getAppointment("4"), "Appointment with ID '4' should exist before updating description.");

        // Update appointment description
        service.updateAppointmentDesc("New Description", "4");

        // Display the current state of the appointment list after the update
        System.out.println("After Update in Test:");
        service.displayAppointmentList();

        // Validate the updated description
        Appointment updatedAppointment = service.getAppointment("4");
        assertEquals("New Description", updatedAppointment.getAppointmentDesc(), "Appointment description was not updated.");

        // Ensure that the appointment with ID "4" still exists after updating its description
        assertNotNull(service.getAppointment("4"), "Appointment with ID '4' should still exist after updating description.");
    }

    @Test
    @Order(4)
    @DisplayName("Test to ensure that service correctly deletes appointments")
    void testDeleteAppointment() {
        service.addAppointment(createDate(2024, Calendar.JANUARY, 5), "Description");
        boolean deleted = service.deleteAppointment("5");

        assertTrue(deleted, "Appointment was not deleted.");

        // Check that the appointment is not found after deletion
        Appointment deletedAppointment = service.getAppointment("5");
        assertNull(deletedAppointment, "Appointment was not deleted.");
    }

    @Test
    @Order(1)
    @DisplayName("Test to ensure that service can add an appointment")
    void testAddAppointment() {
        // Display the current state of the appointment list before the addition
        System.out.println("Before Addition in Test:");
        service.displayAppointmentList();

        // Add a new appointment with a valid date and description
        Date appointmentDate = createDate(2024, Calendar.FEBRUARY, 2);
        String appointmentDesc = "Meeting with Client";
        String appointmentID = service.addAppointment(appointmentDate, appointmentDesc);

        // Display the current state of the appointment list after the addition
        System.out.println("After Addition in Test:");
        service.displayAppointmentList();

        // Validate that the added appointment exists in the list
        assertNotNull(service.getAppointment(appointmentID), "Added appointment should exist in the list.");
    }


}