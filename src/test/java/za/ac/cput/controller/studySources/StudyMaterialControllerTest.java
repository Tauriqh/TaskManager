package za.ac.cput.controller.studySources;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import za.ac.cput.Domain.StudySource.StudyMaterial;
import za.ac.cput.Factory.StudySource.StudyMaterialFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class StudyMaterialControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/studyMaterial";

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
        StudyMaterial studyMaterial = restTemplate.getForObject(baseURL + "/studyMaterial/1", StudyMaterial.class);
        System.out.println(studyMaterial.getMaterialDesc());
        assertNotNull(studyMaterial);
    }

    @Ignore
    public void testCreate() {
        StudyMaterial studyMaterial = StudyMaterialFactory.buildStudyMaterial("1","Java for Dummies Chapter 2");

        ResponseEntity<StudyMaterial> postResponse = restTemplate.postForEntity(baseURL + "/create", studyMaterial, StudyMaterial.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdate() {
        int id = 1;
        StudyMaterial studyMaterial = restTemplate.getForObject(baseURL + "/studyMaterial/" + id, StudyMaterial.class);

        restTemplate.put(baseURL + "/studyMaterials/" + id, studyMaterial);
        StudyMaterial updated = restTemplate.getForObject(baseURL + "/studyMaterial/" + id, StudyMaterial.class);
        assertNotNull(updated);
    }

    @Ignore
    public void testDelete() {
        int id = 2;
        StudyMaterial studyMaterial = restTemplate.getForObject(baseURL + "/studyMaterials/" + id, StudyMaterial.class);
        assertNotNull(studyMaterial);
        restTemplate.delete(baseURL + "/studyMaterials/" + id);
        try {
            studyMaterial = restTemplate.getForObject(baseURL + "/studyMaterials/" + id, StudyMaterial.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}