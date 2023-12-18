package Test;
import org.junit.jupiter.api.Test;

import Appointment.Contact;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void createContact() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertNotNull(contact);
        assertEquals("123", contact.getId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void contactIdValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    public void firstNameValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123", null, "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("123", "VeryLongFirstName", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    public void lastNameValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123", "John", null, "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("123", "John", "VeryLongLastName", "1234567890", "123 Main St"));
    }

    @Test
    public void phoneNumValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123", "John", "Doe", null, "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("123", "John", "Doe", "123", "123 Main St"));
    }

    @Test
    public void addressValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123", "John", "Doe", "1234567890", null));
        assertThrows(IllegalArgumentException.class, () -> new Contact("123", "John", "Doe", "1234567890", "VeryLongAddressThatExceedsThirtyCharacters"));
    }
}
