package entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    String name;
    String salary;
    String age;

    public Employee(String name, String salary, String age){
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
}
