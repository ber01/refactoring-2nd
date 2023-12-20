package com.example.refactoring2nd.ch01;

import com.example.refactoring2nd.ch01.type.Performance;
import com.example.refactoring2nd.ch01.type.Play;
import lombok.Getter;

@Getter
public class PerformanceCalculator {

    private final Performance performance;

    private final Play play;

    public PerformanceCalculator(Performance performance, Play play) {
        this.performance = performance;
        this.play = play;
    }

    public int amount() throws Exception {
        throw new Exception("서브 클래스에서 처리하도록 설계되었습니다.");
    }

    public int volumeCredits() {
        return Math.max(performance.audience - 30, 0);
    }

}
