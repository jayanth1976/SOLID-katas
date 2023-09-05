package tasks.implementations;

import tasks.interfaces.Show;

import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class ShowImpl implements Show {
    public void show(Map<String, List<Task>> tasks) {
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            out.println(project.getKey());
            for (Task task : project.getValue()) {
                out.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            out.println();
        }
    }
}
