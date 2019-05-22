package za.ac.cput.service.SpecificTasks.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.SpecificTasks.Tests;
import za.ac.cput.Factory.SpecificTasks.TestsFactory;
import za.ac.cput.repository.SpecificTasks.TestsRepository;
import za.ac.cput.repository.SpecificTasks.impl.TestsRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class TestServiceImplTest {
    private TestsRepository repository;
    private Tests tests;
    private Set<String> taskId;

    private Tests getSaved() {
        return this.repository.getAll().iterator().next();
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
        System.out.println("In create, created = " + info);
        Assert.assertSame(info, this.tests);
    }

    @Test
    public void read() {
        Tests saved = getSaved();
        Tests read = this.repository.read(saved.getTestId());
        System.out.println("In read, read = " + read);
        Assert.assertEquals(saved, read);
    }

    @Test
    public void update() {
        boolean updateString = true;
        Tests test = new Tests.Builder().copy(getSaved()).complete(updateString).build();
        System.out.println("In update, about_to_updated = " + test);
        this.repository.update(test);
        Assert.assertSame(updateString, test.getComplete());
    }

    @Test
    public void e_delete() {
        Tests saved = getSaved();
        this.repository.delete(saved.getTestId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Tests> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}
