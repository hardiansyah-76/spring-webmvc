package yukinarisoftware.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/*
* PATH VARIABLE FOR DYNAMIC URL*/

@Controller
public class OrderController {


    @ResponseBody
    @GetMapping(path = "/orders/{orderId}/products/{productId}")
    public String order(
            @PathVariable(name = "orderId") String orderId,
            @PathVariable(name = "productId") String productId
    ) {

        return "order " + orderId + ", product " + productId;
    }
}
