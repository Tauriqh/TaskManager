package za.ac.cput.service.SpecificTasks.impl;

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


public class AssignmentServiceImplTest {

    private AssignmentRepository repository;
    private Assignment assignment;
    private List<String> taskId = new LinkedList<>();

    private Assignment getSaved() {
        return this.repository.getAll().iterator().next();
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
        //System.out.println("In create, created = " + info);
        Assert.assertSame(info, this.assignment);
    }

    @Test
    public void read() {
        Assignment saved = getSaved();
        Assignment read = this.repository.read(saved.getAssignmentId());
        //System.out.println("In read, read = " + read);
        Assert.assertEquals(saved, read);
    }

    @Test
    public void update() {
        boolean updateString = true;
        Assignment assignment = new Assignment.Builder().copy(getSaved()).complete(updateString).build();
        //System.out.println("In update, about_to_updated = " + assignment);
        this.repository.update(assignment);
        Assert.assertSame(updateString, assignment.getComplete());
    }

    @Test
    public void e_delete() {
        Assignment saved = getSaved();
        this.repository.delete(saved.getAssignmentId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Assignment> all = this.repository.getAll();
        //System.out.println("In getAll, all = " + all);
    }
}