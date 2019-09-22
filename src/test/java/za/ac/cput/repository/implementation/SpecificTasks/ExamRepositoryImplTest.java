package za.ac.cput.repository.implementation.SpecificTasks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.SpecificTasks.Exam;
import za.ac.cput.Factory.SpecificTasks.ExamFactory;
import za.ac.cput.repository.SpecificTasks.ExamRepository;
import za.ac.cput.repository.SpecificTasks.impl.ExamRepositoryImpl;

import java.util.*;

public class ExamRepositoryImplTest {

    private ExamRepository repository;
    private Exam exam;
    private List<String> taskId = new LinkedList<>();

    private Exam getSaved() {
        Set<Exam> saved = this.repository.getAll();
        return saved.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ExamRepositoryImpl.getRepository();
        this.taskId.add("10");
        this.taskId.add("11");
        this.taskId.add("12");
        this.exam = ExamFactory.buildExam("1","ADT June Exam","10/06/19",false,"2",taskId);
    }

    @Test
    public void create() {
        Exam info = this.repository.create(this.exam);
        d_getAll();
        Assert.assertSame(info, this.exam);
        /*System.out.println(this.tests);*/
    }

    @Test
    public void read() {
        Exam saved = getSaved();
        Exam read = this.repository.read(saved.getExamId());
        //System.out.println("In read, read = " + read);
        Assert.assertEquals(saved, read);
        d_getAll();
    }

    @Test
    public void update() {
        boolean updateString = true;
        Exam exam = new Exam.Builder().copy(getSaved()).complete(updateString).build();
        //System.out.println("In update, about_to_updated = " + exam);
        Exam updated = this.repository.update(exam);
        //System.out.println("In update, updated = " + updated);
        Assert.assertSame(updateString, updated.getComplete());
        d_getAll();
    }

    @Test
    public void e_delete() {
        Exam saved = getSaved();
        d_getAll();
        this.repository.delete(saved.getExamId());
        d_getAll();
        Set<Exam> exams = this.repository.getAll();
        Assert.assertEquals(0, exams.size());
    }

    @Test
    public void d_getAll() {
        Set<Exam> all = this.repository.getAll();
        //System.out.println("In getAll, all = " + all);
        //Assert.assertEquals(1, users.size());
    }
}
