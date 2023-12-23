package com.example.refactoring2nd.ch04;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class Data {

    private String name;
    private int cost;
    private int production;

    public Data(String name, int cost, int production) {
        this.name = name;
        this.cost = cost;
        this.production = production;
    }

}
