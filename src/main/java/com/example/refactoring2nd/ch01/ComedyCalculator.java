package com.example.refactoring2nd.ch01;

import com.example.refactoring2nd.ch01.type.Performance;
import com.example.refactoring2nd.ch01.type.Play;

public class ComedyCalculator extends PerformanceCalculator {

    public ComedyCalculator(Performance performance, Play play) {
        super(performance, play);
    }

    @Override
    public int amount() {
        int result = 30_000;
        result += 300 * getPerformance().audience;
        if (getPerformance().audience > 20) {
            result += 10_000 + 500 * (getPerformance().audience - 20);
        }
        return result;
    }

    @Override
    public int volumeCredits() {
        return super.volumeCredits() + (int) Math.floor((double) getPerformance().audience / 5);
    }
}
