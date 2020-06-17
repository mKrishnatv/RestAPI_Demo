package clients.steps;

import entities.UseCase;

public class BaseStep {
    public UseCase useCase;

    public BaseStep(UseCase useCase) {
        this.useCase = useCase;
    }

    public BaseStep proceedToNext() {
        return this;
    }

    public AddEmployeeStep proceedTillAddEmployeeStep() {
        return proceedToNext().proceedTillAddEmployeeStep();
    }

    public UpdateEmployeeStep proceedTillUpdateEmployeeStep() {
        return proceedToNext().proceedTillUpdateEmployeeStep();
    }

    public DeleteEmployeeStep proceedTillDeleteEmployeeStep() {
        return proceedToNext().proceedTillDeleteEmployeeStep();
    }
}
