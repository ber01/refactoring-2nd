package com.example.refactoring2nd.ch04;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
public class Doc {

    private String name;

    private List<Data> producers;

    private int demand;

    private int price;

    public static Doc sampleProvinceData() {
        Data data1 = new Data("Byzantium", 10, 9);
        Data data2 = new Data("Attalia", 12, 10);
        Data data3 = new Data("Sinope", 10, 6);
        return Doc.builder()
                .name("Asia")
                .producers(List.of(data1, data2, data3))
                .demand(30)
                .price(20)
                .build();
    }

}
