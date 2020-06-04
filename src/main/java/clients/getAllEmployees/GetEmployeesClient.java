package clients.getAllEmployees;

import clients.getAllEmployees.response.GetEmployeesResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Reporter;
import properties.SampleAPIProperties;

import java.time.Duration;
import java.time.Instant;

import static io.restassured.RestAssured.given;

public class GetEmployeesClient {
    public GetEmployeesResponse getEmployeesList(){
        String url = SampleAPIProperties.getAllEmployees;

        Instant before = Instant.now();
        Response response = given()
                .contentType(ContentType.JSON)
                .get(url);

        Instant after = Instant.now();
        long timeTaken = Duration.between(before, after).toMillis();

        Reporter.log(String.format("\nGet All Employees List URL --- (GET) %s", url), true);
        Reporter.log(String.format("Get All Employees List Response: (%s) %s", response.getStatusCode(), response.asString()), true);
        Reporter.log(String.format("Get All Employees List TimeTaken: %s", timeTaken), true);

        GetEmployeesResponse getEmployeesResponse = response.as(GetEmployeesResponse.class);
        getEmployeesResponse.setHttpStatusCode(response.getStatusCode());
        return getEmployeesResponse;
    }
}
