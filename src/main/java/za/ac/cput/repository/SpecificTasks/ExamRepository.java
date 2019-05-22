package za.ac.cput.repository.SpecificTasks;

import za.ac.cput.Domain.SpecificTasks.Exam;
import za.ac.cput.repository.IRepository;

import java.util.Set;


public interface ExamRepository extends IRepository<Exam, String> {
    Set<Exam> getAll();
}
