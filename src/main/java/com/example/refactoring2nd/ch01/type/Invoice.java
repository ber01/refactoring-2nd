package com.example.refactoring2nd.ch01.type;

import lombok.Builder;

import java.util.List;

@Builder
public class Invoice {

    public String customer;

    public List<Performance> performances;
}
