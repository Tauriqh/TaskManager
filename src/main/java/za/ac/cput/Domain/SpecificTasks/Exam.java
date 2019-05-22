package za.ac.cput.Domain.SpecificTasks;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import za.ac.cput.Domain.Tasks.Task;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

@EntityScan
public class Exam {
    private String examId;
    private String examName;
    private String dueDate;
    private boolean complete;
    private String materialId;
    private Set<String> tasks;

    private Exam(){}

    private Exam(Builder builder) {
        this.examId = builder.examId;
        this.examName = builder.examName;
        this.dueDate = builder.dueDate;
        this.complete = builder.complete;
        this.materialId = builder.materialId;
        this.tasks = builder.tasks;
    }

    public String getExamId() {
        return examId;
    }

    public String getExamName() {
        return examName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean getComplete() {
        return complete;
    }

    public String getMaterialId() {
        return materialId;
    }

    public Set<String> getTaskId() {
        return tasks;
    }

    public static class Builder {

        private String examId;
        private String examName;
        private String dueDate;
        private boolean complete;
        private String materialId;
        private Set<String> tasks;

        public Builder examId(String examId) {
            this.examId = examId;
            return this;
        }

        public Builder examName(String examName) {
            this.examName = examName;
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

        public Builder materialId(String materialId) {
            this.materialId = materialId;
            return this;
        }

        public Builder tasks(Set<String> tasks) {
            this.tasks = tasks;
            return this;
        }

        public Builder copy(Exam exam) {
            this.examId = exam.examId;
            this.examName = exam.examName;
            this.dueDate = exam.dueDate;
            this.complete = exam.complete;
            this.materialId = exam.materialId;
            this.tasks = exam.tasks;
            return this;
        }

        public Exam build() {
            return new Exam(this);
        }

    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId='" + examId + '\'' +
                ", examName='" + examName + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", complete=" + complete +
                ", materialId='" + materialId + '\'' +
                ", tasks=" + tasks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return examId.equals(exam.examId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examId);
    }
}
