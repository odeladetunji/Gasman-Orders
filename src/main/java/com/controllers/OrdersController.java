package com.controllers;

import com.models.Orders;
import com.models.Payment;
import com.services.OrdersServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrdersController{

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
    public String placeOrder(@RequestBody  Orders payload){
        StringBuilder result = ordersServicesInterface.placeOrder(payload);
        return result.toString();
    }

    @ResponseBody
    @GetMapping(path = "/Gasman/cancellOrder")
    public String cancellOrder(@RequestAttribute("Id") Long id){
        StringBuilder result = ordersServicesInterface.cancellOrder(id);
        return result.toString();
    }

    @ResponseBody
    @PostMapping(path = "/Gasman/makePayment")
    public String makePayment(@RequestBody Payment payload){
        StringBuilder result = ordersServicesInterface.makePayment(payload);
        return result.toString();
    }

}
