package tasks.implementations;

import tasks.interfaces.Deadline;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class DeadlineImpl implements Deadline {
    @Override
    public void setDeadline(String taskId, Date deadline, Map<String, List<Task>> tasks) {


        String numericString = taskId.replaceAll("\\D", "");

        int result = Integer.parseInt(numericString);

        System.out.println(deadline);
        System.out.println(result);
        for (List<Task> projectTasks : tasks.values()) {
            for (Task task : projectTasks) {
                if (task.getId() == result) {
                    task.setDeadline(deadline);
                    return;
                }
            }
        }

        System.out.println("Task with ID " + taskId + " not found.");
    }
}
