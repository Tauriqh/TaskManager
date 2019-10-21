package za.ac.cput.controller.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.tasks.Task;
import za.ac.cput.exception.RecordNotFoundException;
import za.ac.cput.service.tasks.impl.TaskServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskServiceImpl service;

    @RequestMapping
    public String getAllTasks(Model model){
        List<Task> list = service.getAllTasks();

        model.addAttribute("tasks", list);
        return "taskView";
    }

    /*@RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editUserById(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException{
        if (id.isPresent()) {
            User entity = service.getUserById(id.get());
            model.addAttribute("user", entity);
        } else {
            model.addAttribute("user", new User());
        }
        return "editUserView";
    }*/

    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editTaskById(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException {
        if (id.isPresent()) {
            Task entity = service.getTaskById(id.get());
            model.addAttribute("task", entity);
        } else {
            model.addAttribute("task", new Task());
        }
        return "editTaskView";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteTaskById(Model model, @PathVariable("id") Long id) throws RecordNotFoundException {
        service.deleteTaskById(id);
        return "redirect:/task";
    }

    @RequestMapping(path = "/createTask", method = RequestMethod.POST)
    public String createOrUpdateTask(Task task)
    {
        service.createOrUpdateTask(task);
        return "redirect:/task";
    }
}
