package com.example.refactoring2nd.ch01;

import com.example.refactoring2nd.StatementData;
import com.example.refactoring2nd.ch01.type.Invoice;
import com.example.refactoring2nd.ch01.type.Performance;

import java.text.NumberFormat;
import java.util.Locale;

public class Main {

    public String statement(Invoice invoice, Plays plays) throws Exception {
        StatementData statementData = new StatementData(invoice, plays);
        return renderPlainText(statementData);
    }

    private String renderPlainText(StatementData data) throws Exception {
        StringBuilder result = new StringBuilder(String.format("청구 내역 (고객명: %s)\n", data.getCustomer()));
        for (Performance perf: data.getPerformances()) {
            result.append(String.format(" %s: %s (%d)석\n", data.playFor(perf).name, usd(data.amountFor(perf)), perf.audience));
        }
        result.append(String.format("총액: %s\n", usd(data.totalAmount())));
        result.append(String.format("적립 포인트: %d점\n", data.totalVolumeCredits()));
        return result.toString();
    }

    private String usd(int aNumber) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        format.setMinimumFractionDigits(2);
        return format.format(aNumber / 100);
    }

}
