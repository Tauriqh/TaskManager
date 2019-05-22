package za.ac.cput.controller.team;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import za.ac.cput.Domain.Team.ProjectTeamMember;
import za.ac.cput.Factory.Team.ProjectTeamMemberFactory;


import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ProjectTeamMemberControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/projectTeamMember";

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
        ProjectTeamMember projectTeamMember = restTemplate.getForObject(baseURL + "/projectTeamMember/1", ProjectTeamMember.class);
        System.out.println(projectTeamMember.getProjectId());
        assertNotNull(projectTeamMember);
    }

    @Ignore
    public void testCreate() {
        ProjectTeamMember projectTeamMember = ProjectTeamMemberFactory.buildProjectTeamMember("1", "1");

        ResponseEntity<ProjectTeamMember> postResponse = restTemplate.postForEntity(baseURL + "/create", projectTeamMember, ProjectTeamMember.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdate() {
        int id = 1;
        ProjectTeamMember projectTeamMember = restTemplate.getForObject(baseURL + "/projectTeamMember/" + id, ProjectTeamMember.class);

        restTemplate.put(baseURL + "/projectTeamMembers/" + id, projectTeamMember);
        ProjectTeamMember updated = restTemplate.getForObject(baseURL + "/projectTeamMember/" + id, ProjectTeamMember.class);
        assertNotNull(updated);
    }

    @Ignore
    public void testDelete() {
        int id = 2;
        ProjectTeamMember projectTeamMember = restTemplate.getForObject(baseURL + "/projectTeamMembers/" + id, ProjectTeamMember.class);
        assertNotNull(projectTeamMember);
        restTemplate.delete(baseURL + "/projectTeamMembers/" + id);
        try {
            projectTeamMember = restTemplate.getForObject(baseURL + "/projectTeamMembers/" + id, ProjectTeamMember.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}