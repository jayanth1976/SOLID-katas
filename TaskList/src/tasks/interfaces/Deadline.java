package tasks.interfaces;

import tasks.implementations.Task;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface Deadline {

    public void setDeadline(String taskId, Date deadline, Map<String, List<Task>> tasks);
}
