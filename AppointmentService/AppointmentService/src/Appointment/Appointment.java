package Appointment;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class Appointment {
    private final String appointmentID;
    private Date appointmentDate;
    private String appointmentDesc;
    private long creationTime; // new field to store creation time
    private static final int MAX_DESC_LENGTH = 50;
    private static final AtomicLong idGenerator = new AtomicLong(1);


 // Constructor
    public Appointment(Date appointmentDate, String appointmentDesc) {
        this.appointmentID = generateUniqueID();

        // Check if the provided date is in the past
        if (appointmentDate != null && appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Cannot set appointment date in the past.");
        }

        // Allow null values for description
        this.appointmentDesc = (appointmentDesc == null) ? "NULL" : appointmentDesc;

        // Validate description length
        if (this.appointmentDesc != null && this.appointmentDesc.length() > MAX_DESC_LENGTH) {
            throw new IllegalArgumentException("Appointment description cannot exceed 50 characters. Please provide a shorter description.");
        }

        this.appointmentDesc = appointmentDesc;

        // Set the appointment date
        this.appointmentDate = appointmentDate;

        // Initialize creation time to current time
        this.creationTime = System.currentTimeMillis();
    }

	// Getter method for getting the creation time
    public long getCreationTime() {
        return creationTime;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentDesc() {
        return appointmentDesc;
    }

    // Setter methods
    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null) {
            throw new IllegalArgumentException("Appointment date cannot be null. Please provide a valid date.");
        }
        if (appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Cannot set appointment date in the past.");
        }
        this.appointmentDate = appointmentDate;
    }

    public void setAppointmentDesc(String appointmentDesc) {
        if (appointmentDesc == null) {
            throw new IllegalArgumentException("Appointment description cannot be null. Please provide a valid description.");
        }
        if (appointmentDesc.isEmpty()) {
        	throw new IllegalArgumentException("Appointment description cannot be empty. Please provide a valid description.");
        } else {
            this.appointmentDesc = appointmentDesc.length() > MAX_DESC_LENGTH ?
                    appointmentDesc.substring(0, MAX_DESC_LENGTH) : appointmentDesc;
        }
    }
 // Private method to generate a unique ID using AtomicLong
    private String generateUniqueID() {
        return String.valueOf(idGenerator.getAndIncrement());
    }
}


