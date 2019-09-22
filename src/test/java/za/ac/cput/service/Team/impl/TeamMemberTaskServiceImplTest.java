package za.ac.cput.service.Team.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Team.TeamMemberTask;
import za.ac.cput.Factory.Team.TeamMemberTaskFactory;
import za.ac.cput.repository.Team.TeamMemberTaskRepository;
import za.ac.cput.repository.Team.impl.TeamMemberTaskRepositoryImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class TeamMemberTaskServiceImplTest {

    private TeamMemberTaskRepository repository;
    private TeamMemberTask teamMemberTask;

    private TeamMemberTask getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = TeamMemberTaskRepositoryImpl.getRepository();
        this.teamMemberTask = TeamMemberTaskFactory.buildTeamMemberTask("1","Document all findings","20/8/19","1");
    }

    @Test
    public void create() {
        TeamMemberTask info = this.repository.create(this.teamMemberTask);
        //System.out.println("In create, created = " + info);
        Assert.assertNotNull(info);
        Assert.assertSame(info, this.teamMemberTask);
    }

    @Test
    public void read() {
        TeamMemberTask saved = getSaved();
        TeamMemberTask read = this.repository.read(saved.getTaskId());
        //System.out.println("In read, read = " + read);
        Assert.assertEquals(saved, read);
    }

    @Test
    public void update() {
        String updateString = "Code the interface";
        TeamMemberTask updated = new TeamMemberTask.Builder().copy(getSaved()).taskDesc(updateString).build();
        //System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(updateString, updated.getTaskDesc());
    }

    @Test
    public void e_delete() {
        TeamMemberTask saved = getSaved();
        this.repository.delete(saved.getTaskId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<TeamMemberTask> all = this.repository.getAll();
        //System.out.println("In getAll, all = " + all);
        //Assert.assertEquals(1, teamMemberTasks.size());
    }
}