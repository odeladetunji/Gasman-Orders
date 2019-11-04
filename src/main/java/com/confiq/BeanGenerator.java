package com.confiq;

import com.entity.Orders;
import com.entity.Payment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanGenerator {

    @Bean
    public Orders anOrderObj(){
        return new Orders();
    }

    @Bean
   public Payment aPayment(){
        return new Payment();
    }

}
