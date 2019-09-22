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
import za.ac.cput.Domain.SpecificTasks.Project;
import za.ac.cput.Factory.SpecificTasks.ProjectFactory;

import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ProjectControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/project";

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
        Project project = restTemplate.getForObject(baseURL + "/project/1", Project.class);
        System.out.println(project.getProjectName());
        assertNotNull(project);
    }

    @Ignore
    public void testCreate() {
        List<String> taskId = null;
        taskId.add("4");
        taskId.add("5");
        taskId.add("6");
        Project project = ProjectFactory.buildProject("1","Project 3","11/11/19",false,taskId);

        ResponseEntity<Project> postResponse = restTemplate.postForEntity(baseURL + "/create", project, Project.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdate() {
        int id = 1;
        Project project = restTemplate.getForObject(baseURL + "/project/" + id, Project.class);

        restTemplate.put(baseURL + "/projects/" + id, project);
        Project updated = restTemplate.getForObject(baseURL + "/project/" + id, Project.class);
        assertNotNull(updated);
    }

    @Ignore
    public void testDelete() {
        int id = 2;
        Project project = restTemplate.getForObject(baseURL + "/projects/" + id, Project.class);
        assertNotNull(project);
        restTemplate.delete(baseURL + "/projects/" + id);
        try {
            project = restTemplate.getForObject(baseURL + "/projects/" + id, Project.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}