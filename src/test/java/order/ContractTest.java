package order;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;

@RunWith(SpringRestPactRunner.class) // Say JUnit to run tests with custom Runner
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Provider("OrderService") // Set up name of tested provider
@PactFolder("pacts/order") // Point where to find pacts (See also section Pacts source in documentation)
public class ContractTest {
    // NOTE: this is just an example of embedded service that listens to requests, you should start here real service
    //@ClassRule //Rule will be applied once: before/after whole contract test suite
    //public static final ClientDriverRule embeddedService = new ClientDriverRule(8332);

    @LocalServerPort
    private int port = 8080;

    @BeforeClass //Method will be run once: before whole contract test suite
    public static void setUpService() {
        //Run DB, create schema
        //Run service
        //...
    }

    @Before //Method will be run before each test of interaction
    public void before() {
        // Rest data
        // Mock dependent service responses
        // ...

    }

    @State("default") // Method will be run before testing interactions that require "default" or "no-data" state
    public void toDefaultState() {
        // Prepare service before interaction that require "default" state
        // ...
        System.out.println("Now service in default state");
    }


    @TestTarget // Annotation denotes Target that will be used for tests
    public final Target target = new HttpTarget(port); // Out-of-the-box implementation of Target (for more information take a look at Test Target section)
}