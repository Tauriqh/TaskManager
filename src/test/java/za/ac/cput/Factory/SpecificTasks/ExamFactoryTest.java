package za.ac.cput.Factory.SpecificTasks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.SpecificTasks.Exam;

import java.util.Set;

public class ExamFactoryTest {

    private String examId;
    private String examName;
    private String dueDate;
    private boolean complete;
    private String materialId;
    private Set<String> taskId;

    @Before
    public void setUp() throws Exception {
        this.examId = "1";
        this.examName = "ADT June Exam";
        this.dueDate = "10/06/19";
        this.complete = false;
        this.materialId = "2";
        this.taskId.add("10");
        this.taskId.add("11");
        this.taskId.add("12");
    }

    @Test
    public void buildExam() {
        Exam exam = ExamFactory.buildExam(examId, examName, dueDate, complete, materialId, taskId);
        Assert.assertNotNull(exam.getExamId());
        Assert.assertNotNull(exam);
    }
}