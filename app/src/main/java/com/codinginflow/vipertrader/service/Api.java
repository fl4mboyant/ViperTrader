package com.codinginflow.vipertrader.service;

import com.codinginflow.vipertrader.data.AccountSummaryResponse;
import com.codinginflow.vipertrader.data.LoginResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface Api {

    String BASE_URL = "https://tbpilot.matriksdata.com/9999/";


    @GET("Integration.aspx/")
    Call<LoginResponse> login(@QueryMap Map<String, String> map);

    @GET("Integration.aspx/")
    Call<AccountSummaryResponse> getAccSummary(@QueryMap Map<String, String> map);
}
