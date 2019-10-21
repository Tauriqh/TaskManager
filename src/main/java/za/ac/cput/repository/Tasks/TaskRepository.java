package za.ac.cput.repository.tasks;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.tasks.Task;


@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

}