package spring.framework.spring6di.conrollers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.framework.spring6di.services.GreetingServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class SetterInjectedControllerTest {


    SetterInjectedController setterInjectedController;
    @BeforeEach
    void setUp() {
        this.setterInjectedController = new SetterInjectedController();
        //If the below code is missing sayHello test will throw NullPointerException.
        this.setterInjectedController.setGreetingService(new GreetingServiceImpl());
    }
    @Test
    void sayHello() {
        System.out.println(this.setterInjectedController.sayHello());
    }
}