package com.example.refactoring2nd.ch01;

import com.example.refactoring2nd.ch01.type.Performance;
import com.example.refactoring2nd.ch01.type.Play;

import java.util.Map;

public class Plays {

    private final Map<String, Play> map;

    public Plays(Map<String, Play> map) {
        this.map = map;
    }

    public Play get(Performance performance) {
        return map.get(performance.playID);
    }

}
