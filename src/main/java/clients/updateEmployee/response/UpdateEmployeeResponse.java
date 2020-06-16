package clients.updateEmployee.response;

import clients.BaseResponse;
import clients.addEmployee.response.AddEmployeeResponse;
import entities.Employee;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
@Setter
public class UpdateEmployeeResponse extends BaseResponse {
    private Data data;
    private String status;

    public UpdateEmployeeResponse assertThatResponseIsSuccessful() {
        Assert.assertEquals(getHttpStatusCode(), 200);
        Assert.assertEquals(getStatus(), "success");
        return this;
    }

    public UpdateEmployeeResponse assertEmployeeDetails(Employee employee){
        Assert.assertEquals(getData().getEmployee_name(), employee.getName());
        Assert.assertEquals(getData().getEmployee_salary(), employee.getSalary());
        Assert.assertEquals(getData().getEmployee_age(), employee.getAge());
        return this;
    }

}
