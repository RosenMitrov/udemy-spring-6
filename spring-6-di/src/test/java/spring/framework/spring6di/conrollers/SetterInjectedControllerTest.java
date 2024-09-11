package spring.framework.spring6di.conrollers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SetterInjectedControllerTest {


    @Autowired
    SetterInjectedController setterInjectedController;

    //    @BeforeEach
//    void setUp() {
//        this.setterInjectedController = new SetterInjectedController();
//        //If the below code is missing sayHello test will throw NullPointerException.
//        this.setterInjectedController.setGreetingService(new GreetingServiceImpl());
//    }
    @Test
    void sayHello() {
        System.out.println(this.setterInjectedController.sayHello());
    }
}