package za.ac.cput.repository.implementation.SpecificTasks;

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

public class ProjectRepositoryImplTest {

    private ProjectRepository repository;
    private Project project;
    private Set<String> taskId;

    private Project getSaved() {
        Set<Project> saved = this.repository.getAll();
        return saved.iterator().next();
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
        d_getAll();
        Assert.assertSame(info, this.project);
    }

    @Test
    public void read() {
        Project saved = getSaved();
        Project read = this.repository.read(saved.getProjectId());
        System.out.println("In read, read = " + read);
        Assert.assertEquals(saved, read);
        d_getAll();
    }

    @Test
    public void update() {
        boolean updateString = true;
        Project project = new Project.Builder().copy(getSaved()).complete(updateString).build();
        System.out.println("In update, about_to_updated = " + project);
        Project updated = this.repository.update(project);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(updateString, updated.getComplete());
        d_getAll();
    }

    @Test
    public void e_delete() {
        Project saved = getSaved();
        d_getAll();
        this.repository.delete(saved.getProjectId());
        d_getAll();
        Set<Project> projects = this.repository.getAll();
        Assert.assertEquals(0, projects.size());
    }

    @Test
    public void d_getAll() {
        Set<Project> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
        //Assert.assertEquals(1, projects.size());
    }
}
