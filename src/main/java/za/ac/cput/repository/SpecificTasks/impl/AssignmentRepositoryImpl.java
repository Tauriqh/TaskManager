package za.ac.cput.repository.SpecificTasks.impl;

import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.SpecificTasks.Assignment;
import za.ac.cput.repository.SpecificTasks.AssignmentRepository;

import java.util.*;

@Repository("assignmentRepository")
public class AssignmentRepositoryImpl implements AssignmentRepository {

    private static AssignmentRepositoryImpl repository = null;
    private Map<String, Assignment> assignments;

    private AssignmentRepositoryImpl() {
        this.assignments = new HashMap<>();
    }

    public static AssignmentRepository getRepository(){
        if(repository == null) repository = new  AssignmentRepositoryImpl();
        return repository;
    }

    public Assignment create(Assignment assignment){
        this.assignments.put(assignment.getAssignmentId(),assignment);
        return assignment;
    }

    public Assignment read(String assignmentId){
        return this.assignments.get(assignmentId);
    }

    public Assignment update(Assignment assignment) {
        this.assignments.replace(assignment.getAssignmentId(),assignment);
        return this.assignments.get(assignment.getAssignmentId());
    }

    public void delete(String assignmentId) {
        this.assignments.remove(assignmentId);
    }

    public  Set<Assignment> getAll(){
        Collection<Assignment> assignments = this.assignments.values();
        Set<Assignment> set = new HashSet<>();
        set.addAll(assignments);
        return set;
    }

}