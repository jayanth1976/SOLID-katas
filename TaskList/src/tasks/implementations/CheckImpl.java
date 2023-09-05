package tasks.implementations;

import tasks.interfaces.CheckService;

import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class CheckImpl implements CheckService {

    public void setDone(String idString, boolean done,Map<String, List<Task>> tasks) {

        String numericString = idString.replaceAll("\\D", "");
        int id = Integer.parseInt(numericString);
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }

    @Override
    public void check(String idString,Map<String, List<Task>> tasks) {
        setDone(idString,true,tasks);
    }

    @Override
    public void uncheck(String idString,Map<String, List<Task>> tasks) {
        setDone(idString,false,tasks);
    }
}
