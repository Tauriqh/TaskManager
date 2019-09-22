package za.ac.cput.controller.specificTasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.SpecificTasks.Assignment;
import za.ac.cput.Factory.SpecificTasks.AssignmentFactory;
import za.ac.cput.service.SpecificTasks.AssignmentService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {
    @Autowired
    @Qualifier("assignmentServiceImpl")
    private AssignmentService service;

    //@PostMapping("/create/{assignmentId, assignmentName, dueDate, complete, tasks}")
    @PostMapping("/create}")
    @ResponseBody
    //public Assignment create(@PathVariable String assignmentId, String assignmentName, String dueDate, boolean complete, List<String> tasks) {
    public Assignment create(@RequestBody Assignment assignment) {
        //Assignment assignment = AssignmentFactory.buildAssignment(assignmentId, assignmentName, dueDate, complete, tasks);
        //return service.create(assignment);
        return service.create(assignment);
    }

    @PutMapping("/update")
    @ResponseBody
    //public  Assignment update( Assignment assignment) {
    public  Assignment update(@RequestBody Assignment assignment) {
        return service.update(assignment);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public  Assignment read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set< Assignment> getAll() {
        return service.getAll();
    }
}
