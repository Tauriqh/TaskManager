package za.ac.cput.repository.implementation.SpecificTasks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.SpecificTasks.Assignment;
import za.ac.cput.Factory.SpecificTasks.AssignmentFactory;
import za.ac.cput.repository.SpecificTasks.AssignmentRepository;
import za.ac.cput.repository.SpecificTasks.impl.AssignmentRepositoryImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class AssignmentRepositoryImplTest {

    private AssignmentRepository repository;
    private Assignment assignment;
    private List<String> taskId = new LinkedList<>();

    private Assignment getSaved() {
        Set<Assignment> saved = this.repository.getAll();
        return saved.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = AssignmentRepositoryImpl.getRepository();
        this.taskId.add("1");
        this.taskId.add("2");
        this.taskId.add("3");
        this.assignment = AssignmentFactory.buildAssignment("1","ADP Assignment 6","11/11/19",false,taskId);
    }

    @Test
    public void create() {
        Assignment info = this.repository.create(this.assignment);
        d_getAll();
        Assert.assertSame(info, this.assignment);
        /*System.out.println(this.tests);*/
    }

    @Test
    public void read() {
        Assignment saved = getSaved();
        Assignment read = this.repository.read(saved.getAssignmentId());
        //System.out.println("In read, read = " + read);
        Assert.assertEquals(saved, read);
        d_getAll();
    }

    @Test
    public void update() {
        boolean updateString = true;
        Assignment assignment = new Assignment.Builder().copy(getSaved()).complete(updateString).build();
        //System.out.println("In update, about_to_updated = " + assignment);
        Assignment updated = this.repository.update(assignment);
        //System.out.println("In update, updated = " + updated);
        Assert.assertSame(updateString, updated.getComplete());
        d_getAll();
    }

    @Test
    public void e_delete() {
        Assignment saved = getSaved();
        d_getAll();
        this.repository.delete(saved.getAssignmentId());
        d_getAll();
        Set<Assignment> tasks = this.repository.getAll();
        Assert.assertEquals(0, tasks.size());
    }

    @Test
    public void d_getAll() {
        Set<Assignment> all = this.repository.getAll();
        //System.out.println("In getAll, all = " + all);
        //Assert.assertEquals(1, users.size());
    }
}
