package clients.steps;

import clients.addEmployee.AddEmployeeClient;
import clients.addEmployee.AddEmployeeRequestBuilder;
import clients.addEmployee.request.AddEmployeeRequest;
import clients.addEmployee.response.AddEmployeeResponse;
import entities.UseCase;

public class AddEmployeeStep extends BaseStep{
    public AddEmployeeStep(UseCase useCase) {
        super(useCase);
    }

    @Override
    public BaseStep proceedToNext() {

        addEmployee();
        return new UpdateEmployeeStep(useCase);

    }

    @Override
    public AddEmployeeStep proceedTillAddEmployeeStep() {
        return this;
    }

    public void addEmployee() {
        AddEmployeeRequest addEmployeeRequest;

        addEmployeeRequest = new AddEmployeeRequestBuilder().withEmployeeDetails(useCase.getEmployee()).build();

        AddEmployeeResponse response = new AddEmployeeClient().addEmployee(addEmployeeRequest);
        response.assertThatResponseIsSuccessful();
    }
}
