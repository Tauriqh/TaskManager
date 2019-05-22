package za.ac.cput.Factory.Team;

import za.ac.cput.Domain.Team.TeamMemberTask;

public class TeamMemberTaskFactory {
    public static TeamMemberTask buildTeamMemberTask(String taskId, String taskDesc, String taskDueDate, String memberId) {
        return new TeamMemberTask.Builder()
                .taskId(taskId)
                .taskDesc(taskDesc)
                .taskDueDate(taskDueDate)
                .memberId(memberId)
                .build();
    }
}
