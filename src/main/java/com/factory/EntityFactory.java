package com.factory;

import com.models.Orders;

public class EntityFactory extends AbstractFactory{
    @Override
    public Orders anOrder(){
        return new Orders();
    }
}
