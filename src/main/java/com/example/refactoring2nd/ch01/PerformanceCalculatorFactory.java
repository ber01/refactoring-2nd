package com.example.refactoring2nd.ch01;

import com.example.refactoring2nd.ch01.ComedyCalculator;
import com.example.refactoring2nd.ch01.PerformanceCalculator;
import com.example.refactoring2nd.ch01.TragedyCalculator;
import com.example.refactoring2nd.ch01.type.Performance;
import com.example.refactoring2nd.ch01.type.Play;

public class PerformanceCalculatorFactory {

    public static PerformanceCalculator createPerformanceCalculator(Performance aPerformance, Play aPlay) {
        switch (aPlay.type) {
            case TRAGEDY -> {
                return new TragedyCalculator(aPerformance, aPlay);
            }
            case COMEDY -> {
                return new ComedyCalculator(aPerformance, aPlay);
            }
            default -> {
                try {
                    throw new Exception("알 수 없는 장르: " + aPlay.type);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
