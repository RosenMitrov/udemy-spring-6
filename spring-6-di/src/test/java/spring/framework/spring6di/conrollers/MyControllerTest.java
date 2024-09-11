package spring.framework.spring6di.conrollers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyControllerTest {

    @Test
    void test_sayHello() {
        MyController controller = new MyController();

        System.out.println(controller.sayHello());
    }
}