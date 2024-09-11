package spring.framework.spring6di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import spring.framework.spring6di.conrollers.MyController;

@SpringBootApplication
public class Spring6DiApplication {

    public static void main(String[] args) {
        ApplicationContext cxt = SpringApplication.run(Spring6DiApplication.class, args);

        System.out.println("Hello from main...");
        MyController controller = cxt.getBean(MyController.class);
        System.out.println(controller.sayHello());
    }
}
