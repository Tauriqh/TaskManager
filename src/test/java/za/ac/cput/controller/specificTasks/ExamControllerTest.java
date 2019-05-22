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
import za.ac.cput.Domain.SpecificTasks.Exam;
import za.ac.cput.Factory.SpecificTasks.ExamFactory;

import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ExamControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/exam";

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
        Exam exam = restTemplate.getForObject(baseURL + "/exam/1", Exam.class);
        System.out.println(exam.getExamName());
        assertNotNull(exam);
    }

    @Ignore
    public void testCreate() {
        Set<String> taskId = null;
        taskId.add("10");
        taskId.add("11");
        taskId.add("12");
        Exam exam = ExamFactory.buildExam("1","ADT June Exam","10/06/19",false,"2",taskId);

        ResponseEntity<Exam> postResponse = restTemplate.postForEntity(baseURL + "/create", exam, Exam.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdate() {
        int id = 1;
        Exam exam = restTemplate.getForObject(baseURL + "/exam/" + id, Exam.class);

        restTemplate.put(baseURL + "/exams/" + id, exam);
        Exam updated = restTemplate.getForObject(baseURL + "/exam/" + id, Exam.class);
        assertNotNull(updated);
    }

    @Ignore
    public void testDelete() {
        int id = 2;
        Exam exam = restTemplate.getForObject(baseURL + "/exams/" + id, Exam.class);
        assertNotNull(exam);
        restTemplate.delete(baseURL + "/exams/" + id);
        try {
            exam = restTemplate.getForObject(baseURL + "/exams/" + id, Exam.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}