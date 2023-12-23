package com.example.refactoring2nd.ch04;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    public void test() {
        ProvinceData provinceData = sampleProvinceData();
        System.out.println(provinceData.toString());
    }

    private static ProvinceData sampleProvinceData() {
        return ProvinceData.sampleProvinceData();
    }

}