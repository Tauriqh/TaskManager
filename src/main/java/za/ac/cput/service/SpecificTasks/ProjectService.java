package za.ac.cput.service.SpecificTasks;

import za.ac.cput.Domain.SpecificTasks.Project;
import za.ac.cput.service.IService;

import java.util.Set;

public interface ProjectService extends IService<Project, String> {
    Set<Project> getAll();
}
