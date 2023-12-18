package Appointment;
import java.util.ArrayList;

public class ContactService {

    // Variables consistent with the Contact class
    private static String contactId;
    // Create a structure to store data of contacts
    private static ArrayList<Contact> contactList = new ArrayList<>();


    // Generate unique Id
    public static String generateUniqueId() {
        // Initiates a value if the list is empty
        if (getContactList().isEmpty()) {
            contactId = "1000000001";
        } else {
            // Get the latest value of the list and increment
            int arraySize = getContactList().size();
            contactId = String.valueOf(Integer.parseInt(getContactList().get(arraySize - 1).getId()) + 1);
        }

        // Return the unique Id
        return contactId;
    }

    // Add a new contact with provided details
    public void addContact(String fName, String lName, String phone, String address) {
        // Generate a unique Id
        String ID = generateUniqueId();
        // Create a new contact object
        Contact contact = new Contact(ID, fName, lName, phone, address);
        // Add the contact to the list
        getContactList().add(contact);
    }

    // Add a new contact and check for uniqueness
    public void addContact(Contact newContact) {
        // Get the ID of the new contact
        String tempId = newContact.getId();
        // Check for uniqueness
        for (Contact existingContact : getContactList()) {
            if (tempId.equals(existingContact.getId())) {
                throw new IllegalArgumentException("Contact ID Must Be Unique");
            }
        }
        // Add the new contact to the list
        getContactList().add(newContact);
    }

    // Update the first name of a contact
    public void updateFirstName(String uniqueId, String firstName) {
        // Iterate through the contact list
        for (Contact contact : getContactList()) {
            // Find the contact with the specified ID
            if (uniqueId.equals(contact.getId())) {
                // Update the first name
                contact.setFirstName(firstName);
                // Break once the update is done, assuming IDs are unique
                break;
            }
        }
    }

    // Update the last name of a contact
    public void updateLastName(String uniqueId, String lastName) {
        for (Contact contact : getContactList()) {
            if (uniqueId.equals(contact.getId())) {
                contact.setLastName(lastName);
                break;
            }
        }
    }

    // Update the phone number of a contact
    public void updatePhoneNum(String uniqueId, String phoneNum) {
        for (Contact contact : getContactList()) {
            if (uniqueId.equals(contact.getId())) {
                contact.setPhoneNum(phoneNum);
                break;
            }
        }
    }

    // Update the address of a contact
    public void updateAddress(String uniqueId, String addressNum) {
        for (Contact contact : getContactList()) {
            if (uniqueId.equals(contact.getId())) {
                contact.setAddressNum(addressNum);
                break;
            }
        }
    }

    // Delete a contact from the list
    public void deleteContact(String uniqueId) {
        // Remove the contact with the specified ID using removeIf
        getContactList().removeIf(contact -> uniqueId.equals(contact.getId()));
    }

	public static ArrayList<Contact> getContactList() {
		return contactList;
	}

	public static void setContactList(ArrayList<Contact> contactList) {
		ContactService.contactList = contactList;
	}
}
