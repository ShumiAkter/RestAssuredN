package endpoint;

import common.Endpoint;
import common.RESTSteps;

public class Students extends RESTSteps{

	public Students() {
		init_request();
	}
	
	public void getStudents() {
		request_GET(Endpoint.STUDENT.getEndpoint());
	}
}
