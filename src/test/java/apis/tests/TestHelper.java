package apis.tests;


import endpoint.Helper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Configuration;

public class TestHelper {
Helper helper;

    @BeforeTest
    public void init(){
        Configuration.loadProperties(TestHelper.class);
        helper = new Helper();
    }

    @Test
    public void getPlayersTest(){
      helper.logRequest();
      helper.getHelper();
      helper.logResponse();
      helper.responseCodeValidation(200);
      helper.headerEqualValidation("Expires","-1");
      helper.bodyEqualValidation("id[1]", 2);
      helper.bodyEqualValidation("body[1]", "I'm having trouble deploying JSON-server. Can anyone help?");
    }
}
