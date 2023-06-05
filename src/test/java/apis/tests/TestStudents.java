package apis.tests;


import java.util.LinkedHashMap;
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

	@Test
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
		students.setContentType(ContentType.JSON);
		String payload = "{\n" + "    \"id\": 14,\n" + "   "
				+ " \"title\": \"Deploying JSON-server-errorh\",\n"
				+ "    \"author\": \"Janefire\"\n" + "}";
		students.addRequestBody(payload);
		students.request_POST("/students");

		students.logResponse();
		students.responseCodeValidation(201);
	}

	@Test
	public void updateStudentsTest() {
		students.setContentType(ContentType.JSON);
		Map<String, Object> payload = new LinkedHashMap<>();
		payload.put("id", 14);
		payload.put("title", "Australia");
		payload.put("author", "Janefire");
		students.addRequestBody(payload);
		students.request_PUT("/students/14");
		students.logResponse();
		students.responseCodeValidation(200);
		students.bodyEqualValidation("author", "Janefire");

	}
	
	@Test
	public void deleteStudentsTest() {
		students.logRequest();
		students.request_DELETE("/students/72");
		students.logResponse();
		//students.bodyEqualValidation("", "");
		students.responseCodeValidation(200);
	}

}
