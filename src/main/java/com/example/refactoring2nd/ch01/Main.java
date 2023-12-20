package com.example.refactoring2nd.ch01;

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

    private String renderHtml(StatementData data) throws Exception {
        StringBuilder result = new StringBuilder(String.format("<h1> 청구내역 (고객명: %s)\n </h1>", data.getCustomer()));
        result.append("<table> \n");
        result.append("<tr><th> 연극 </th> <th>좌석 수</th> <th>금액</th>");
        for (Performance perf : data.getPerformances()) {
            result.append(String.format("<tr><td> %s: </td> <td> $%s </td> <td> %d석 </td></tr>\n", data.playFor(perf).name, usd(data.amountFor(perf)), perf.audience));
            result.append(String.format("<tr><td> %s: </td> <td> $%s </td> <td> %d석 </td></tr>\n", data.playFor(perf).name, usd(data.amountFor(perf)), perf.audience));
        }
        result.append("</table>\n");

        result.append(String.format("총액: $%s\n", usd(data.totalAmount())));
        result.append(String.format("적립 포인트: %d점", data.totalVolumeCredits()));
        return result.toString();
    }

    private String usd(int aNumber) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        format.setMinimumFractionDigits(2);
        return format.format(aNumber / 100);
    }

}
