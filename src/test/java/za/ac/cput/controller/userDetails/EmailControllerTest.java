package za.ac.cput.controller.userDetails;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import za.ac.cput.Domain.UserDetails.Email;
import za.ac.cput.Factory.UserDetails.EmailFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class EmailControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/email";

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
        Email email = restTemplate.getForObject(baseURL + "/email/1", Email.class);
        System.out.println(email.getEmailAddressd());
        assertNotNull(email);
    }

    @Ignore
    public void testCreate() {
        Email email = EmailFactory.buildEmail("tauriqh@gmail.com", "1");

        ResponseEntity<Email> postResponse = restTemplate.postForEntity(baseURL + "/create", email, Email.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdate() {
        int id = 1;
        Email email = restTemplate.getForObject(baseURL + "/email/" + id, Email.class);

        restTemplate.put(baseURL + "/emails/" + id, email);
        Email updated = restTemplate.getForObject(baseURL + "/email/" + id, Email.class);
        assertNotNull(updated);
    }

    @Ignore
    public void testDelete() {
        int id = 2;
        Email email = restTemplate.getForObject(baseURL + "/emails/" + id, Email.class);
        assertNotNull(email);
        restTemplate.delete(baseURL + "/emails/" + id);
        try {
            email = restTemplate.getForObject(baseURL + "/emails/" + id, Email.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}