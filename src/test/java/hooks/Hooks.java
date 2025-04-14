package hooks;

import com.booksapi.utils.ContextManager;
import io.cucumber.java.After;

public class Hooks {

    @After
    public void afterScenario() {
        ContextManager.cleanUp();
    }
}