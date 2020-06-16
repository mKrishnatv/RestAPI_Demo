package clients.updateEmployee;

import clients.updateEmployee.request.UpdateEmployeeRequest;
import clients.updateEmployee.response.UpdateEmployeeResponse;
import entities.ScenarioContext;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Reporter;
import properties.SampleAPIProperties;
import utils.JsonHelper;

import java.time.Duration;
import java.time.Instant;

import static io.restassured.RestAssured.given;

public class UpdateEmployeeClient {
    public UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest request){
        String url = String.format("%s/{employeeId}", SampleAPIProperties.updateEmployeeUrl);

        Instant before = Instant.now();

        Response response = given()
                .contentType(ContentType.JSON)
                .pathParam("employeeId", ScenarioContext.getInstance().getUseCase().getId())
                .body(request)
                .put(url);

        Instant after = Instant.now();
        long timeTaken = Duration.between(before, after).toMillis();

        Reporter.log(String.format("\nUpdate Employee URL --- (PUT) %s", url), true);
        Reporter.log(String.format("Update Employee Request: %s", JsonHelper.getJsonString(request)), true);
        Reporter.log(String.format("Update Employee Response: (%s) %s", response.getStatusCode(), response.asString()), true);

        UpdateEmployeeResponse updateEmployeeResponse = response.as(UpdateEmployeeResponse.class);
        updateEmployeeResponse.setHttpStatusCode(response.getStatusCode());
        return updateEmployeeResponse;
    }
}
