package com.services;

import com.confiq.BeanGenerator;
import com.dao.OrdersRepository;
import com.dao.PaymentRepository;
import com.models.Orders;
import com.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Blob;

@Service
public class OrdersServices implements OrdersServicesInterface{

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    PaymentRepository paymentRepository;

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

    public BeanGenerator aPayment(Payment payload){
        beanGenerator.aPayment().cardNumber = payload.cardNumber;
        beanGenerator.aPayment().ccv = payload.ccv;
        beanGenerator.aPayment().pin = payload.pin;

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

    @Override
    public StringBuilder cancellOrder(Long id){
        StringBuilder message = new StringBuilder();
        try{
            ordersRepository.deleteById(id);
            message.append("Order successfully cancelled");
            return message;
        }catch (Exception ex){
            message.append("unsuccessfull");
            return message;
        }
    }

   // Blob blob = new javax.sql.rowset.serial.SerialBlob();

    @Override
    public StringBuilder makePayment(Payment payload){
        StringBuilder result = new StringBuilder();
        try {
            paymentRepository.save(aPayment(payload).aPayment());
            result.append("payment successfull");
            return result;
        }catch (Exception ex){
            result.append("payment unsuccessfull");
            return result;
        }
    }
}
