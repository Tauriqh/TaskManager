package za.ac.cput.service.SpecificTasks.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.SpecificTasks.Assignment;
import za.ac.cput.repository.SpecificTasks.AssignmentRepository;
import za.ac.cput.service.SpecificTasks.AssignmentService;

import java.util.Set;

@Service("assignmentServiceImpl")
public class AssignmentServiceImpl implements AssignmentService {
    @Autowired
    @Qualifier("assignmentRepository")

    private AssignmentRepository repository;

    @Override
    public Assignment create(Assignment assignment) {
        return repository.create(assignment);
    }

    @Override
    public Assignment update(Assignment assignment) {
        return repository.update(assignment);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public Assignment read(String s) {
        return repository.read(s);
    }

    @Override
    public Set<Assignment> getAll() {
        return repository.getAll();
    }
}