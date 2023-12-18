package Appointment;
import java.util.concurrent.atomic.AtomicLong;

public class Task {
    private final String taskID;
    private String taskName;
    private String taskDesc;
    private static final AtomicLong idGenerator = new AtomicLong();

    // CONSTRUCTORS
    // Constructor initializes the task ID, task name, and task description.
    // If any parameter is null or empty, it is set to "NULL" to ensure data integrity.
    // Task ID is generated using a static idGenerator to prevent duplicates.
    // Task ID is truncated to a maximum of 10 characters, task name to 20 characters, and description to 50 characters.
    public Task(String taskName, String taskDesc) {
        // TASKID
        // Task ID is generated when the constructor is called.
        // It is set as a final variable, ensuring it is not updatable.
        // The idGenerator is static to prevent duplicates across all tasks.
        String generatedID = String.valueOf(idGenerator.getAndIncrement());
        this.taskID = (generatedID.length() > 10) ? generatedID.substring(0, 10) : generatedID;

        // Validate and set the task name
        setTaskName(taskName);
        // Validate and set the task description
        setTaskDesc(taskDesc);
    }

    // GETTERS
    // Gets the task ID.
    public String getTaskID() {
        return taskID;
    }

    // Gets the task name.
    public String getTaskName() {
        return taskName;
    }

    // Gets the task description.
    public String getTaskDesc() {
        return taskDesc;
    }

    // SETTERS
    // Sets the task name with validation.
    // If the provided name is null or empty, it is set to "NULL".
    // If the name exceeds 20 characters, it is truncated.
    public void setTaskName(String taskName) {
        if (taskName == null) {
            throw new IllegalArgumentException("Task name cannot be null");
        }
        this.taskName = (taskName.isEmpty()) ? "NULL" : (taskName.length() > 20) ? taskName.substring(0, 20) : taskName;
    }

    // Sets the task description with validation.
    // If the provided description is null or empty, it is set to "NULL".
    // If the description exceeds 50 characters, it is truncated.
    public void setTaskDesc(String taskDesc) {
        if (taskDesc == null || taskDesc.isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be null or empty");
        }
        this.taskDesc = (taskDesc.length() > 50) ? taskDesc.substring(0, 50) : taskDesc;
    }
}
