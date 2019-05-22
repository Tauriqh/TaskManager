package za.ac.cput.Factory.Team;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Team.ProjectTeamMember;
import za.ac.cput.Factory.Team.ProjectTeamMemberFactory;

public class ProjectTeamMemberFactoryTest {

    private String projectId;
    private String memberId;

    @Before
    public void setUp() throws Exception {
        this.projectId = "1";
        this.memberId = "1";
    }

    @Test
    public void buildProjectTeamMember() {
        ProjectTeamMember projectTeamMember = ProjectTeamMemberFactory.buildProjectTeamMember(projectId, memberId);
        Assert.assertNotNull(projectTeamMember.getProjectId());
        Assert.assertNotNull(projectTeamMember);
    }
}