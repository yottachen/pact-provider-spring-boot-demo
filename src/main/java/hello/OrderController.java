package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderRepository orders;

    @RequestMapping(value ="/orders", method = RequestMethod.POST)
    public ResponseEntity<?> createOrder(@RequestBody Order order)
    {
        //XXX: invoke service
        UUID id = UUID.randomUUID();
        order.setId(id);
        orders.save(order);
        System.out.println("=======");
        System.out.println(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
    
}
