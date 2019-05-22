package za.ac.cput.repository.SpecificTasks;

import za.ac.cput.Domain.SpecificTasks.Project;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface ProjectRepository extends IRepository<Project, String> {
    Set<Project> getAll();
}
