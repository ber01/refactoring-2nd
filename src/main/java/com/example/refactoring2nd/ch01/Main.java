package com.example.refactoring2nd.ch01;

import com.example.refactoring2nd.ch01.type.Invoice;
import com.example.refactoring2nd.ch01.type.Performance;
import com.example.refactoring2nd.ch01.type.Play;
import com.example.refactoring2nd.ch01.type.Type;

import java.text.NumberFormat;
import java.util.*;

public class Main {

    public String statement(Invoice invoice, Plays plays) throws Exception {
        int totalAmount = 0;
        int volumeCredits = 0;
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        format.setMinimumFractionDigits(2);

        StringBuilder result = new StringBuilder(String.format("청구 내역 (고객명: %s)\n", invoice.customer));

        for (Performance perf: invoice.performances) {
            // 포인트를 적립한다.
            volumeCredits += Math.max(perf.audience - 30, 0);

            // 희극 관객 5명마다 추가 포인트를 제공한다
            if (playFor(plays, perf).type == Type.COMEDY) {
                volumeCredits += (int) Math.floor((double) perf.audience / 5);
            }

            // 청구 내역을 출력한다.
            result.append(String.format(" %s: %s (%d)석\n", playFor(plays, perf).name, format.format(amountFor(perf, plays) / 100), perf.audience));
            totalAmount += amountFor(perf, plays);
        }

        result.append(String.format("총액: %s\n", format.format(totalAmount / 100)));
        result.append(String.format("적립 포인트: %d점\n", volumeCredits));

        return result.toString();
    }

    private Play playFor(Plays plays, Performance aPerformance) {
        return plays.get(aPerformance);
    }

    private int amountFor(Performance aPerformance, Plays plays) throws Exception {
        int result;
        switch (playFor(plays, aPerformance).type) {
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
            default -> throw new Exception("알 수 없는 장르: " + playFor(plays, aPerformance).type);
        }
        return result;
    }
}
