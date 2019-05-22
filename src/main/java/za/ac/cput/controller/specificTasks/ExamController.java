package za.ac.cput.controller.specificTasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.SpecificTasks.Exam;
import za.ac.cput.Factory.SpecificTasks.ExamFactory;
import za.ac.cput.service.SpecificTasks.ExamService;

import java.util.Set;

@RestController
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    @Qualifier("examServiceImpl")
    private ExamService service;

    @PostMapping("/create/{examId, examName, dueDate, complete, materialId, tasks}")
    @ResponseBody
    public Exam create(@PathVariable String examId, String examName, String dueDate, boolean complete, String materialId, Set<String> tasks) {
        Exam exam = ExamFactory.buildExam(examId, examName, dueDate, complete, materialId, tasks);
        return service.create(exam);
    }

    @PostMapping("/update")
    @ResponseBody
    public Exam update(Exam exam) {
        return service.update(exam);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Exam read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Exam> getAll() {
        return service.getAll();
    }
}
