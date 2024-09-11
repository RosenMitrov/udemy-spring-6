package spring.framework.spring6di.conrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.framework.spring6di.services.GreetingService;

@Controller
public class PropertyInjectedController {
    //Not recommended way - Field injection.
    @Autowired
    GreetingService greetingService;

    public String sayHallo() {
        return this.greetingService.sayGreeting();
    }
}
