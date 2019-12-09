package com.codinginflow.vipertrader.data;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("Result")
    private Result result;


    @SerializedName("DefaultAccount")
    private String defaultAcoount;


    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getDefaultAcoount() {
        return defaultAcoount;
    }

    public void setDefaultAcoount(String defaultAcoount) {
        this.defaultAcoount = defaultAcoount;
    }

}
