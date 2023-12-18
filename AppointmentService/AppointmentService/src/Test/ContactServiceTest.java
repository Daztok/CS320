package Test;
import org.junit.jupiter.api.Test;

import Appointment.ContactService;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

	@Test
	public void addContact() {
	    ContactService contactService = new ContactService();
	    contactService.addContact("John", "Doe", "1234567890", "123 Main St");

	    // Use the getter to access contactList
	    assertEquals(1, ContactService.getContactList().size());
    }

    @Test
    public void deleteContact() {
        ContactService contactService = new ContactService();
        contactService.addContact("John", "Doe", "1234567890", "123 Main St");
        contactService.deleteContact(ContactService.getContactList().get(0).getId());
        assertEquals(0, ContactService.getContactList().size());
    }

    @Test
    public void updateFirstName() {
        ContactService contactService = new ContactService();
        contactService.addContact("John", "Doe", "1234567890", "123 Main St");
        contactService.updateFirstName(ContactService.getContactList().get(0).getId(), "Jane");
        assertEquals("Jane", ContactService.getContactList().get(0).getFirstName());
    }

    @Test
    public void updateLastName() {
        ContactService contactService = new ContactService();
        contactService.addContact("John", "Doe", "1234567890", "123 Main St");
        contactService.updateLastName(ContactService.getContactList().get(0).getId(), "Smith");
        assertEquals("Smith", ContactService.getContactList().get(0).getLastName());
    }

    @Test
    public void updatePhoneNum() {
        ContactService contactService = new ContactService();
        contactService.addContact("John", "Doe", "1234567890", "123 Main St");
        contactService.updatePhoneNum(ContactService.getContactList().get(0).getId(), "9876543210");
        assertEquals("9876543210", ContactService.getContactList().get(0).getPhone());
    }

    @Test
    public void updateAddress() {
        ContactService contactService = new ContactService();
        contactService.addContact("John", "Doe", "1234567890", "123 Main St");
        contactService.updateAddress(ContactService.getContactList().get(0).getId(), "456 Side St");
        assertEquals("456 Side St", ContactService.getContactList().get(0).getAddress());
    }
}
