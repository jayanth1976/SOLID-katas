package tasks.implementations;

import tasks.interfaces.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Execute implements CommandLine {

    public Show show;
    public Add add;
    public CheckService checkService;
    public HelperInterface helperInterface;
    public DisplayError displayError;
    public DeleteTask deleteTask;
    public Deadline deadline;
    public DueToday dueToday;
    public TasksByDeadline tasksByDeadline;
    public  Execute(){
       this.show=  new ShowImpl();
       this.add=new Add();
       this.checkService=new CheckImpl();
       this.helperInterface=new Help();
       this.displayError=new Error();
       this.deleteTask=new DeleteImpl();
       this.deadline=new DeadlineImpl();
       this.dueToday=new DueTodayImpl();
       this.tasksByDeadline=new TasksByDeadlineImpl();
    }


    public  void execute(String commandLine, Map<String, List<Task>> tasks ) throws ParseException {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "show":
                show.show(tasks);
                break;
            case "add":
                add.add(commandRest[1],tasks);
                break;
            case "check":
                checkService.check(commandRest[1],tasks);
                break;
            case "uncheck":
                checkService.uncheck(commandRest[1],tasks);
                break;
            case "delete":
                deleteTask.deleteTask(commandRest[1],tasks);
                break;
            case "deadline":
                String[] commandRe = commandRest[1].split(" ", 2);
//                int taskId = parseInt(commandRe[0]);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date deadlineDate = sdf.parse(commandRe[1]);
                deadline.setDeadline(commandRe[0], deadlineDate, tasks);
                break;
            case "today":
                dueToday.showTasksDueToday(tasks);
                break;
            case "view":
                String viewCommand = commandRest[1];
                switch (viewCommand) {
                    case "by deadline":
                        tasksByDeadline.viewTasksByDeadline(tasks);
                        break;
                    case "by project":
                        show.show(tasks);
                        break;
                    default:
                        displayError.error(command);
                        break;
                }
                break;
            case "help":
                helperInterface.help();
                break;
            default:
                displayError.error(command);
                break;
        }

    }

}
