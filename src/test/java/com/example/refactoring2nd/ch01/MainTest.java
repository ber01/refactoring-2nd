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

    final String expected = """
            청구 내역 (고객명: BigCo)
             Hamlet: $650.00 (55)석
             As You Like It: $580.00 (35)석
             Othello: $500.00 (40)석
            총액: $1,730.00
            적립 포인트: 47점
            """;

    @Test
    void test() throws Exception {
        Map<String, Play> map = new HashMap<>();
        map.put("hamlet", Play.builder().name("Hamlet").type(Type.TRAGEDY).build());
        map.put("as-like", Play.builder().name("As You Like It").type(Type.COMEDY).build());
        map.put("othello", Play.builder().name("Othello").type(Type.TRAGEDY).build());
        Plays plays = new Plays(map);

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