package za.ac.cput.Domain.SpecificTasks;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import za.ac.cput.Domain.Tasks.Task;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

@EntityScan
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private String dueDate;
    private boolean complete;
    private Set<String> tasks;

    private Assignment(){}

    private Assignment(Builder builder) {
        this.assignmentId = builder.assignmentId;
        this.assignmentName = builder.assignmentName;
        this.dueDate = builder.dueDate;
        this.complete = builder.complete;
        this.tasks = builder.tasks;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public String getAssignmentName() {
        return assignmentName;
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

        private String assignmentId;
        private String assignmentName;
        private String dueDate;
        private boolean complete;
        private Set<String> tasks;

        public Builder assignmentId( String assignmentId) {
            this.assignmentId = assignmentId;
            return this;
        }

        public Builder assignmentName(String assignmentName) {
            this.assignmentName = assignmentName;
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

        public Builder copy(Assignment assignment) {
            this.assignmentId = assignment.assignmentId;
            this.assignmentName = assignment.assignmentName;
            this.dueDate = assignment.dueDate;
            this.complete = assignment.complete;
            this.tasks = assignment.tasks;
            return this;
        }

        public Assignment build() {
            return new Assignment(this);
        }

    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId=" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", complete=" + complete +
                ", tasks=" + tasks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment assignment = (Assignment) o;
        return assignmentId.equals(assignment.assignmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assignmentId);
    }
}
