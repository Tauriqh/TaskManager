package za.ac.cput.repository.Tasks;

import za.ac.cput.Domain.Tasks.Task;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface TaskRepository extends IRepository<Task, String> {
    Set<Task> getAll();
}
