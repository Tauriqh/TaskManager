package za.ac.cput.Factory.SpecificTasks;

import za.ac.cput.Domain.SpecificTasks.Assignment;
import za.ac.cput.Domain.Tasks.Task;

import java.util.Set;

public class AssignmentFactory {
    public static Assignment buildAssignment(String assignmentId, String assignmentName, String dueDate, boolean complete, Set<String> tasks) {
        return new Assignment.Builder()
                .assignmentId(assignmentId)
                .assignmentName(assignmentName)
                .dueDate(dueDate)
                .complete(complete)
                .tasks(tasks)
                .build();
    }
}
