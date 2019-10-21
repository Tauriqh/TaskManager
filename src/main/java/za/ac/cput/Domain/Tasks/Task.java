package za.ac.cput.domain.tasks;

import javax.persistence.*;

@Entity
@Table(name="TBL_TASKS")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="task_description")
    private String taskDesc;

    @Column(name="task_due_date")
    private String taskDueDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public String getTaskDueDate() {
        return taskDueDate;
    }

    public void setTaskDueDate(String taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskDesc='" + taskDesc + '\'' +
                ", taskDueDate='" + taskDueDate + '\'' +
                '}';
    }
}
