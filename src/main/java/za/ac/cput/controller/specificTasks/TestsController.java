package za.ac.cput.controller.specificTasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.SpecificTasks.Tests;
import za.ac.cput.Factory.SpecificTasks.TestsFactory;
import za.ac.cput.service.SpecificTasks.TestService;

import java.util.Set;

@RestController
@RequestMapping("/tests")
public class TestsController {
    @Autowired
    @Qualifier("testsServiceImpl")
    private TestService service;

    @PostMapping("/create/{testId, testName, dueDate, complete, materialId, tasks}")
    @ResponseBody
    public Tests create(@PathVariable String testId, String testName, String dueDate, boolean complete, String materialId, Set<String> tasks) {
        Tests tests = TestsFactory.buildTest(testId, testName, dueDate, complete, materialId, tasks);
        return service.create(tests);
    }

    @PostMapping("/update")
    @ResponseBody
    public Tests update(Tests tests) {
        return service.update(tests);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Tests read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Tests> getAll() {
        return service.getAll();
    }
}
