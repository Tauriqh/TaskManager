package za.ac.cput.Domain.Tasks;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Task {
    private String taskId;
    private String taskDesc;
    private String taskDueDate;

    private Task(){}

    private Task(Builder builder) {
        this.taskId = builder.taskId;
        this.taskDesc = builder.taskDesc;
        this.taskDueDate = builder.taskDueDate;
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

    public static class Builder {
        private String taskId;
        private String taskDesc;
        private String taskDueDate;

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

        public Builder copy(Task task) {
            this.taskId = task.taskId;
            this.taskDesc = task.taskDesc;
            this.taskDueDate = task.taskDueDate;
            return this;
        }

        public Task build() {
            return new Task(this);
        }

    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId + '\'' +
                ", taskDesc='" + taskDesc + '\'' +
                ", taskDueDate='" + taskDueDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return taskId.equals(task.taskId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId);
    }
}
