package clients.addEmployee.response;

import clients.BaseResponse;
import entities.Employee;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
@Setter
public class AddEmployeeResponse extends BaseResponse {
    private Data data;
    private String status;

    public AddEmployeeResponse assertThatResponseIsSuccessful() {
        Assert.assertEquals(getHttpStatusCode(), 200);
        Assert.assertEquals(getStatus(), "success");
        return this;
    }

    public AddEmployeeResponse assertEmployeeDetails(Employee employee){
        Assert.assertEquals(getData().getName(), employee.getName());
        Assert.assertEquals(getData().getSalary(), employee.getSalary());
        Assert.assertEquals(getData().getAge(), employee.getAge());
        return this;
    }
}
