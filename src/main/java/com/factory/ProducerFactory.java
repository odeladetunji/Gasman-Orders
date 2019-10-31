package com.factory;

public class ProducerFactory {
    public static AbstractFactory anEntity(){
        return new EntityFactory();
    }
}
