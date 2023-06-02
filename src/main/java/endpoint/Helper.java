package endpoint;

import common.Endpoint;
import common.RESTSteps;

public class Helper extends RESTSteps{

    public Helper(){
        init_request();
    }

    public void getHelper(){
        request_GET(Endpoint.HELP.getEndpoint());
    }
}
