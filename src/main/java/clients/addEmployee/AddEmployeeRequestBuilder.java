package clients.addEmployee;

import clients.addEmployee.request.AddEmployeeRequest;
import entities.Employee;

public class AddEmployeeRequestBuilder {
    private AddEmployeeRequest request;

    public AddEmployeeRequestBuilder(){
        request = new AddEmployeeRequest();
    }

    public AddEmployeeRequestBuilder withEmployeeDetails(Employee employee){
        request.setAge(employee.getAge());
        request.setName(employee.getName());
        request.setSalary(employee.getSalary());
        return this;
    }

    public AddEmployeeRequest build() {return request;}
}
