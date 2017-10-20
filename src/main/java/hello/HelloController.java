package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public @ResponseBody Greeting index() { 
        return new Greeting(1, "World");    
    }
    
}
