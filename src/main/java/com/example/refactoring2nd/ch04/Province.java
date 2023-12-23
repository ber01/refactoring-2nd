package com.example.refactoring2nd.ch04;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 지역 정보
 */
@Getter
public class Province {

    protected String name;
    protected List<Producer> producers;
    protected int totalProduction;
    protected int demand;
    protected int price;

    public Province(Doc doc) {
        this.name = doc.getName();
        this.producers = new ArrayList<>();
        this.totalProduction = 0;
        this.demand = doc.getDemand();
        this.price = doc.getPrice();
        doc.getProducers().forEach(d -> this.addProducer(new Producer(this, d)));
    }

    private void addProducer(Producer producer) {
        this.producers.add(producer);
        this.totalProduction += producer.getProduction();
    }

    // 생산 부족분
    public int shortfall() {
        return this.demand - this.totalProduction;
    }

    public int profit() {
        return this.demandValue() - this.demandCost();
    }

    // 수익
    public int demandValue() {
        return this.satisfiedDemand() * this.price;
    }

    public int satisfiedDemand() {
        return Math.min(this.demand, this.totalProduction);
    }

    public int demandCost() {
        int remainingDemand = this.demand;
        int result = 0;
        this.producers.sort(Comparator.comparingInt(Producer::getCost));
        for (Producer p : this.producers) {
            int contribution = Math.min(remainingDemand, p.production);
            remainingDemand -= contribution;
            result += contribution * p.cost;
        }
        return result;
    }

}
