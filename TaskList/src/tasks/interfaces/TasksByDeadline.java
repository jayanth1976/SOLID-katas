package tasks.interfaces;

import tasks.implementations.Task;

import java.util.List;
import java.util.Map;

public interface TasksByDeadline {

    public void viewTasksByDeadline(Map<String, List<Task>> tasks);
}
