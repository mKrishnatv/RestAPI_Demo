import clients.addEmployee.AddEmployeeClient;
import clients.addEmployee.AddEmployeeRequestBuilder;
import clients.addEmployee.request.AddEmployeeRequest;
import clients.addEmployee.response.AddEmployeeResponse;
import clients.getAllEmployees.GetEmployeesClient;
import entities.Employee;
import org.testng.annotations.Test;
import utils.Categories;

public class EmployeesTest {

    @Test(groups = {Categories.SMOKE})
    public void getAllEmployeesList(){
        new GetEmployeesClient().getEmployeesList()
                                .assertBasicInfoNotNull();
    }

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
}
