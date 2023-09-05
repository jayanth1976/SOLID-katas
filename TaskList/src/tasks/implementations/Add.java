package tasks.implementations;

import tasks.interfaces.AddProject;
import tasks.interfaces.AddTask;

import java.util.List;
import java.util.Map;

public class Add {

    public AddProject addProject;
    public AddTask addTask;
    public Add(){
        this.addProject= new AddProjectImpl();
        this.addTask=new AddTaskImpl();
    }
    public void add(String commandLine, Map<String, List<Task>> tasks) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject.addProject(subcommandRest[1],tasks);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTask.addTask(projectTask[0], projectTask[1],tasks);
        }
    }
}
