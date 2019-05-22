package za.ac.cput.service.Tasks;

import za.ac.cput.Domain.Tasks.Task;
import za.ac.cput.service.IService;

import java.util.Set;

public interface TaskService  extends IService<Task, String> {
    Set<Task> getAll();
}
