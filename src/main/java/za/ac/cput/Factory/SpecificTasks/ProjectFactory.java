package za.ac.cput.Factory.SpecificTasks;

import za.ac.cput.Domain.SpecificTasks.Project;
import za.ac.cput.Domain.Tasks.Task;

import java.util.List;
import java.util.Set;

public class ProjectFactory {
    public static Project buildProject(String projectId, String projectName, String dueDate, boolean complete, List<String> tasks) {
        return new Project.Builder()
                .projectId(projectId)
                .projectName(projectName)
                .dueDate(dueDate)
                .complete(complete)
                .tasks(tasks)
                .build();
    }
}

