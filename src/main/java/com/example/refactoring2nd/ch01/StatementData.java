package com.example.refactoring2nd.ch01;

import com.example.refactoring2nd.ch01.type.Invoice;
import com.example.refactoring2nd.ch01.type.Performance;
import com.example.refactoring2nd.ch01.type.Play;

import java.util.List;

public class StatementData {

    private final Invoice invoice;

    private final Plays plays;

    public List<Performance> getPerformances() {
        return invoice.performances;
    }

    public String getCustomer() {
        return invoice.customer;
    }

    public StatementData(Invoice invoice, Plays plays) {
        this.invoice = invoice;
        this.plays = plays;
    }

    public Play playFor(Performance aPerformance) {
        return plays.get(aPerformance);
    }

    public int amountFor(Performance aPerformance) throws Exception {
        return PerformanceCalculatorFactory.createPerformanceCalculator(aPerformance, playFor(aPerformance)).amount();
    }

    public int totalAmount() throws Exception {
        int result = 0;
        for (Performance perf: getPerformances()) {
            result += amountFor(perf);
        }
        return result;
    }

    public int totalVolumeCredits() {
        int result = 0;
        for (Performance perf: getPerformances()) {
            result += volumeCreditsFor(perf);
        }
        return result;
    }

    private int volumeCreditsFor(Performance aPerformance) {
        return PerformanceCalculatorFactory.createPerformanceCalculator(aPerformance, playFor(aPerformance)).volumeCredits();
    }

}
