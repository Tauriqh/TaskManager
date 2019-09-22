package za.ac.cput.service.Team.impl;

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

import static org.junit.Assert.*;

public class ProjectTeamMemberServiceImplTest {

    private ProjectTeamMemberRepository repository;
    private ProjectTeamMember projectTeamMember;

    private ProjectTeamMember getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ProjectTeamMemberRepositoryImpl.getRepository();
        this.projectTeamMember = ProjectTeamMemberFactory.buildProjectTeamMember("1","1");
    }

    @Test
    public void create() {
        ProjectTeamMember info = this.repository.create(this.projectTeamMember);
        //System.out.println("In create, created = " + info);
        Assert.assertSame(info, this.projectTeamMember);
    }

    @Test
    public void read() {
        ProjectTeamMember saved = getSaved();
        ProjectTeamMember read = this.repository.read(saved.getProjectId());
        //System.out.println("In read, read = " + read);
        Assert.assertEquals(saved, read);
    }

    @Test
    public void update() {
        String updateString = "10";
        ProjectTeamMember projectTeamMember = new ProjectTeamMember.Builder().copy(getSaved()).memberId(updateString).build();
        //System.out.println("In update, updated = " + projectTeamMember);
        this.repository.update(projectTeamMember);
        Assert.assertSame(updateString, projectTeamMember.getMemberId());
    }

    @Test
    public void e_delete() {
        ProjectTeamMember saved = getSaved();
        this.repository.delete(saved.getProjectId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<ProjectTeamMember> all = this.repository.getAll();
        //System.out.println("In getAll, all = " + all);
        //Assert.assertEquals(1, projectTeamMembers.size());
    }
}