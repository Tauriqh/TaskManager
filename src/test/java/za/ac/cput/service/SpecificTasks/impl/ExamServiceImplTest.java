package za.ac.cput.service.SpecificTasks.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.SpecificTasks.Exam;
import za.ac.cput.Factory.SpecificTasks.ExamFactory;
import za.ac.cput.repository.SpecificTasks.ExamRepository;
import za.ac.cput.repository.SpecificTasks.impl.ExamRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class ExamServiceImplTest {
    private ExamRepository repository;
    private Exam exam;
    private Set<String> taskId;

    private Exam getSaved() {
        return this.repository.getAll().iterator().next();
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
        System.out.println("In create, created = " + info);
        Assert.assertSame(info, this.exam);
    }

    @Test
    public void read() {
        Exam saved = getSaved();
        Exam read = this.repository.read(saved.getExamId());
        System.out.println("In read, read = " + read);
        Assert.assertEquals(saved, read);
    }

    @Test
    public void update() {
        boolean updateString = true;
        Exam exam = new Exam.Builder().copy(getSaved()).complete(updateString).build();
        System.out.println("In update, about_to_updated = " + exam);
        this.repository.update(exam);
        Assert.assertSame(updateString, exam.getComplete());
    }

    @Test
    public void e_delete() {
        Exam saved = getSaved();
        this.repository.delete(saved.getExamId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Exam> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}
