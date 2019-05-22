package za.ac.cput.Factory.Team;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Team.TeamMemberTask;
import za.ac.cput.Factory.Team.TeamMemberTaskFactory;

public class TeamMemberTaskFactoryTest {

    private String taskId;
    private String taskDesc;
    private String taskDueDate;
    private String memberId;

    @Before
    public void setUp() throws Exception {
        this.taskId = "1";
        this.taskDesc = "Document all findings";
        this.taskDueDate = "        String taskDueDate = \"20/8/19\";\n";
        this.memberId = "1";
    }

    @Test
    public void buildTeamMemberTask() {
        TeamMemberTask teamMemberTask = TeamMemberTaskFactory.buildTeamMemberTask(taskId, taskDesc, taskDueDate, memberId);
        Assert.assertNotNull(teamMemberTask.getTaskId());
        Assert.assertNotNull(teamMemberTask);
    }
}