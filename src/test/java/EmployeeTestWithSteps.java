import clients.steps.StartingStep;
import entities.Employee;
import entities.ScenarioContext;
import entities.UseCase;
import org.testng.annotations.Test;
import utils.Categories;

public class EmployeeTestWithSteps {
    private UseCase useCase;

    @Test(groups = {Categories.SMOKE})
    public void addUpdateDeleteEmployee(){
        Employee employee = new Employee("Employee2", "25000", "30");
        useCase = new UseCase(employee);
        ScenarioContext.getInstance().setUseCase(useCase);
        ScenarioContext.getInstance().getUseCase().setEmployee(employee);

        new StartingStep(useCase).proceedTillDeleteEmployeeStep().deleteEmployee().assertSuccess();
    }
}
