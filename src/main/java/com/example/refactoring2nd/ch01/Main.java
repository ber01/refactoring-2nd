package com.example.refactoring2nd.ch01;

import com.example.refactoring2nd.ch01.type.Invoice;
import com.example.refactoring2nd.ch01.type.Performance;
import com.example.refactoring2nd.ch01.type.Play;
import com.example.refactoring2nd.ch01.type.Type;

import java.text.NumberFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, Play> plays = new HashMap<>();
        plays.put("hamlet", Play.builder().name("Hamlet").type(Type.TRAGEDY).build());
        plays.put("as-like", Play.builder().name("As You Like It").type(Type.COMEDY).build());
        plays.put("othello", Play.builder().name("Othello").type(Type.TRAGEDY).build());

        List<Performance> performances = new ArrayList<>();
        performances.add(Performance.builder().playID("hamlet").audience(55).build());
        performances.add(Performance.builder().playID("as-like").audience(35).build());
        performances.add(Performance.builder().playID("othello").audience(40).build());

        Invoice invoice = Invoice.builder().customer("BigCo").performances(performances).build();

        Main main = new Main();
        try {
            System.out.println(main.statement(invoice, plays));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String statement(Invoice invoice, Map<String, Play> plays) throws Exception {
        int totalAmount = 0;
        int volumeCredits = 0;
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        format.setMinimumFractionDigits(2);

        String result = String.format("청구 내역 (고객명: %s)\n", invoice.customer);

        for (Performance perf: invoice.performances) {
            Play play = plays.get(perf.playID);
            int thisAmount = 0;

            switch (play.type) {
                case TRAGEDY -> {
                    thisAmount = 40_000;
                    if (perf.audience > 30) {
                        thisAmount += 1_000 * (perf.audience - 30);
                    }
                }
                case COMEDY -> {
                    thisAmount = 30_000;
                    thisAmount += 300 * perf.audience;
                    if (perf.audience > 20) {
                        thisAmount += 10_000 + 500 * (perf.audience - 20);
                    }
                }
                default -> throw new Exception("알 수 없는 장르: " + play.type);
            }

            // 포인트를 적립한다.
            volumeCredits += Math.max(perf.audience - 30, 0);

            // 희극 관객 5명마다 추가 포인트를 제공한다
            if (play.type == Type.COMEDY) {
                volumeCredits += (int) Math.floor((double) perf.audience / 5);
            }

            // 청구 내역을 출력한다.
            result += String.format(" %s: %s (%d)석\n", play.name, format.format(thisAmount / 100), perf.audience);
            totalAmount += thisAmount;
        }

        result += String.format("총액: %s\n", format.format(totalAmount/100));
        result += String.format("적립 포인트: %d점\n", volumeCredits);

        return result;
    }
}
