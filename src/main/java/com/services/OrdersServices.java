package com.services;

import com.confiq.BeanGenerator;
import com.dao.OrdersRepository;
import com.models.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServices implements OrdersServicesInterface{

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    BeanGenerator beanGenerator;

    public BeanGenerator anOrder(Orders payload){
        beanGenerator.anOrderObj().amount = payload.amount;
        beanGenerator.anOrderObj().deliveryAddress = payload.deliveryAddress;
        beanGenerator.anOrderObj().orderOption = payload.orderOption;
        beanGenerator.anOrderObj().quantity = payload.quantity;
        beanGenerator.anOrderObj().gasSize = payload.gasSize;

        return beanGenerator;
    }

    @Override
    public StringBuilder placeOrder(Orders payload){
        StringBuilder aString = new StringBuilder();
        try{
            ordersRepository.save(anOrder(payload).anOrderObj());
            aString.append("successfull");
            return aString;
        }catch (Exception ex){
            aString.append("unsuccessfull");
            return aString;
        }
    }
}
