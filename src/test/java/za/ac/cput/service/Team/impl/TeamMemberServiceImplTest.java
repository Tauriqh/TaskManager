package za.ac.cput.service.Team.impl;

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

import static org.junit.Assert.*;

public class TeamMemberServiceImplTest {

    private TeamMemberRepository repository;
    private TeamMember teamMember;

    private TeamMember getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = TeamMemberRepositoryImpl.getRepository();
        this.teamMember = TeamMemberFactory.buildTeamMember("1","Steve");
    }

    @Test
    public void create() {
        TeamMember info = this.repository.create(this.teamMember);
        System.out.println("In create, created = " + info);
        Assert.assertSame(info, this.teamMember);
    }

    @Test
    public void read() {
        TeamMember saved = getSaved();
        TeamMember read = this.repository.read(saved.getMemberId());
        System.out.println("In read, read = " + read);
        Assert.assertEquals(saved, read);
    }

    @Test
    public void update() {
        String updateString = "Willy";
        TeamMember teamMember = new TeamMember.Builder().copy(getSaved()).memberName(updateString).build();
        System.out.println("In update, about_to_updated = " + teamMember);
        this.repository.update(teamMember);
        Assert.assertSame(updateString, teamMember.getMemberName());
    }

    @Test
    public void e_delete() {
        TeamMember saved = getSaved();
        this.repository.delete(saved.getMemberId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<TeamMember> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
        //Assert.assertEquals(1, users.size());
    }
}