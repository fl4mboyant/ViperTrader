package com.codinginflow.vipertrader.view.login;

import android.text.TextUtils;
import android.util.Log;

import com.codinginflow.vipertrader.data.LoginResponse;
import com.codinginflow.vipertrader.service.Api;
import com.codinginflow.vipertrader.service.SingletonClass;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginPresenterImpl implements LoginContract.LoginPresenter {
    private LoginContract.LoginView loginView;

    public LoginPresenterImpl(LoginContract.LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void login(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            loginView.showValidationErrorMsg();
        } else {

            Api api = SingletonClass.getInstance().getApi();

            Map<String, String> map = new HashMap<>();
            map.put("MsgType", "A");
            map.put("CustomerNo", "0");
            map.put("Username", username);
            map.put("Password", password);
            map.put("AccountID", "0");
            map.put("ExchangeID", "4");
            map.put("OutputType", "2");


            api.login(map).enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                    if (response.isSuccessful()) {
                        if (response.body().getResult().getState()) {
                            loginView.loginSuccessFully(response.body().getDefaultAcoount());
                        } else {
                            Log.e("LoginPresenterImpl", response.body().getResult().getDescription());
                            loginView.loginFail();
                        }
                    } else {
                        Log.e("LoginPresenterImpl", "resonponse unsuccesful. response code: " + response.code());
                        loginView.loginFail();
                    }

                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Log.e("LoginPresenterImpl", t.getMessage(), t);
                    loginView.loginFail();
                }
            });

        }
    }
}