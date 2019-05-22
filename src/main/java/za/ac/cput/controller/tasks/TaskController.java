package za.ac.cput.controller.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Tasks.Task;
import za.ac.cput.Factory.Tasks.TaskFactory;
import za.ac.cput.service.Tasks.TaskService;

import java.util.Set;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    @Qualifier("taskServiceImpl")
    private TaskService service;

    @PostMapping("/create/{taskId, taskDesc, taskDueDate}")
    @ResponseBody
    public Task create(@PathVariable String taskId, String taskDesc, String taskDueDate) {
        Task task = TaskFactory.buildTask(taskId, taskDesc, taskDueDate);
        return service.create(task);
    }

    @PostMapping("/update")
    @ResponseBody
    public Task update(Task task) {
        return service.update(task);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Task read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Task> getAll() {
        return service.getAll();
    }
}
