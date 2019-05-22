package za.ac.cput.service.Tasks.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Tasks.Task;
import za.ac.cput.repository.Tasks.TaskRepository;
import za.ac.cput.service.Tasks.TaskService;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("taskServiceImpl")
public class TaskServiceImpl implements TaskService {
    @Autowired
    @Qualifier("taskRepository")

    private TaskRepository repository;

    @Override
    public Task create(Task task) {
        return repository.create(task);
    }

    @Override
    public Task update(Task task) {
        return repository.update(task);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public Task read(String s) {
        return repository.read(s);
    }

    @Override
    public Set<Task> getAll() {
        return repository.getAll();
    }
}