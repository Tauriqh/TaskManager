package za.ac.cput.repository.implementation.Team;

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

public class TeamMemberTaskRepositoryImplTest {

    private TeamMemberTaskRepository repository;
    private TeamMemberTask teamMemberTask;

    private TeamMemberTask getSaved() {
        Set<TeamMemberTask> saved = this.repository.getAll();
        return saved.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = TeamMemberTaskRepositoryImpl.getRepository();
        this.teamMemberTask = TeamMemberTaskFactory.buildTeamMemberTask("1","Document all findings","20/8/19","1");
    }

    @Test
    public void create() {
        TeamMemberTask info = this.repository.create(this.teamMemberTask);
        d_getAll();
        Assert.assertSame(info, this.teamMemberTask);
    }

    @Test
    public void read() {
        TeamMemberTask saved = getSaved();
        TeamMemberTask read = this.repository.read(saved.getTaskId());
        //System.out.println("In read, read = " + read);
        Assert.assertEquals(saved, read);
        d_getAll();
    }

    @Test
    public void update() {
        String updateString = "Code the interface";
        TeamMemberTask task = new TeamMemberTask.Builder().copy(getSaved()).taskDesc(updateString).build();
        //System.out.println("In update, about_to_updated = " + task);
        TeamMemberTask updated = this.repository.update(task);
        //System.out.println("In update, updated = " + updated);
        Assert.assertSame(updateString, updated.getTaskDesc());
        d_getAll();
    }

    @Test
    public void e_delete() {
        TeamMemberTask saved = getSaved();
        d_getAll();
        this.repository.delete(saved.getTaskId());
        d_getAll();
        Set<TeamMemberTask> tasks = this.repository.getAll();
        Assert.assertEquals(0, tasks.size());
    }

    @Test
    public void d_getAll() {
        Set<TeamMemberTask> all = this.repository.getAll();
        //System.out.println("In getAll, all = " + all);
        //Assert.assertEquals(1, teamMemberTasks.size());
    }
}