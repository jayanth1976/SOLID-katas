package tasks.implementations;

import tasks.implementations.Task;
import tasks.interfaces.TasksByDeadline;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TasksByDeadlineImpl implements TasksByDeadline {
    @Override
    public void viewTasksByDeadline(Map<String, List<Task>> tasks) {
        List<Task> allTasks = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        for (List<Task> projectTasks : tasks.values()) {
            allTasks.addAll(projectTasks);
        }
        for (Task task : allTasks) {
            System.out.println("Task ID: " + task.getId());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Deadline: " + sdf.format(task.getDeadline()));
            System.out.println();
        }
    }
}
