package za.ac.cput.Domain.SpecificTasks;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import za.ac.cput.Domain.Tasks.Task;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

@EntityScan
public class Project {
    private String projectId;
    private String projectName;
    private String dueDate;
    private boolean complete;
    private Set<String> tasks;

    private Project(){}

    private Project(Builder builder) {
        this.projectId = builder.projectId;
        this.projectName = builder.projectName;
        this.dueDate = builder.dueDate;
        this.complete = builder.complete;
        this.tasks = builder.tasks;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean getComplete() {
        return complete;
    }

    public Set<String> getTaskId() {
        return tasks;
    }

    public static class Builder {

        private String projectId;
        private String projectName;
        private String dueDate;
        private boolean complete;
        private Set<String> tasks;

        public Builder projectId(String projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder projectName(String projectName) {
            this.projectName = projectName;
            return this;
        }

        public Builder dueDate(String dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder complete(boolean complete) {
            this.complete = complete;
            return this;
        }

        public Builder tasks(Set<String> tasks) {
            this.tasks = tasks;
            return this;
        }

        public Builder copy(Project project) {
            this.projectId = project.projectId;
            this.projectName = project.projectName;
            this.dueDate = project.dueDate;
            this.complete = project.complete;
            this.tasks = project.tasks;
            return this;
        }

        public Project build() {
            return new Project(this);
        }

    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", complete=" + complete +
                ", tasks=" + tasks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return projectId.equals(project.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId);
    }
}
