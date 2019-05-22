package za.ac.cput.repository.SpecificTasks;

import za.ac.cput.Domain.SpecificTasks.Tests;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface TestsRepository extends IRepository<Tests, String> {
    Set<Tests> getAll();
}
