package com.codinginflow.vipertrader.view.accountSummary;

import android.util.Log;

import com.codinginflow.vipertrader.data.AccountSummaryItem;
import com.codinginflow.vipertrader.data.AccountSummaryResponse;
import com.codinginflow.vipertrader.service.Api;
import com.codinginflow.vipertrader.service.SingletonClass;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AccountSummaryPresenterImpl implements AccountSummaryContract.AccountSummaryPresenter {

    private AccountSummaryContract.AccountSummaryView accountSummaryView;

    public AccountSummaryPresenterImpl(AccountSummaryContract.AccountSummaryView accountSummaryView) {
        this.accountSummaryView = accountSummaryView;
    }


    @Override
    public void getAccountSummary(String username, String password, String accountID) {


        Api api = SingletonClass.getInstance().getApi();

//            MsgType=A&CustomerNo=0&Username=proje&Password=proje&AccountID=0&ExchangeID=4&OutputType=2
        Map<String, String> map = new HashMap<>();
        map.put("MsgType", "AN");
        map.put("CustomerNo", "0");
        map.put("Username", username);
        map.put("Password", password);
        map.put("AccountID", accountID);
        map.put("ExchangeID", "4");
        map.put("OutputType", "2");


        api.getAccSummary(map).enqueue(new Callback<AccountSummaryResponse>() {
            @Override
            public void onResponse(Call<AccountSummaryResponse> call, Response<AccountSummaryResponse> response) {

                if (response.isSuccessful()) {
                    if (response.body().getResult().getState()) {
                        accountSummaryView.setAccountSummary(response.body());
                        double totalAmount = 0;
                        for (AccountSummaryItem accountSummaryItem : response.body().getItemList()) {
                            totalAmount += accountSummaryItem.getPrice() * accountSummaryItem.getQuantity();
                        }

                        accountSummaryView.setTotalAmount(totalAmount);
                    } else {
                        Log.e("AccSummaryPresenterImpl", response.body().getResult().getDescription());
                        accountSummaryView.fail();
                    }
                } else {
                    Log.e("AccSummaryPresenterImpl", "resonponse unsuccesful. response code: " + response.code());
                    accountSummaryView.fail();
                }

            }

            @Override
            public void onFailure(Call<AccountSummaryResponse> call, Throwable t) {
                Log.e("AccSummaryPresenterImpl", t.getMessage(), t);
                accountSummaryView.fail();
            }
        });
    }
}
