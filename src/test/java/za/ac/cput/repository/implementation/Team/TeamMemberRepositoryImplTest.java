package za.ac.cput.repository.implementation.Team;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Team.TeamMember;
import za.ac.cput.Factory.Team.TeamMemberFactory;
import za.ac.cput.repository.Team.TeamMemberRepository;
import za.ac.cput.repository.Team.impl.TeamMemberRepositoryImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TeamMemberRepositoryImplTest {

    private TeamMemberRepository repository;
    private TeamMember teamMember;

    private TeamMember getSaved() {
        Set<TeamMember> saved = this.repository.getAll();
        return saved.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = TeamMemberRepositoryImpl.getRepository();
        this.teamMember = TeamMemberFactory.buildTeamMember("1","Steve");
    }

    @Test
    public void create() {
        TeamMember info = this.repository.create(this.teamMember);
        d_getAll();
        Assert.assertSame(info, this.teamMember);
    }

    @Test
    public void read() {
        TeamMember saved = getSaved();
        TeamMember read = this.repository.read(saved.getMemberId());
        //System.out.println("In read, read = " + read);
        Assert.assertEquals(saved, read);
        d_getAll();
    }

    @Test
    public void update() {
        String updateString = "Willy";
        TeamMember teamMember = new TeamMember.Builder().copy(getSaved()).memberName(updateString).build();
        //System.out.println("In update, about_to_updated = " + teamMember);
        TeamMember updated = this.repository.update(teamMember);
        //System.out.println("In update, updated = " + updated);
        Assert.assertSame(updateString, updated.getMemberName());
        d_getAll();
    }

    @Test
    public void e_delete() {
        TeamMember saved = getSaved();
        d_getAll();
        this.repository.delete(saved.getMemberId());
        d_getAll();
        Set<TeamMember> tasks = this.repository.getAll();
        Assert.assertEquals(0, tasks.size());
    }

    @Test
    public void d_getAll() {
        Set<TeamMember> all = this.repository.getAll();
        //System.out.println("In getAll, all = " + all);
        //Assert.assertEquals(1, users.size());
    }
}