package za.ac.cput.service.SpecificTasks;

import za.ac.cput.Domain.SpecificTasks.Tests;
import za.ac.cput.service.IService;

import java.util.Set;

public interface TestService extends IService<Tests, String> {
    Set<Tests> getAll();
}
