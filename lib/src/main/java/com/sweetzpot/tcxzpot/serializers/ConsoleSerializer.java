package com.sweetzpot.tcxzpot.serializers;

import com.sweetzpot.tcxzpot.Serializer;

public class ConsoleSerializer implements Serializer {

    @Override
    public void print(String line) {
        System.out.println(line);
    }
    
}
