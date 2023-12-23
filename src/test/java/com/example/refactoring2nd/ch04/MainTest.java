package com.example.refactoring2nd.ch04;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @Test
    public void test() {
        Province asia = new Province(sampleProvinceData());
        assertThat(asia.shortfall()).isEqualTo(5);
    }

    private static Doc sampleProvinceData() {
        return Doc.sampleProvinceData();
    }

}