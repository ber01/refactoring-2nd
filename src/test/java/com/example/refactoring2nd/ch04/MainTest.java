package com.example.refactoring2nd.ch04;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @Test
    public void shortfall() {
        Province asia = new Province(sampleProvinceData());
        assertThat(asia.shortfall()).isEqualTo(5);
    }

    @Test
    public void profit() {
        Province asia = new Province(sampleProvinceData());
        assertThat(asia.profit()).isEqualTo(230);
    }

    private static Doc sampleProvinceData() {
        return Doc.sampleProvinceData();
    }

}