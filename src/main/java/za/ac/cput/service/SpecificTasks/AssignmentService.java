package za.ac.cput.service.SpecificTasks;

import za.ac.cput.Domain.SpecificTasks.Assignment;
import za.ac.cput.service.IService;

import java.util.Set;

public interface AssignmentService extends IService<Assignment, String> {
    Set<Assignment> getAll();
}
