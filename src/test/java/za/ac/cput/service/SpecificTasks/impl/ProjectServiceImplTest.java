package za.ac.cput.service.SpecificTasks.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.SpecificTasks.Project;
import za.ac.cput.Factory.SpecificTasks.ProjectFactory;
import za.ac.cput.repository.SpecificTasks.ProjectRepository;
import za.ac.cput.repository.SpecificTasks.impl.ProjectRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class ProjectServiceImplTest {
    private ProjectRepository repository;
    private Project project;
    private Set<String> taskId;

    private Project getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ProjectRepositoryImpl.getRepository();
        this.taskId.add("4");
        this.taskId.add("5");
        this.taskId.add("6");
        this.project = ProjectFactory.buildProject("1","Project 3","11/11/19",false,taskId);
    }

    @Test
    public void create() {
        Project info = this.repository.create(this.project);
        System.out.println("In create, created = " + info);
        Assert.assertSame(info, this.project);
    }

    @Test
    public void read() {
        Project saved = getSaved();
        Project read = this.repository.read(saved.getProjectId());
        System.out.println("In read, read = " + read);
        Assert.assertEquals(saved, read);
    }

    @Test
    public void update() {
        boolean updateString = true;
        Project project = new Project.Builder().copy(getSaved()).complete(updateString).build();
        System.out.println("In update, about_to_updated = " + project);
        this.repository.update(project);
        Assert.assertSame(updateString, project.getComplete());
    }

    @Test
    public void e_delete() {
        Project saved = getSaved();
        this.repository.delete(saved.getProjectId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Project> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}
