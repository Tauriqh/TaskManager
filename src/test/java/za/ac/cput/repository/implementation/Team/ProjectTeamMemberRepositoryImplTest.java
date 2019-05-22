package za.ac.cput.repository.implementation.Team;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Team.ProjectTeamMember;
import za.ac.cput.Factory.Team.ProjectTeamMemberFactory;
import za.ac.cput.repository.Team.ProjectTeamMemberRepository;
import za.ac.cput.repository.Team.impl.ProjectTeamMemberRepositoryImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProjectTeamMemberRepositoryImplTest {

    private ProjectTeamMemberRepository repository;
    private ProjectTeamMember projectTeamMember;

    private ProjectTeamMember getSaved() {
        Set<ProjectTeamMember> saved = this.repository.getAll();
        return saved.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ProjectTeamMemberRepositoryImpl.getRepository();
        this.projectTeamMember = ProjectTeamMemberFactory.buildProjectTeamMember("1","1");
    }

    @Test
    public void create() {
        ProjectTeamMember info = this.repository.create(this.projectTeamMember);
        d_getAll();
        Assert.assertSame(info, this.projectTeamMember);
    }

    @Test
    public void read() {
        ProjectTeamMember saved = getSaved();
        ProjectTeamMember read = this.repository.read(saved.getProjectId());
        System.out.println("In read, read = " + read);
        Assert.assertEquals(saved, read);
        d_getAll();
    }

    @Test
    public void update() {
        String updateString = "10";
        ProjectTeamMember projectTeamMember = new ProjectTeamMember.Builder().copy(getSaved()).memberId(updateString).build();
        System.out.println("In update, about_to_updated = " + projectTeamMember);
        ProjectTeamMember updated = this.repository.update(projectTeamMember);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(updateString, updated.getMemberId());
        d_getAll();
    }

    @Test
    public void e_delete() {
        ProjectTeamMember saved = getSaved();
        d_getAll();
        this.repository.delete(saved.getProjectId());
        d_getAll();
        Set<ProjectTeamMember> tasks = this.repository.getAll();
        Assert.assertEquals(0, tasks.size());
    }

    @Test
    public void d_getAll() {
        Set<ProjectTeamMember> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
        //Assert.assertEquals(1, projectTeamMembers.size());
    }
}