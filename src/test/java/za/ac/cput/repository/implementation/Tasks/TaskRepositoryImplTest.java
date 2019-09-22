package za.ac.cput.repository.implementation.Tasks;

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

public class TaskRepositoryImplTest {

    private TaskRepository repository;
    private Task task;

    private Task getSaved() {
        Set<Task> saved = this.repository.getAll();
        return saved.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = TaskRepositoryImpl.getRepository();
        this.task = TaskFactory.buildTask("1","Write the complete narrative of your application in a README.md using Markdown","17/04/19");
    }

    @Test
    public void create() {
        Task info = this.repository.create(this.task);
        d_getAll();
        Assert.assertSame(info, this.task);
    }

    @Test
    public void read() {
        Task saved = getSaved();
        Task read = this.repository.read(saved.getTaskId());
        //System.out.println("In read, read = " + read);
        Assert.assertEquals(saved, read);
        d_getAll();
    }

    @Test
    public void update() {
        String updateString = "Design the interface";
        Task task = new Task.Builder().copy(getSaved()).taskDesc(updateString).build();
        //System.out.println("In update, about_to_updated = " + task);
        Task updated = this.repository.update(task);
        //System.out.println("In update, updated = " + updated);
        Assert.assertSame(updateString, updated.getTaskDesc());
        d_getAll();
    }

    @Test
    public void e_delete() {
        Task saved = getSaved();
        d_getAll();
        this.repository.delete(saved.getTaskId());
        d_getAll();
        Set<Task> tasks = this.repository.getAll();
        Assert.assertEquals(0, tasks.size());
    }

    @Test
    public void d_getAll() {
        Set<Task> all = this.repository.getAll();
        //System.out.println("In getAll, all = " + all);
        //Assert.assertEquals(1, TaskController.size());
    }
}