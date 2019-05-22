package za.ac.cput.repository.SpecificTasks.impl;

import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.SpecificTasks.Project;
import za.ac.cput.repository.SpecificTasks.ProjectRepository;

import java.util.*;

@Repository("projectRepository")
public class ProjectRepositoryImpl implements ProjectRepository {

    private static ProjectRepositoryImpl repository = null;
    private Map<String, Project> projects;

    private ProjectRepositoryImpl() {
        this.projects = new HashMap<>();
    }

    public static  ProjectRepository getRepository(){
        if(repository == null) repository = new  ProjectRepositoryImpl();
        return repository;
    }

    public Project create(Project project){
        this.projects.put(project.getProjectId(),project);
        return project;
    }

    public Project read(String projectId){
        return this.projects.get(projectId);
    }

    public Project update(Project project) {
        this.projects.replace(project.getProjectId(),project);
        return this.projects.get(project.getProjectId());
    }

    public void delete(String projectId) {
        this.projects.remove(projectId);
    }

    public  Set<Project> getAll(){
        Collection<Project> projects = this.projects.values();
        Set<Project> set = new HashSet<>();
        set.addAll(projects);
        return set;
    }

}
