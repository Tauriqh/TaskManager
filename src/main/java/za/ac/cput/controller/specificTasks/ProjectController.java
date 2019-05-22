package za.ac.cput.controller.specificTasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.SpecificTasks.Project;
import za.ac.cput.Factory.SpecificTasks.ProjectFactory;
import za.ac.cput.service.SpecificTasks.ProjectService;

import java.util.Set;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    @Qualifier("projectServiceImpl")
    private ProjectService service;

    @PostMapping("/create/{projectId, projectName, dueDate, complete, tasks}")
    @ResponseBody
    public Project create(@PathVariable String projectId, String projectName, String dueDate, boolean complete, Set<String> tasks) {
        Project project = ProjectFactory.buildProject(projectId, projectName, dueDate, complete, tasks);
        return service.create(project);
    }

    @PostMapping("/update")
    @ResponseBody
    public Project update(Project project) {
        return service.update(project);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Project read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Project> getAll() {
        return service.getAll();
    }
}
