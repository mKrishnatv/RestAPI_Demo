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
import org.testng.annotations.Test;
import utils.Categories;

public class EmployeesTest {

    @Test(groups = {Categories.SMOKE})
    public void addEmployee(){
        Employee employee = new Employee("Employee1","30000", "25");

        AddEmployeeRequest addEmployeeRequest;
        addEmployeeRequest = new AddEmployeeRequestBuilder()
                                .withEmployeeDetails(employee)
                                .build();

        AddEmployeeResponse addEmployeeResponse = new AddEmployeeClient()
                                                    .addEmployee(addEmployeeRequest);
        addEmployeeResponse.assertThatResponseIsSuccessful()
                            .assertEmployeeDetails(employee);
    }

    @Test(groups = {Categories.REGRESSION})
    public void getAllEmployeesList(){
        new GetEmployeesClient().getEmployeesList()
                                .assertBasicInfoNotNull();
    }

    @Test(groups = {Categories.REGRESSION})
    public void updateEmployee(){
        Employee employee = new Employee("Employee2", "25000", "30");

        UpdateEmployeeRequest updateEmployeeRequest;
        updateEmployeeRequest = new UpdateEmployeeRequestBuilder()
                                    .withEmployeeDetails(employee)
                                    .build();

        UpdateEmployeeResponse updateEmployeeResponse = new UpdateEmployeeClient()
                                                        .updateEmployee(updateEmployeeRequest);
        updateEmployeeResponse.assertThatResponseIsSuccessful()
                                .assertEmployeeDetails(employee);
    }

    @Test(groups = {Categories.REGRESSION})
    public void deleteEmployee(){
        new DeleteEmployeeClient().deleteMember()
                                  .assertSuccess();
    }
}
