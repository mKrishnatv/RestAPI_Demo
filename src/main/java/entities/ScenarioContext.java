package entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScenarioContext {
    private ScenarioContext(){}

    private static ThreadLocal<ScenarioContext> _threadLocal =
            ThreadLocal.withInitial(() -> new ScenarioContext());

    public static ScenarioContext getInstance() {
        return _threadLocal.get();
    }

    public static void setInstanceAsNull() {
        _threadLocal.set(null);
    }

    UseCase useCase;
}
