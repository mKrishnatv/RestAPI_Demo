package entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UseCase {
    Employee employee;
    int Id;

    public UseCase(Employee employee){
        this.employee = employee;
    }
}
