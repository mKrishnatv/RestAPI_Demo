import clients.getAllEmployees.GetEmployeesClient;
import org.testng.annotations.Test;
import utils.Categories;

public class EmployeesTest {

    @Test(groups = {Categories.SMOKE})
    public void getAllEmployeesList(){
        new GetEmployeesClient().getEmployeesList()
                                .assertBasicInfoNotNull();

    }
}
