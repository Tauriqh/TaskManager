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
import za.ac.cput.Domain.SpecificTasks.Tests;
import za.ac.cput.Factory.SpecificTasks.TestsFactory;

import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class TestsControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/tests";

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
        Tests tests = restTemplate.getForObject(baseURL + "/tests/1", Tests.class);
        System.out.println(tests.getTestName());
        assertNotNull(tests);
    }

    @Ignore
    public void testCreate() {
        Set<String> taskId = null;
        taskId.add("7");
        taskId.add("8");
        taskId.add("9");
        Tests tests = TestsFactory.buildTest("1","ADT Chapter 1 test","10/03/19",false,"1",taskId);

        ResponseEntity<Tests> postResponse = restTemplate.postForEntity(baseURL + "/create", tests, Tests.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdate() {
        int id = 1;
        Tests tests = restTemplate.getForObject(baseURL + "/tests/" + id, Tests.class);

        restTemplate.put(baseURL + "/testss/" + id, tests);
        Tests updated = restTemplate.getForObject(baseURL + "/tests/" + id, Tests.class);
        assertNotNull(updated);
    }

    @Ignore
    public void testDelete() {
        int id = 2;
        Tests tests = restTemplate.getForObject(baseURL + "/testss/" + id, Tests.class);
        assertNotNull(tests);
        restTemplate.delete(baseURL + "/testss/" + id);
        try {
            tests = restTemplate.getForObject(baseURL + "/tests/" + id, Tests.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}