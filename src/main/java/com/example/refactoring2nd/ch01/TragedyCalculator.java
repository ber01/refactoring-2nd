package com.example.refactoring2nd.ch01;

import com.example.refactoring2nd.ch01.type.Performance;
import com.example.refactoring2nd.ch01.type.Play;
import com.example.refactoring2nd.ch01.type.Type;

public class TragedyCalculator extends PerformanceCalculator {

    public TragedyCalculator(Performance performance, Play play) {
        super(performance, play);
    }

    @Override
    public int amount() {
        int result = 40_000;
        if (getPerformance().audience > 30) {
            result += 1_000 * (getPerformance().audience - 30);
        }
        return result;
    }
}
