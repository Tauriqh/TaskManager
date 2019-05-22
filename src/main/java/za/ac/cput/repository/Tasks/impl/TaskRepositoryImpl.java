package za.ac.cput.repository.Tasks.impl;

import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Tasks.Task;
import za.ac.cput.repository.Tasks.TaskRepository;

import java.util.*;

@Repository("taskRepository")
public class TaskRepositoryImpl   implements TaskRepository {

    private static TaskRepositoryImpl repository = null;
    private Map<String, Task> tasks;

    private TaskRepositoryImpl() {
        this.tasks = new HashMap<>();
    }

    public static TaskRepository getRepository(){
        if(repository == null) repository = new TaskRepositoryImpl();
        return repository;
    }

    public Task create(Task task){
        this.tasks.put(task.getTaskId(),task);
        return task;
    }

    public Task read(String taskId){
        return this.tasks.get(taskId);
    }

    public Task update(Task task) {
        this.tasks.replace(task.getTaskId(),task);
        return this.tasks.get(task.getTaskId());
    }

    public void delete(String taskId) {
        this.tasks.remove(taskId);
    }

    public  Set<Task> getAll(){
        Collection<Task> tasks = this.tasks.values();
        Set<Task> set = new HashSet<>();
        set.addAll(tasks);
        return set;
    }

}