package za.ac.cput.repository.implementation.SpecificTasks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.SpecificTasks.Tests;
import za.ac.cput.Factory.SpecificTasks.TestsFactory;
import za.ac.cput.repository.SpecificTasks.TestsRepository;
import za.ac.cput.repository.SpecificTasks.impl.TestsRepositoryImpl;

import java.util.Set;

public class TestsRepositoryImplTest {

    private TestsRepository repository;
    private Tests tests;
    private Set<String> taskId;

    private Tests getSaved() {
        Set<Tests> saved = this.repository.getAll();
        return saved.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = TestsRepositoryImpl.getRepository();
        this.taskId.add("7");
        this.taskId.add("8");
        this.taskId.add("9");
        this.tests = TestsFactory.buildTest("1","ADT Chapter 1 test","10/03/19",false,"1",taskId);
    }

    @Test
    public void create() {
        Tests info = this.repository.create(this.tests);
        d_getAll();
        Assert.assertSame(info, this.tests);
        /*System.out.println(this.tests);*/
    }

    @Test
    public void read() {
        Tests saved = getSaved();
        Tests read = this.repository.read(saved.getTestId());
        System.out.println("In read, read = " + read);
        Assert.assertEquals(saved, read);
        d_getAll();
    }

    @Test
    public void update() {
        boolean updateString = true;
        Tests test = new Tests.Builder().copy(getSaved()).complete(updateString).build();
        System.out.println("In update, about_to_updated = " + test);
        Tests updated = this.repository.update(test);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(updateString, updated.getComplete());
        d_getAll();
    }

    @Test
    public void e_delete() {
        Tests saved = getSaved();
        d_getAll();
        this.repository.delete(saved.getTestId());
        d_getAll();
        Set<Tests> tasks = this.repository.getAll();
        Assert.assertEquals(0, tasks.size());
    }

    @Test
    public void d_getAll() {
        Set<Tests> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
        //Assert.assertEquals(1, users.size());
    }
}
