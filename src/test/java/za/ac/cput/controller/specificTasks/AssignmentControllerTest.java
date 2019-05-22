package za.ac.cput.controller.specificTasks;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import za.ac.cput.Domain.SpecificTasks.Assignment;
import za.ac.cput.Factory.SpecificTasks.AssignmentFactory;

import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class AssignmentControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/assignment";

    @Test
    public void testGetAll() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetById() {
        Assignment assignment = restTemplate.getForObject(baseURL + "/assignment/1", Assignment.class);
        System.out.println(assignment.getAssignmentName());
        assertNotNull(assignment);
    }

    @Ignore
    public void testCreate() {
        Set<String> taskId = null;
        taskId.add("1");
        taskId.add("2");
        taskId.add("3");
        Assignment assignment = AssignmentFactory.buildAssignment("1","ADP Assignment 6","11/11/19",false,taskId);

        ResponseEntity<Assignment> postResponse = restTemplate.postForEntity(baseURL + "/create", assignment, Assignment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdate() {
        int id = 1;
        Assignment assignment = restTemplate.getForObject(baseURL + "/assignment/" + id, Assignment.class);

        restTemplate.put(baseURL + "/assignments/" + id, assignment);
        Assignment updated = restTemplate.getForObject(baseURL + "/assignment/" + id, Assignment.class);
        assertNotNull(updated);
    }

    @Ignore
    public void testDelete() {
        int id = 2;
        Assignment assignment = restTemplate.getForObject(baseURL + "/assignments/" + id, Assignment.class);
        assertNotNull(assignment);
        restTemplate.delete(baseURL + "/assignments/" + id);
        try {
            assignment = restTemplate.getForObject(baseURL + "/assignments/" + id, Assignment.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}