package com.example.refactoring2nd.ch04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @Test
    @DisplayName("수요가 없는 경우")
    public void zeroDemand() {
        asia.demand = 0;
        assertThat(asia.shortfall()).isEqualTo(-25);
        assertThat(asia.profit()).isEqualTo(0);
    }

    @Test
    @DisplayName("수요가 음수인 경우")
    public void negativeDemand() {
        asia.demand = -1;
        assertThat(asia.shortfall()).isEqualTo(-26);
        assertThat(asia.profit()).isEqualTo(-10);
    }

}