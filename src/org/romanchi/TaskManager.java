package org.romanchi;

import java.util.HashMap;

public class TaskManager {
    private static HashMap <String, Task> tasks;
    static {
        tasks = new HashMap<>();
        tasks.put("NoTask", new NoTask());
        tasks.put("task1", new Task1());
        tasks.put("task2", new Task2());
        tasks.put("task3", new Task3());
        tasks.put("task4", new Task4());
        tasks.put("task5", new Task5());
        tasks.put("task6", new Task6());
    }
    private TaskManager(){}
    public static Task getTask(String taskName){
        Task task = null;
        if((task = tasks.get(taskName)) != null){
            return task;
        }else{
            return tasks.get("NoTask");
        }

    }
}
