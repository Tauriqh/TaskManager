package za.ac.cput.repository.SpecificTasks.impl;

import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.SpecificTasks.Tests;
import za.ac.cput.repository.SpecificTasks.TestsRepository;

import java.util.*;

@Repository("testsRepository")
public class TestsRepositoryImpl implements TestsRepository {

    private static TestsRepositoryImpl repository = null;
    private Map<String, Tests> tests;

    private TestsRepositoryImpl() {
        this.tests = new HashMap<>();
    }

    public static  TestsRepository getRepository(){
        if(repository == null) repository = new  TestsRepositoryImpl();
        return repository;
    }

    public Tests create(Tests test){
        this.tests.put(test.getTestId(),test);
        return test;
    }

    public Tests read(String testId){
        return this.tests.get(testId);
    }

    public Tests update(Tests test) {
        this.tests.replace(test.getTestId(),test);
        return this.tests.get(test.getTestId());
    }

    public void delete(String testId) {
        this.tests.remove(testId);
    }

    public Set<Tests> getAll(){
        Collection<Tests> tests = this.tests.values();
        Set<Tests> set = new HashSet<>();
        set.addAll(tests);
        return set;
    }

}
