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
import za.ac.cput.Domain.Team.TeamMemberTask;
import za.ac.cput.Factory.Team.TeamMemberTaskFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class TeamMemberTaskControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/teamMemberTask";

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
        TeamMemberTask teamMemberTask = restTemplate.getForObject(baseURL + "/teamMemberTask/1", TeamMemberTask.class);
        System.out.println(teamMemberTask.getTaskDesc());
        assertNotNull(teamMemberTask);
    }

    @Ignore
    public void testCreate() {
        TeamMemberTask teamMemberTask = TeamMemberTaskFactory.buildTeamMemberTask("1","Document all findings","20/8/19","1");

        ResponseEntity<TeamMemberTask> postResponse = restTemplate.postForEntity(baseURL + "/create", teamMemberTask, TeamMemberTask.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdate() {
        int id = 1;
        TeamMemberTask teamMemberTask = restTemplate.getForObject(baseURL + "/teamMemberTask/" + id, TeamMemberTask.class);

        restTemplate.put(baseURL + "/teamMemberTasks/" + id, teamMemberTask);
        TeamMemberTask updated = restTemplate.getForObject(baseURL + "/teamMemberTask/" + id, TeamMemberTask.class);
        assertNotNull(updated);
    }

    @Ignore
    public void testDelete() {
        int id = 2;
        TeamMemberTask teamMemberTask = restTemplate.getForObject(baseURL + "/teamMemberTasks/" + id, TeamMemberTask.class);
        assertNotNull(teamMemberTask);
        restTemplate.delete(baseURL + "/teamMemberTasks/" + id);
        try {
            teamMemberTask = restTemplate.getForObject(baseURL + "/teamMemberTasks/" + id, TeamMemberTask.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}