package spring.framework.spring6di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import spring.framework.spring6di.conrollers.MyController;

@SpringBootTest
class Spring6DiApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    MyController controller;


    @Test
    void test_AutowireOfController() {
        System.out.println(controller.sayHello());
    }
    @Test
    void test_getController_fromCtx() {
        MyController controller = this.applicationContext.getBean(MyController.class);
        System.out.println(controller.sayHello());
    }
    @Test
    void contextLoads() {
    }

}
