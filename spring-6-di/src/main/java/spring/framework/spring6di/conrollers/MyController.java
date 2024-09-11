package spring.framework.spring6di.conrollers;

import org.springframework.stereotype.Controller;
import spring.framework.spring6di.services.GreetingService;
import spring.framework.spring6di.services.GreetingServiceImpl;

@Controller
public class MyController {
    private final GreetingService greetingService;

    public MyController() {
        this.greetingService = new GreetingServiceImpl();
    }

    public String sayHello() {
        System.out.println("Hello from controller!!!");

        return this.greetingService.sayGreeting();
    }
}
