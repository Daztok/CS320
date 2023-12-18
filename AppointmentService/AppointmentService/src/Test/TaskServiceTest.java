package Test;
import org.junit.jupiter.api.Test;

import Appointment.TaskService;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    @Test
    public void addTask() {
        TaskService taskService = new TaskService();
        taskService.addTask("Task 1", "Description for Task 1");
        assertEquals(1, taskService.taskList.size());
    }

    @Test
    public void deleteTask() {
        TaskService taskService = new TaskService();
        taskService.addTask("Task 1", "Description for Task 1");
        taskService.deleteTask(taskService.taskList.get(0).getTaskID());
        assertEquals(0, taskService.taskList.size());
    }

    @Test
    public void updateTaskName() {
        TaskService taskService = new TaskService();
        taskService.addTask("Task 1", "Description for Task 1");
        taskService.updateTaskName(taskService.taskList.get(0).getTaskID(), "Updated Task 1");
        assertEquals("Updated Task 1", taskService.taskList.get(0).getTaskName());
    }

    @Test
    public void updateTaskDesc() {
        TaskService taskService = new TaskService();
        taskService.addTask("Task 1", "Description for Task 1");
        taskService.updateTaskDesc(taskService.taskList.get(0).getTaskID(), "Updated description");
        assertEquals("Updated description", taskService.taskList.get(0).getTaskDesc());
    }
}
