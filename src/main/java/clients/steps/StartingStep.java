package clients.steps;

import entities.UseCase;

public class StartingStep extends BaseStep{
    public StartingStep(UseCase useCase) {
        super(useCase);
    }

    @Override
    public BaseStep proceedToNext() {
            return new AddEmployeeStep(useCase);
    }
}
