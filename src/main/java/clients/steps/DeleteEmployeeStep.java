package clients.steps;

import clients.deleteEmployee.DeleteEmployeeClient;
import clients.deleteEmployee.response.DeleteEmployeeResponse;
import entities.UseCase;

public class DeleteEmployeeStep extends BaseStep{
    public DeleteEmployeeStep(UseCase useCase) {
        super(useCase);
    }

    @Override
    public BaseStep proceedToNext() {
        // Whats next step here ?
        return this;
    }

    @Override
    public DeleteEmployeeStep proceedTillDeleteEmployeeStep() {
        return this;
    }

    public DeleteEmployeeResponse deleteEmployee() {
        return new DeleteEmployeeClient().deleteEmployee();
    }


}
