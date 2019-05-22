package za.ac.cput.repository.Team.impl;

import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Team.ProjectTeamMember;
import za.ac.cput.repository.Team.ProjectTeamMemberRepository;

import java.util.*;

@Repository("projectTeamMemberRepository")
public class ProjectTeamMemberRepositoryImpl implements ProjectTeamMemberRepository {

    private static ProjectTeamMemberRepositoryImpl repository = null;
    private Map<String,  ProjectTeamMember>  projectTeamMembers;

    private ProjectTeamMemberRepositoryImpl() {
        this.projectTeamMembers = new HashMap<>();
    }

    public static ProjectTeamMemberRepository getRepository() {
        if (repository == null) repository = new ProjectTeamMemberRepositoryImpl();
        return repository;
    }

    public ProjectTeamMember create(ProjectTeamMember projectTeamMember) {
        this.projectTeamMembers.put(projectTeamMember.getProjectId(),projectTeamMember);
        return projectTeamMember;
    }

    public ProjectTeamMember read(String projectTeamMemberId) {
        return this.projectTeamMembers.get(projectTeamMemberId);
    }

    public ProjectTeamMember update(ProjectTeamMember projectTeamMember) {
        this.projectTeamMembers.replace(projectTeamMember.getProjectId(),projectTeamMember);
        return this.projectTeamMembers.get(projectTeamMember.getProjectId());
    }

    public void delete(String projectTeamMemberId) {
        this.projectTeamMembers.remove(projectTeamMemberId);
    }

    public Set<ProjectTeamMember> getAll() {
        Collection<ProjectTeamMember> projectTeamMembers = this.projectTeamMembers.values();
        Set<ProjectTeamMember> set = new HashSet<>();
        set.addAll(projectTeamMembers);
        return set;
    }

}

