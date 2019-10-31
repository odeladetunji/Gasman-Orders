package com.confiq;

import com.entity.Orders;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanGenerator {

    @Bean
    public Orders anOrderObj(){
        return new Orders();
    }

}
