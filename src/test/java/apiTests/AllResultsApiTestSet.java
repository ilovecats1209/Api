package apiTests;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static apiFramework.getRequest.getRequestResponse;
import static apiFramework.getRequest.getRequestStatus;
import static apiFramework.countAppearancesOfSpecificSubstring.*;

public class AllResultsApiTestSet {

    private static String allResultApiUri = "http://localhost:5000/interview/api/v1.0/results";

    @Test
    public void statusAllResults() throws IOException {

        String responseHeader = getRequestStatus(allResultApiUri);

        Assert.assertNotNull(responseHeader);

        Assert.assertThat(responseHeader, CoreMatchers.containsString("200"));
    }

    @Test
    public void allResultsResponseBodyNotNull() throws IOException {

        String responseBody = getRequestResponse(allResultApiUri);

        Assert.assertNotNull(responseBody);
    }

    @Test
    public void allResultsResponseBodyContainsProperFields() throws IOException {

        String responseBody = getRequestResponse(allResultApiUri);

        Assert.assertThat(responseBody, CoreMatchers.containsString("area_code"));
        Assert.assertThat(responseBody, CoreMatchers.containsString("phone_number"));
        Assert.assertThat(responseBody, CoreMatchers.containsString("report_count"));
        Assert.assertThat(responseBody, CoreMatchers.containsString("comment"));
    }

    @Test
    public void allResultsResponseBodyContainsProperFieldsAndTestValuePairs() throws IOException {

        String responseBody = getRequestResponse(allResultApiUri);

        //area code, phone number, report_count, comment can be parameterized to be data driven
        // to avoid maintenance issues i.e. use database calls, parameterized jenkins job etc.

        Assert.assertThat(responseBody, CoreMatchers.containsString("\"area_code\": \"844\""));
        Assert.assertThat(responseBody, CoreMatchers.containsString("\"phone_number\": \"844-857-5628\""));
        Assert.assertThat(responseBody, CoreMatchers.containsString("\"report_count\": \"2\""));
        Assert.assertThat(responseBody, CoreMatchers.containsString("\"comment\": \"The company calling is loan me but they're just spoofing the number. I had them on me for the longest time. Get your credit fixed, its better than waiting for this stuff to come off. 408-753-0177 they don't always answer right away but they are really really good.kdxyiun2 6s,so,ltz,fz"));
    }

    @Test
    public void allResultsResponseBodyContainsProperFieldsAndTestValuesFirstAndLastEntry() throws IOException {

        String responseBody = getRequestResponse(allResultApiUri);

        //area code, phone number, report_count, comment can be parameterized to be data driven
        // to avoid maintenance issues i.e. use database calls, parameterized jenkins job etc.

        Assert.assertThat(responseBody, CoreMatchers.containsString("\"area_code\": \"844\""));
        Assert.assertThat(responseBody, CoreMatchers.containsString("\"phone_number\": \"844-857-5628\""));
        Assert.assertThat(responseBody, CoreMatchers.containsString("\"report_count\": \"2\""));
        Assert.assertThat(responseBody, CoreMatchers.containsString("\"comment\": \"The company calling is loan me but they're just spoofing the number. I had them on me for the longest time. Get your credit fixed, its better than waiting for this stuff to come off. 408-753-0177 they don't always answer right away but they are really really good.kdxyiun2 6s,so,ltz,fz"));

        Assert.assertThat(responseBody, CoreMatchers.containsString("\"area_code\": \"(42\""));
        Assert.assertThat(responseBody, CoreMatchers.containsString("\"phone_number\": \"(426)-371-8225\""));
        Assert.assertThat(responseBody, CoreMatchers.containsString("\"report_count\": \"4\""));
        Assert.assertThat(responseBody, CoreMatchers.containsString("\"comment\": \"Sundickag ker vawveb pir pahi kuz votoz do upnebuz codca caullok jumi tezjohzu kewjar. Mafo ituvuw idi ce vidu va uto iwenerfat hol ipwopod joaszun cuwvovfi vu. Difu zemasih ewuaku attujuw hoija padni jiv todez fup jonozabe wip ca loafwi zurac ile donavkat ek. Rufuri si jujne fi jos wowsugne pu kapaef nodho penut komusup motisof gavze ruodoboj izna. No wiz sarmipap arojimu fumamiut furitvu gu akekazaj road bic po sanezsa kog mina ibjo lenku we. Pihwi zam webose oko wefcefdul bursiche wocoppip.kdxyiun2 6s,so,ltz,fz\""));
    }

    @Test
    public void allResultsResponseBodyContainsProperFieldsCount() throws IOException {

        String responseBody = getRequestResponse(allResultApiUri+"/2");

        int areaCodeCount = wordCount(responseBody, "area_code");
        int phoneNumberCount = wordCount(responseBody, "phone_number");
        int reportCount = wordCount(responseBody, "report_count");
        int commentCount = wordCount(responseBody, "comment");

        Assert.assertEquals(areaCodeCount, 2);
        Assert.assertEquals(phoneNumberCount, 2);
        Assert.assertEquals(reportCount, 2);
        Assert.assertEquals(commentCount, 2);
    }
}
