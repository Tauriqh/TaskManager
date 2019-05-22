package za.ac.cput.Factory.SpecificTasks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.SpecificTasks.Project;

import java.util.Set;

public class ProjectFactoryTest {

    private String projectId;
    private String projectName;
    private String dueDate;
    private boolean complete;
    private Set<String> taskId;

    @Before
    public void setUp() throws Exception {
        this.projectId = "1";
        this.projectName = "Project 3";
        this.dueDate = "11/11/19";
        this.complete = false;
        this.taskId.add("4");
        this.taskId.add("5");
        this.taskId.add("6");
    }

    @Test
    public void buildProject() {
        Project project = ProjectFactory.buildProject(projectId, projectName, dueDate, complete, taskId);
        Assert.assertNotNull(project.getProjectId());
        Assert.assertNotNull(project);
    }
}