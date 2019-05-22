package za.ac.cput.repository.SpecificTasks.impl;

import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.SpecificTasks.Exam;
import za.ac.cput.repository.SpecificTasks.ExamRepository;

import java.util.*;

@Repository("examRepository")
public class ExamRepositoryImpl implements ExamRepository {

    private static ExamRepositoryImpl repository = null;
    private Map<String, Exam> exams;

    private ExamRepositoryImpl() {
        this.exams = new HashMap<>();
    }

    public static  ExamRepository getRepository(){
        if(repository == null) repository = new  ExamRepositoryImpl();
        return repository;
    }

    public Exam create(Exam exam){
        this.exams.put(exam.getExamId(),exam);
        return exam;
    }

    public Exam read(String examId){
        return this.exams.get(examId);
    }

    public Exam update(Exam exam) {
        this.exams.replace(exam.getExamId(),exam);
        return this.exams.get(exam.getExamId());
    }

    public void delete(String examId) {
        this.exams.remove(examId);
    }

    public Set<Exam> getAll(){
        Collection<Exam> exams = this.exams.values();
        Set<Exam> set = new HashSet<>();
        set.addAll(exams);
        return set;
    }

}

