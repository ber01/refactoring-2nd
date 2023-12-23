package com.example.refactoring2nd.ch04;

import lombok.Builder;
import lombok.ToString;

import java.util.List;

@Builder
@ToString
public class ProvinceData {

    private String name;

    private List<Producer> producers;

    private int demand;

    private int price;

    public static ProvinceData sampleProvinceData() {
        return ProvinceData.builder()
                .name("Asia")
//                .producers
                .demand(30)
                .price(20)
                .build();
    }

}
