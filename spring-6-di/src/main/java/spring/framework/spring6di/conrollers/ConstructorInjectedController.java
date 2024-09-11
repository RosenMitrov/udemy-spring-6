package spring.framework.spring6di.conrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.framework.spring6di.services.GreetingService;

@Controller
public class ConstructorInjectedController {

    //Recommended way - Constructor injection.
    private final GreetingService greetingService;

    @Autowired
    public ConstructorInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return this.greetingService.sayGreeting();
    }
}
