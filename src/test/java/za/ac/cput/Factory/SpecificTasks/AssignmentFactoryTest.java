package za.ac.cput.Factory.SpecificTasks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.SpecificTasks.Assignment;

import java.util.LinkedList;
import java.util.List;

public class AssignmentFactoryTest {

    private String assignmentId;
    private String assignmentName;
    private String dueDate;
    private boolean complete;
    private List<String> taskId = new LinkedList<>();

    @Before
    public void setUp() throws Exception {
        this.assignmentId = "1";
        this.assignmentName = "ADP Assignment 6";
        this.dueDate = "11/11/19";
        this.complete = false;
        this.taskId.add("1");
        this.taskId.add("2");
        this.taskId.add("3");
    }

    @Test
    public void buildAssignment() {
        Assignment assignment = AssignmentFactory.buildAssignment(assignmentId, assignmentName, dueDate, complete, taskId);
        Assert.assertNotNull(assignment.getAssignmentId());
        Assert.assertNotNull(assignment);
    }
}