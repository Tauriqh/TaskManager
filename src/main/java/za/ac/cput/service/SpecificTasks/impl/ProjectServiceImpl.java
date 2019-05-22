package za.ac.cput.service.SpecificTasks.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.SpecificTasks.Project;
import za.ac.cput.repository.SpecificTasks.ProjectRepository;
import za.ac.cput.service.SpecificTasks.ProjectService;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("projectServiceImpl")
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    @Qualifier("projectRepository")

    private ProjectRepository repository;

    @Override
    public Project create(Project project) {
        return repository.create(project);
    }

    @Override
    public Project update(Project project) {
        return repository.update(project);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public Project read(String s) {
        return repository.read(s);
    }

    @Override
    public Set<Project> getAll() {
        return repository.getAll();
    }
}