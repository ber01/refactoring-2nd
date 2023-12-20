package com.example.refactoring2nd;

import com.example.refactoring2nd.ch01.Plays;
import com.example.refactoring2nd.ch01.type.Invoice;
import com.example.refactoring2nd.ch01.type.Performance;
import com.example.refactoring2nd.ch01.type.Play;
import com.example.refactoring2nd.ch01.type.Type;

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
        int result;
        switch (playFor(aPerformance).type) {
            case TRAGEDY -> {
                result = 40_000;
                if (aPerformance.audience > 30) {
                    result += 1_000 * (aPerformance.audience - 30);
                }
            }
            case COMEDY -> {
                result = 30_000;
                result += 300 * aPerformance.audience;
                if (aPerformance.audience > 20) {
                    result += 10_000 + 500 * (aPerformance.audience - 20);
                }
            }
            default -> throw new Exception("알 수 없는 장르: " + playFor(aPerformance).type);
        }
        return result;
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

    private int volumeCreditsFor(Performance perf) {
        int result = 0;
        result += Math.max(perf.audience - 30, 0);
        if (Type.COMEDY == playFor(perf).type) {
            result += (int) Math.floor((double) perf.audience / 5);
        }
        return result;
    }

}
