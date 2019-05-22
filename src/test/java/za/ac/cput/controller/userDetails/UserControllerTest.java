package za.ac.cput.controller.userDetails;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import za.ac.cput.Domain.UserDetails.User;
import za.ac.cput.Factory.UserDetails.UserFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class UserControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/user";

    @Test
    public void testGetAllUsers() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetStudentById() {
        User user = restTemplate.getForObject(baseURL + "/user/1", User.class);
        System.out.println(user.getFirstName());
        assertNotNull(user);
    }

    @Ignore
    public void testCreateStudent() {
        User student = UserFactory.buildUser("1"," John","Doe");

        ResponseEntity<User> postResponse = restTemplate.postForEntity(baseURL + "/create", student, User.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateStudent() {
        int id = 1;
        User user = restTemplate.getForObject(baseURL + "/user/" + id, User.class);

        restTemplate.put(baseURL + "/users/" + id, user);
        User updatedUser = restTemplate.getForObject(baseURL + "/User/" + id, User.class);
        assertNotNull(updatedUser);
    }

    @Ignore
    public void testDeleteEmployee() {
        int id = 2;
        User user = restTemplate.getForObject(baseURL + "/users/" + id, User.class);
        assertNotNull(user);
        restTemplate.delete(baseURL + "/users/" + id);
        try {
            user = restTemplate.getForObject(baseURL + "/users/" + id, User.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}