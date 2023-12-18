package Appointment;
public class Contact {

    private String contactId;
    private String firstName;
    private String lastName;
    private String phoneNum;
    private String addressNum;

    // Constructor for creating a Contact object with validation
    public Contact(String contactId, String firstName, String lastName, String phoneNum, String addressNum) {
        // Validate and set the contact ID
        validateId(contactId);
        // Validate and set the first name
        validateName(firstName, "Invalid First Name");
        // Validate and set the last name
        validateName(lastName, "Invalid Last Name");
        // Validate and set the phone number
        validatePhoneNum(phoneNum);
        // Validate and set the address
        validateAddressNum(addressNum);

        // Assign validated values to the instance variables
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.addressNum = addressNum;
    }

    // Getter methods for retrieving contact information
    public String getId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phoneNum;
    }

    public String getAddress() {
        return addressNum;
    }

    // Setter methods for updating contact information with validation
    public void setFirstName(String fName) {
        // Validate and set the first name
        validateName(fName, "Invalid First Name");
        this.firstName = fName;
    }

    public void setLastName(String lName) {
        // Validate and set the last name
        validateName(lName, "Invalid Last Name");
        this.lastName = lName;
    }

    public void setPhoneNum(String newPhoneNum) {
        // Validate and set the phone number
        validatePhoneNum(newPhoneNum);
        this.phoneNum = newPhoneNum;
    }

    public void setAddressNum(String newAddressNum) {
        // Validate and set the address
        validateAddressNum(newAddressNum);
        this.addressNum = newAddressNum;
    }

    // Private method to validate contact ID
    private void validateId(String id) {
        if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("Invalid ID");
        }
    }

    // Private method to validate name (common method for first and last names)
    private void validateName(String name, String errorMessage) {
        if (name == null || name.length() > 10) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    // Private method to validate phone number
    private void validatePhoneNum(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }
    }

    // Private method to validate address
    private void validateAddressNum(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid Address");
        }
    }
}
