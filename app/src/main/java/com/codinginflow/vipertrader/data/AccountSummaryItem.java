package com.codinginflow.vipertrader.data;

import com.google.gson.annotations.SerializedName;

public class AccountSummaryItem {

    @SerializedName("Symbol")
    private String symbol;
    @SerializedName("LastPx")
    private double price;

    @SerializedName("Qty_T2")
    private double quantity;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
