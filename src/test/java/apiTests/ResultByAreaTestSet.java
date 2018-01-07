package apiTests;

import org.hamcrest.CoreMatchers;
import org.junit.*;

import java.io.IOException;

import static apiFramework.getRequest.*;

public class ResultByAreaTestSet {

    private static String resultsByAreaUri = "http://localhost:5000/interview/api/v1.0/resultsForArea/";

    @Test
    public void statusResultsByArea() throws IOException {

        String responseHeader = getRequestStatus(resultsByAreaUri+"770");

        Assert.assertNotNull(responseHeader);

        Assert.assertThat(responseHeader, CoreMatchers.containsString("200"));

    }

    @Test
    public void resultsByAreaResponseBodyContainsProperFields() throws IOException {

        String responseBody = getRequestResponse(resultsByAreaUri+"770");

        Assert.assertThat(responseBody, CoreMatchers.containsString("area_code"));
        Assert.assertThat(responseBody, CoreMatchers.containsString("phone_number"));
        Assert.assertThat(responseBody, CoreMatchers.containsString("report_count"));
        Assert.assertThat(responseBody, CoreMatchers.containsString("comment"));

    }


    @Test
    public void statusResultsByAreaLimited() throws IOException {

        String responseHeader = getRequestStatus(resultsByAreaUri+"770/2");

        Assert.assertNotNull(responseHeader);

        Assert.assertThat(responseHeader, CoreMatchers.containsString("200"));

    }


    @Test
    public void resultsByAreaLimitedResponseBodyContainsProperFields() throws IOException {

        String responseBody = getRequestResponse(resultsByAreaUri+"770/2");

        Assert.assertThat(responseBody, CoreMatchers.containsString("area_code"));
        Assert.assertThat(responseBody, CoreMatchers.containsString("phone_number"));
        Assert.assertThat(responseBody, CoreMatchers.containsString("report_count"));
        Assert.assertThat(responseBody, CoreMatchers.containsString("comment"));

    }
}

