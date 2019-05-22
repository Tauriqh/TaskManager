package za.ac.cput.Factory.Tasks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Tasks.Task;
import za.ac.cput.Factory.Tasks.TaskFactory;

public class TaskFactoryTest {

    private String taskId;
    private String taskDesc;
    private String taskDueDate;

    @Before
    public void setUp() throws Exception {
        this.taskId = "1";
        this.taskDesc = "Write the complete narrative of your application in a README.md using Markdown";
        this.taskDueDate = "17/04/19";
    }

    @Test
    public void buildTask() {
        Task task = TaskFactory.buildTask(taskId, taskDesc, taskDueDate);
        Assert.assertNotNull(task.getTaskId());
        Assert.assertNotNull(task);
    }
}