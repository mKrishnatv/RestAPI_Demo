package clients.deleteEmployee;

import clients.deleteEmployee.response.DeleteEmployeeResponse;
import entities.ScenarioContext;
import io.restassured.response.Response;
import org.testng.Reporter;
import properties.SampleAPIProperties;

import java.time.Duration;
import java.time.Instant;

import static io.restassured.RestAssured.given;

public class DeleteEmployeeClient {
    public DeleteEmployeeResponse deleteEmployee() {

        int memberId = ScenarioContext.getInstance().getUseCase().getId();
        String url = String.format("%s/{employeeId}", SampleAPIProperties.deleteEmployeeUrl);
        Reporter.log(String.format("\nDelete Employee URL --- (DELETE) %s", url), true);

        Instant before = Instant.now();

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("employeeId", memberId)
                .delete(url);

        Instant after = Instant.now();
        long timeTaken = Duration.between(before, after).toMillis();

        Reporter.log(String.format("Delete Employee Response: (%s) %s", response.getStatusCode(), response.asString()), true);
        Reporter.log(String.format("Delete Employee TimeTaken: %s", timeTaken), true);

        DeleteEmployeeResponse deleteEmployeeResponse = response.as(DeleteEmployeeResponse.class);
        deleteEmployeeResponse.setHttpStatusCode(response.getStatusCode());
        return deleteEmployeeResponse;
    }
}
