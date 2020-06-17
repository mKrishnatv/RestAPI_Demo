import clients.addEmployee.AddEmployeeClient;
import clients.addEmployee.AddEmployeeRequestBuilder;
import clients.addEmployee.request.AddEmployeeRequest;
import clients.addEmployee.response.AddEmployeeResponse;
import clients.deleteEmployee.DeleteEmployeeClient;
import clients.getAllEmployees.GetEmployeesClient;
import clients.updateEmployee.UpdateEmployeeClient;
import clients.updateEmployee.UpdateEmployeeRequestBuilder;
import clients.updateEmployee.request.UpdateEmployeeRequest;
import clients.updateEmployee.response.UpdateEmployeeResponse;
import entities.Employee;
import entities.ScenarioContext;
import entities.UseCase;
import org.testng.annotations.Test;
import utils.Categories;

public class EmployeesTest {

    private UseCase useCase;

    @Test(groups = {Categories.SMOKE})
    public void addEmployee(){

        Employee employee = new Employee("Employee1","30000", "25");
        useCase = new UseCase(employee);
        ScenarioContext.getInstance().setUseCase(useCase);

        AddEmployeeRequest addEmployeeRequest;
        addEmployeeRequest = new AddEmployeeRequestBuilder()
                                .withEmployeeDetails(employee)
                                .build();

        AddEmployeeResponse addEmployeeResponse = new AddEmployeeClient()
                                                    .addEmployee(addEmployeeRequest);
        addEmployeeResponse.assertThatResponseIsSuccessful()
                            .assertEmployeeDetails(employee);
    }

    @Test(groups = {Categories.SMOKE})
    public void getAllEmployeesList(){
        new GetEmployeesClient().getEmployeesList()
                                .assertBasicInfoNotNull();
    }

    @Test(groups = {Categories.SMOKE})
    public void updateEmployee() throws InterruptedException {
        Employee employee = new Employee("Employee2", "25000", "30");
        ScenarioContext.getInstance().getUseCase().setEmployee(employee);

        UpdateEmployeeRequest updateEmployeeRequest;
        updateEmployeeRequest = new UpdateEmployeeRequestBuilder()
                                    .withEmployeeDetails(employee)
                                    .build();

        UpdateEmployeeResponse updateEmployeeResponse = new UpdateEmployeeClient()
                                                        .updateEmployee(updateEmployeeRequest);
        updateEmployeeResponse.assertThatResponseIsSuccessful()
                                .assertEmployeeDetails(employee);
    }

    @Test(groups = {Categories.SMOKE})
    public void deleteEmployee(){
        new DeleteEmployeeClient().deleteMember()
                                  .assertSuccess();
    }
}
