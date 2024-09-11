package spring.framework.spring6di.conrollers;

import spring.framework.spring6di.services.GreetingService;

public class PropertyInjectedController {

    GreetingService greetingService;

    public String sayHallo() {
        return this.greetingService.sayGreeting();
    }
}
