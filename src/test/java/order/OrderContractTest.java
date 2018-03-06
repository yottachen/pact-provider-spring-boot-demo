package order;

import au.com.dius.pact.provider.junit.Consumer;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.flywaydb.core.Flyway;
import org.flywaydb.test.annotation.FlywayTest;
import org.flywaydb.test.junit.FlywayTestExecutionListener;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;


@RunWith(SpringRestPactRunner.class) // Say JUnit to run tests with custom Runner
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Provider("OrderService") // Set up name of tested provider
@PactFolder("src/test/java/pacts/order") // Point where to find pacts (See also section Pacts source in documentation)
@FlywayTest(invokeCleanDB = true)
public class OrderContractTest {
    private int port = 8080;

    @Autowired
    private Flyway flyway;

    @State("have an order")
    public void toPreparedOrder() {
        flyway.clean();
        flyway.setLocations("/db/migration","/db/migration_order");
        flyway.migrate();
    }

    @TestTarget // Annotation denotes Target that will be used for tests
    public final Target target = new HttpTarget(port); // Out-of-the-box implementation of Target (for more information take a look at Test Target section)
}