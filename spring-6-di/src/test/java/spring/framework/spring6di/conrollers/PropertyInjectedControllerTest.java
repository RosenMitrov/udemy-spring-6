package spring.framework.spring6di.conrollers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.framework.spring6di.services.GreetingServiceImpl;

class PropertyInjectedControllerTest {

    PropertyInjectedController propertyInjectedController;

    @BeforeEach
    void setUp() {
        propertyInjectedController = new PropertyInjectedController();
        propertyInjectedController.greetingService = new GreetingServiceImpl();
    }

    @Test
    void test_sayHallo() {
        System.out.println(propertyInjectedController.sayHallo());
    }
}