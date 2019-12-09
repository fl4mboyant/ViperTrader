package com.codinginflow.vipertrader.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AccountSummaryResponse {
    @SerializedName("Result")
    private Result result;


    @SerializedName("Item")
    private List<AccountSummaryItem> itemList;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public List<AccountSummaryItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<AccountSummaryItem> itemList) {
        this.itemList = itemList;
    }
}