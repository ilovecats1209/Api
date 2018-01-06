package apiTests;

import org.hamcrest.CoreMatchers;
import org.junit.*;

import java.io.IOException;

import static apiFramework.getRequest.*;

public class AllResults {

    @Test
    public void successfulRequestTest() throws IOException {

        String responseHeader = getRequestStatus("http://localhost:5000/interview/api/v1.0/results");

        Assert.assertNotNull(responseHeader);

        Assert.assertThat(responseHeader, CoreMatchers.containsString("200"));

    }

    @Test
    public void successfulRequestAreaCode() throws IOException{

        String responseHeader = getRequestStatus("http://localhost:5000/interview/api/v1.0/resultsForArea/770");

        Assert.assertNotNull(responseHeader);

        Assert.assertThat(responseHeader, CoreMatchers.containsString("200"));

    }

}