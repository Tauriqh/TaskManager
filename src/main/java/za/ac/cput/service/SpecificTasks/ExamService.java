package za.ac.cput.service.SpecificTasks;

import za.ac.cput.Domain.SpecificTasks.Exam;
import za.ac.cput.service.IService;

import java.util.Set;

public interface ExamService extends IService<Exam, String> {
    Set<Exam> getAll();
}
