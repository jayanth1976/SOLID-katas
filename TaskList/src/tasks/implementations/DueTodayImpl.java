package tasks.implementations;

import tasks.interfaces.DueToday;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DueTodayImpl implements DueToday {
    @Override
    public void showTasksDueToday(Map<String, List<Task>> tasks) {
        Date today = new Date(); // Get the current date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String todayDate = sdf.format(today);

        for (List<Task> projectTasks : tasks.values()) {

            for (Task task : projectTasks) {
                Date deadline = task.getDeadline();
                if (deadline != null && sdf.format(deadline).equals(todayDate)) {

                    System.out.println("Task ID: " + task.getId());
                    System.out.println("Description: " + task.getDescription());
                    System.out.println("Deadline: " + sdf.format(deadline));
                    System.out.println();
                }
            }
        }
    }
}
