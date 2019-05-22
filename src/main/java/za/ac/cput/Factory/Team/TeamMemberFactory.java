package za.ac.cput.Factory.Team;

import za.ac.cput.Domain.Team.TeamMember;

public class TeamMemberFactory {
    public static TeamMember buildTeamMember(String memberId, String memberName) {
        return new TeamMember.Builder()
                .memberId(memberId)
                .memberName(memberName)
                .build();
    }
}
