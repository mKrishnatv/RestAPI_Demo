package clients.steps;

import clients.addEmployee.AddEmployeeClient;
import clients.addEmployee.AddEmployeeRequestBuilder;
import clients.addEmployee.request.AddEmployeeRequest;
import clients.addEmployee.response.AddEmployeeResponse;
import clients.updateEmployee.UpdateEmployeeClient;
import clients.updateEmployee.UpdateEmployeeRequestBuilder;
import clients.updateEmployee.request.UpdateEmployeeRequest;
import clients.updateEmployee.response.UpdateEmployeeResponse;
import entities.UseCase;

public class UpdateEmployeeStep extends BaseStep{

    public UpdateEmployeeStep(UseCase useCase) {
        super(useCase);
    }

    @Override
    public BaseStep proceedToNext() {
        updateEmployee();
        return new DeleteEmployeeStep(useCase);

    }

    @Override
    public UpdateEmployeeStep proceedTillUpdateEmployeeStep() {
        return this;
    }

    public void updateEmployee() {
        UpdateEmployeeRequest updateEmployeeRequest;
        updateEmployeeRequest = new UpdateEmployeeRequestBuilder()
                .withEmployeeDetails(useCase.getEmployee())
                .build();

        UpdateEmployeeResponse updateEmployeeResponse = new UpdateEmployeeClient()
                .updateEmployee(updateEmployeeRequest);
        updateEmployeeResponse.assertThatResponseIsSuccessful();
    }

}
