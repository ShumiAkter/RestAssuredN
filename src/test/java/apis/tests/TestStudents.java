package apis.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import endpoint.Students;
import io.restassured.http.ContentType;
import utils.Configuration;

public class TestStudents {

	Students students;

	@BeforeTest
	public void init() {
		Configuration.loadProperties(TestStudents.class);
		students = new Students();
	}

	//@Test
	public void getStudentsTest() {
		students.logRequest();
		students.getStudents();
		students.logResponse();
		students.responseCodeValidation(200);
		students.bodyEqualValidation("author[3]", "Jane Doe");
	}
	@Test
	public void createStudentsTest() {
		students.logRequest();
		/*
		Map<String, String>payload = new HashMap();
		payload.put("id", "20");
		payload.put("title", "Deploying JSON-server-error");
		payload.put("author", "Janefire");
		*/
		students.setContentType(ContentType.JSON);
		String payload ="{\"id\": 30,\"title\": \"Bangladesh\",\"author\": aausa}";
		students.addRequestBody(payload);
		students.request_POST("/students");

		students.logResponse();
		students.responseCodeValidation(201);
		//students.bodyEqualValidation("author[3]", "Jane Doe");
	}
}
