package clients.addEmployee.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddEmployeeRequest {
    private String name;
    private String salary;
    private String age;
}
