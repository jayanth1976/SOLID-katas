package tasks.interfaces;

import tasks.implementations.Task;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface CommandLine {

    public  void execute(String commandLine, Map<String, List<Task>> tasks ) throws ParseException;
}
