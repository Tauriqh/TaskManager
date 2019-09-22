package za.ac.cput.Factory.SpecificTasks;

import za.ac.cput.Domain.SpecificTasks.Exam;
import za.ac.cput.Domain.Tasks.Task;

import java.util.List;
import java.util.Set;

public class ExamFactory {
    public static Exam buildExam(String examId, String examName, String dueDate, boolean complete, String materialId, List<String> tasks) {
        return new Exam.Builder()
                .examId(examId)
                .examName(examName)
                .dueDate(dueDate)
                .complete(complete)
                .materialId(materialId)
                .tasks(tasks)
                .build();
    }
}
