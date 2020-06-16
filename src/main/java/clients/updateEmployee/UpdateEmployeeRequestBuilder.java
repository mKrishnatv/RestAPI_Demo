package clients.updateEmployee;

import clients.updateEmployee.request.UpdateEmployeeRequest;
import entities.Employee;

public class UpdateEmployeeRequestBuilder {

    private UpdateEmployeeRequest request;

    public UpdateEmployeeRequestBuilder() { request = new UpdateEmployeeRequest(); }

    public UpdateEmployeeRequestBuilder withEmployeeDetails(Employee employee){
        request.setName(employee.getName());
        request.setSalary(employee.getSalary());
        request.setAge(employee.getAge());
        return this;
    }

    public UpdateEmployeeRequest build(){ return request; }

}
