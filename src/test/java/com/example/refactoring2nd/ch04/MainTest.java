package com.example.refactoring2nd.ch04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    Province asia;

    @BeforeEach
    public void beforeEach() {
        asia = new Province(Doc.sampleProvinceData());
    }

    @Test
    public void shortfall() {
        assertThat(asia.shortfall()).isEqualTo(5);
    }

    @Test
    public void profit() {
        assertThat(asia.profit()).isEqualTo(230);
    }

    @Test
    public void changeProduction() {
        asia.producers.get(0).setProduction(20);
        assertThat(asia.shortfall()).isEqualTo(-6);
        assertThat(asia.profit()).isEqualTo(292);
    }

}