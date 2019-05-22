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
import za.ac.cput.Domain.Team.TeamMember;
import za.ac.cput.Factory.Team.TeamMemberFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class TeamMemberControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/teamMember";

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
        TeamMember teamMember = restTemplate.getForObject(baseURL + "/teamMember/1", TeamMember.class);
        System.out.println(teamMember.getMemberName());
        assertNotNull(teamMember);
    }

    @Ignore
    public void testCreate() {
        TeamMember teamMember = TeamMemberFactory.buildTeamMember("1","Steve");

        ResponseEntity<TeamMember> postResponse = restTemplate.postForEntity(baseURL + "/create", teamMember, TeamMember.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdate() {
        int id = 1;
        TeamMember teamMember = restTemplate.getForObject(baseURL + "/teamMember/" + id, TeamMember.class);

        restTemplate.put(baseURL + "/teamMembers/" + id, teamMember);
        TeamMember updated = restTemplate.getForObject(baseURL + "/teamMember/" + id, TeamMember.class);
        assertNotNull(updated);
    }

    @Ignore
    public void testDelete() {
        int id = 2;
        TeamMember teamMember = restTemplate.getForObject(baseURL + "/teamMembers/" + id, TeamMember.class);
        assertNotNull(teamMember);
        restTemplate.delete(baseURL + "/teamMembers/" + id);
        try {
            teamMember = restTemplate.getForObject(baseURL + "/teamMembers/" + id, TeamMember.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}