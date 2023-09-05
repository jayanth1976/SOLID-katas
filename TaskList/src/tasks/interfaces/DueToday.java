package tasks.interfaces;

import tasks.implementations.Task;

import java.util.List;
import java.util.Map;

public interface DueToday {
    public void showTasksDueToday(Map<String, List<Task>> tasks);
}
