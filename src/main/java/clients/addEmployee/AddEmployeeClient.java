package clients.addEmployee;

import clients.addEmployee.request.AddEmployeeRequest;
import clients.addEmployee.response.AddEmployeeResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Reporter;
import properties.SampleAPIProperties;
import utils.JsonHelper;

import java.time.Duration;
import java.time.Instant;

import static io.restassured.RestAssured.given;

public class AddEmployeeClient {

    public AddEmployeeResponse addEmployee(AddEmployeeRequest request){
        String url = String.format("%s", SampleAPIProperties.addEmployeeUrl);

        Instant before = Instant.now();

        Response response = given()
                .contentType(ContentType.JSON)
                .body(request)
                .post(url);

        Instant after = Instant.now();
        long timeTaken = Duration.between(before, after).toMillis();

        Reporter.log(String.format("\nAdd Employee URL --- (POST) %s", url), true);
        Reporter.log(String.format("Add Employee Request: %s", JsonHelper.getJsonString(request)), true);
        Reporter.log(String.format("Add Employee Response: (%s) %s", response.getStatusCode(), response.asString()), true);

        AddEmployeeResponse addEmployeeResponse = response.as(AddEmployeeResponse.class);
        addEmployeeResponse.setHttpStatusCode(response.getStatusCode());
        return addEmployeeResponse;
    }
}
