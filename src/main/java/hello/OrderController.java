package hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {
    
    @RequestMapping(value ="/orders", method = RequestMethod.POST)
    public ResponseEntity<?> createOrder(@RequestBody Order order)
    {
        //XXX: invoke service
        System.out.println("=======");
        System.out.println(order);
        return new ResponseEntity<>(new Order("1234"), HttpStatus.OK);
    }
    
}
