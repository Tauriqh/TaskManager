package za.ac.cput.controller.tasks;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import za.ac.cput.Domain.Tasks.Task;
import za.ac.cput.Factory.Tasks.TaskFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class TaskControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/task";

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
        Task task = restTemplate.getForObject(baseURL + "/task/1", Task.class);
        System.out.println(task.getTaskDesc());
        assertNotNull(task);
    }

    @Ignore
    public void testCreate() {
        Task task = TaskFactory.buildTask("1","Write the complete narrative of your application in a README.md using Markdown","17/04/19");

        ResponseEntity<Task> postResponse = restTemplate.postForEntity(baseURL + "/create", task, Task.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdate() {
        int id = 1;
        Task task = restTemplate.getForObject(baseURL + "/task/" + id, Task.class);

        restTemplate.put(baseURL + "/tasks/" + id, task);
        Task updated = restTemplate.getForObject(baseURL + "/task/" + id, Task.class);
        assertNotNull(updated);
    }

    @Ignore
    public void testDelete() {
        int id = 2;
        Task task = restTemplate.getForObject(baseURL + "/tasks/" + id, Task.class);
        assertNotNull(task);
        restTemplate.delete(baseURL + "/tasks/" + id);
        try {
            task = restTemplate.getForObject(baseURL + "/tasks/" + id, Task.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}