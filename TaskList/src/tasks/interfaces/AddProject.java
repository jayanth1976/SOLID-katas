package tasks.interfaces;

import tasks.implementations.Task;

import java.util.List;
import java.util.Map;

public interface AddProject {

    public void addProject(String name, Map<String, List<Task>> tasks);
}
