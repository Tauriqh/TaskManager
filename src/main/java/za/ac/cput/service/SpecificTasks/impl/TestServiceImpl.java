package za.ac.cput.service.SpecificTasks.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.SpecificTasks.Tests;
import za.ac.cput.repository.SpecificTasks.TestsRepository;
import za.ac.cput.service.SpecificTasks.TestService;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("testsServiceImpl")
public class TestServiceImpl implements TestService {
    @Autowired
    @Qualifier("testsRepository")

    private TestsRepository repository;

    @Override
    public Tests create(Tests test) {
        return repository.create(test);
    }

    @Override
    public Tests update(Tests test) {
        return repository.update(test);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public Tests read(String s) {
        return repository.read(s);
    }

    @Override
    public Set<Tests> getAll() {
        return repository.getAll();
    }
}