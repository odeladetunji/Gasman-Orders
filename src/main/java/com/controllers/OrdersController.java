package com.controllers;

import com.models.Orders;
import com.models.Payment;
import com.services.OrdersServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrdersController {

    @Autowired
    OrdersServicesInterface ordersServicesInterface;

    @ResponseBody
    @GetMapping(path = "/ping")
    public StringBuilder ping(){
        StringBuilder aString = new StringBuilder();
        aString.append("ping successfull");
        return aString;
    }

    @ResponseBody
    @PostMapping(path = "/Gasman/placeOrder")
    public StringBuilder placeOrder(Orders payload){
        return ordersServicesInterface.placeOrder(payload);
    }

    @ResponseBody
    @GetMapping(path = "/Gasman/cancellOrder")
    public StringBuilder cancellOrder(@RequestAttribute("Id") Long id){
        return ordersServicesInterface.cancellOrder(id);
    }

    @ResponseBody
    @PostMapping(path = "/Gasman/makePayment")
    public StringBuilder makePayment(Payment payload){
        return ordersServicesInterface.makePayment(payload);
    }

}
