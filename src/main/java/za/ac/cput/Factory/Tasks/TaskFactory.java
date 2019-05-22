package za.ac.cput.Factory.Tasks;

import za.ac.cput.Domain.Tasks.Task;

public class TaskFactory {
    public static Task buildTask(String taskId, String taskDesc, String taskDueDate) {
                return new Task.Builder()
                .taskId(taskId)
                .taskDesc(taskDesc)
                .taskDueDate(taskDueDate)
                .build();
    }
}
