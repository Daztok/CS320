package Test;
import org.junit.jupiter.api.Test;

import Appointment.Task;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

	@Test
	public void taskDescValidation() {
	    // Test null task description
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Task("Task 1", null);
	    }, "Task description cannot be null or empty");

	    // Test empty task description
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Task("Task 1", "");
	    }, "Task description cannot be null or empty");

	    // Test long task description (should be truncated)
	    assertDoesNotThrow(() -> {
	        new Task("Task 1", "VeryLongDescriptionThatExceedsFiftyCharactersAndShouldNotBeAllowed");
	    }, "Task description should not throw an exception");

	    // Test valid task description
	    assertDoesNotThrow(() -> {
	        new Task("Task 1", "ShortDescription");
	    }, "Task description should not throw an exception");
	}

}
