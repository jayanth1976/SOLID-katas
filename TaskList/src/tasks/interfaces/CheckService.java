package tasks.interfaces;

import tasks.implementations.Task;

import java.util.List;
import java.util.Map;

public interface CheckService {

    public void check(String idString, Map<String, List<Task>> tasks);
    public void uncheck(String idString,Map<String, List<Task>> tasks);
}
