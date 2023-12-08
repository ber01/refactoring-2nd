package com.example.refactoring2nd.ch01;

import com.example.refactoring2nd.ch01.type.Invoice;
import com.example.refactoring2nd.ch01.type.Performance;
import com.example.refactoring2nd.ch01.type.Play;
import com.example.refactoring2nd.ch01.type.Type;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class MainTest {

    final String expected = "청구 내역 (고객명: BigCo)\n" +
            " Hamlet: $650.00 (55)석\n" +
            " As You Like It: $580.00 (35)석\n" +
            " Othello: $500.00 (40)석\n" +
            "총액: $1,730.00\n" +
            "적립 포인트: 47점\n";

    @Test
    void test() throws Exception {
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
        String actual = main.statement(invoice, plays);

        assertThat(actual).isEqualTo(expected);
    }

}