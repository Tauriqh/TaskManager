package za.ac.cput.service.Tasks.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Tasks.Task;
import za.ac.cput.Factory.Tasks.TaskFactory;
import za.ac.cput.repository.Tasks.TaskRepository;
import za.ac.cput.repository.Tasks.impl.TaskRepositoryImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class TaskServiceImplTest {
    private TaskRepository repository;
    private Task task;

    private Task getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = TaskRepositoryImpl.getRepository();
        this.task = TaskFactory.buildTask("1","Write the complete narrative of your application in a README.md using Markdown","17/04/19");
    }

    @Test
    public void create() {
        Task info = this.repository.create(this.task);
        System.out.println("In create, created = " + info);
        Assert.assertSame(info, this.task);
    }

    @Test
    public void read() {
        Task saved = getSaved();
        Task read = this.repository.read(saved.getTaskId());
        System.out.println("In read, read = " + read);
        Assert.assertEquals(saved, read);
    }

    @Test
    public void update() {
        String updateString = "Design the interface";
        Task task = new Task.Builder().copy(getSaved()).taskDesc(updateString).build();
        System.out.println("In update, updated = " + task);
        this.repository.update(task);
        Assert.assertSame(updateString, task.getTaskDesc());
    }

    @Test
    public void e_delete() {
        Task saved = getSaved();
        this.repository.delete(saved.getTaskId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Task> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
        //Assert.assertEquals(1, TaskController.size());
    }
}