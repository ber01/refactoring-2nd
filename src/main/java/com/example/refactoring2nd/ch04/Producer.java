package com.example.refactoring2nd.ch04;

import lombok.Getter;
import lombok.Setter;

/**
 * 생산자
 * Byzanitum
 * Attalia
 * Sinope
 */
public class Producer {

    protected Province province;

    @Getter @Setter
    protected int cost;

    @Getter
    protected String name;

    @Getter
    protected int production;

    public Producer(Province aProvince, Data data) {
        this.province = aProvince;
        this.cost = data.getCost();
        this.name = data.getName();
        this.production = data.getProduction();
    }

    public void setProduction(int newProduction) {
        this.province.totalProduction += newProduction - this.production;
        this.production = newProduction;
    }

}
