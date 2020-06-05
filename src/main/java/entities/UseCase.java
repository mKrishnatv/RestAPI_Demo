package entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UseCase {
    Employee employee;

    public UseCase(Employee employee){
        this.employee = employee;
    }
}
