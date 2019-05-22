package za.ac.cput.Domain.Team;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class TeamMemberTask {
    private String taskId;
    private String taskDesc;
    private String taskDueDate;
    private String memberId;

    private TeamMemberTask(){}

    private TeamMemberTask(Builder builder) {
        this.taskId = builder.taskId;
        this.taskDesc = builder.taskDesc;
        this.taskDueDate = builder.taskDueDate;
        this.memberId = builder.memberId;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public String getTaskDueDate() {
        return taskDueDate;
    }

    public String getMemberId() {
        return memberId;
    }

    public static class Builder {

        private String taskId;
        private String taskDesc;
        private String taskDueDate;
        private String memberId;

        public Builder taskId( String taskId) {
            this.taskId = taskId;
            return this;
        }

        public Builder taskDesc( String taskDesc) {
            this.taskDesc = taskDesc;
            return this;
        }

        public Builder taskDueDate( String taskDueDate) {
            this.taskDueDate = taskDueDate;
            return this;
        }

        public Builder memberId( String memberId) {
            this.memberId = memberId;
            return this;
        }

        public Builder copy(TeamMemberTask teamMemberTask) {
            this.taskId = teamMemberTask.taskId;
            this.taskDesc = teamMemberTask.taskDesc;
            this.taskDueDate = teamMemberTask.taskDueDate;
            this.memberId = teamMemberTask.memberId;
            return this;
        }

        public TeamMemberTask build() {
            return new TeamMemberTask(this);
        }

    }

    @Override
    public String toString() {
        return "TeamMemberTask{" +
                "taskId='" + taskId + '\'' +
                ", taskDesc='" + taskDesc + '\'' +
                ", taskDueDate='" + taskDueDate + '\'' +
                ", memberId='" + memberId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamMemberTask teamMemberTask = (TeamMemberTask) o;
        return taskId.equals(teamMemberTask.taskId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId);
    }
}
