package spring.framework.spring6di.conrollers;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    public String sayHello() {
        System.out.println("Hello from controller!!!");

        return "Saying hello....";
    }
}
