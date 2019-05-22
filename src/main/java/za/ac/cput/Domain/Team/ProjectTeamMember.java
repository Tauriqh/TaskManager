package za.ac.cput.Domain.Team;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class ProjectTeamMember {
    private String projectId;
    private String memberId;

    private ProjectTeamMember(){}

    private ProjectTeamMember(Builder builder) {
        this.projectId = builder.projectId;
        this.memberId = builder.memberId;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getMemberId() {
        return memberId;
    }

    public static class Builder {
        private String projectId;
        private String memberId;

        public Builder projectId( String projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder memberId( String memberId) {
            this.memberId = memberId;
            return this;
        }

        public Builder copy(ProjectTeamMember projectTeamMember) {
            this.projectId = projectTeamMember.projectId;
            this.memberId = projectTeamMember.memberId;
            return this;
        }

        public ProjectTeamMember build() {
            return new ProjectTeamMember(this);
        }

    }

    @Override
    public String toString() {
        return "ProjectTeamMember{" +
                "projectId='" + projectId + '\'' +
                ", memberId='" + memberId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectTeamMember projectTeamMember = (ProjectTeamMember) o;
        return projectId.equals(projectTeamMember.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId);
    }
}
