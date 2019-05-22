package za.ac.cput.Factory.Team;

import za.ac.cput.Domain.Team.ProjectTeamMember;

public class ProjectTeamMemberFactory {
    public static ProjectTeamMember buildProjectTeamMember(String projectId, String memberId) {
        return new ProjectTeamMember.Builder()
                .projectId(projectId)
                .memberId(memberId)
                .build();
    }
}
