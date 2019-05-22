package za.ac.cput.Factory.Team;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Team.TeamMember;
import za.ac.cput.Factory.Team.TeamMemberFactory;

public class TeamMemberFactoryTest {

    private String memberId;
    private String memberName;

    @Before
    public void setUp() throws Exception {
        this.memberId = "1";
        this.memberName = "Steve";
    }

    @Test
    public void buildTeamMember() {
        TeamMember teamMember = TeamMemberFactory.buildTeamMember(memberId, memberName);
        Assert.assertNotNull(teamMember.getMemberId());
        Assert.assertNotNull(teamMember);
    }
}
