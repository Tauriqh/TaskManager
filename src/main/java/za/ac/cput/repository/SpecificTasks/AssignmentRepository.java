package za.ac.cput.repository.SpecificTasks;

import za.ac.cput.Domain.SpecificTasks.Assignment;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface AssignmentRepository extends IRepository<Assignment, String> {
    Set<Assignment> getAll();
}
