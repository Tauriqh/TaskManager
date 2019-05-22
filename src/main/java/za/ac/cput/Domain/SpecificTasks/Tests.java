package za.ac.cput.Domain.SpecificTasks;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import za.ac.cput.Domain.Tasks.Task;

import java.util.Objects;
import java.util.Set;

@EntityScan
public class Tests {
    private String testId;
    private String testName;
    private String dueDate;
    private boolean complete;
    private String materialId;
    private Set<String> tasks;

    private Tests(){}

    private Tests(Builder builder) {
        this.testId = builder.testId;
        this.testName = builder.testName;
        this.dueDate = builder.dueDate;
        this.complete = builder.complete;
        this.materialId = builder.materialId;
        this.tasks = builder.tasks;
    }

    public String getTestId() {
        return testId;
    }

    public String getTestName() {
        return testName;
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

        private String testId;
        private String testName;
        private String dueDate;
        private boolean complete;
        private String materialId;
        private Set<String> tasks;

        public Builder testId(String testId) {
            this.testId = testId;
            return this;
        }

        public Builder testName( String testName) {
            this.testName = testName;
            return this;
        }

        public Builder dueDate( String dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder complete( boolean complete) {
            this.complete = complete;
            return this;
        }

        public Builder materialId( String materialId) {
            this.materialId = materialId;
            return this;
        }

        public Builder tasks(Set<String> tasks) {
            this.tasks = tasks;
            return this;
        }

        public Builder copy(Tests tests) {
            this.testId = tests.testId;
            this.testName = tests.testName;
            this.dueDate = tests.dueDate;
            this.complete = tests.complete;
            this.materialId = tests.materialId;
            this.tasks = tests.tasks;
            return this;
        }

        public Tests build() {
            return new Tests(this);
        }

    }

    @Override
    public String toString() {
        return "Tests{" +
                "testId='" + testId + '\'' +
                ", testName='" + testName + '\'' +
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
        Tests tests = (Tests) o;
        return testId.equals(tests.testId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(testId);
    }
}
