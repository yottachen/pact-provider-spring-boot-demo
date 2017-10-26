package order;

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
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @RequestMapping(value ="/orders/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getOrder(@PathVariable String id)
    {
        Order order = orders.findOne(UUID.fromString(id));
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

}
