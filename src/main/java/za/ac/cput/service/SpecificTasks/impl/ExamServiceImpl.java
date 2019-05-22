package za.ac.cput.service.SpecificTasks.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.SpecificTasks.Exam;
import za.ac.cput.repository.SpecificTasks.ExamRepository;
import za.ac.cput.service.SpecificTasks.ExamService;

import java.util.Set;

@Service("examServiceImpl")
public class ExamServiceImpl  implements ExamService {
    @Autowired
    @Qualifier("examRepository")

    private ExamRepository repository;

    @Override
    public Exam create(Exam exam) {
        return repository.create(exam);
    }

    @Override
    public Exam update(Exam exam) {
        return repository.update(exam);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public Exam read(String s) {
        return repository.read(s);
    }

    @Override
    public Set<Exam> getAll() {
        return repository.getAll();
    }
}