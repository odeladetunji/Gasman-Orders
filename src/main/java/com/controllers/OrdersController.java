package com.controllers;

import com.models.Orders;
import com.services.OrdersServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
