package za.ac.cput.Factory.SpecificTasks;

import za.ac.cput.Domain.SpecificTasks.Tests;
import za.ac.cput.Domain.Tasks.Task;

import java.util.List;
import java.util.Set;

public class TestsFactory {
    public static Tests buildTest(String testId, String testName, String dueDate, boolean complete, String materialId, List<String> tasks) {
        return new Tests.Builder()
                .testId(testId)
                .testName(testName)
                .dueDate(dueDate)
                .complete(complete)
                .materialId(materialId)
                .tasks(tasks)
                .build();
    }
}
