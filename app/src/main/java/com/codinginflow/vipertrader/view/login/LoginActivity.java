package com.codinginflow.vipertrader.view.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.codinginflow.vipertrader.R;
import com.codinginflow.vipertrader.view.accountSummary.AccountSummaryActivity;


public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView {
    private LoginContract.LoginPresenter presenter;
    private TextView textViewUserName;
    private TextView textViewPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initializeView();
        presenter = new LoginPresenterImpl(this);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login(textViewUserName.getText().toString(), textViewPassword.getText().toString());
            }
        });
    }

    private void initializeView() {
        textViewUserName = findViewById(R.id.textViewUserName);
        textViewPassword = findViewById(R.id.textViewPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
    }

    @Override
    public void showValidationErrorMsg() {
        Toast.makeText(this, "Giriş başarısız.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccessFully(String defaultAcoount) {
        Toast.makeText(this, "Giriş başarılı", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, AccountSummaryActivity.class);
        intent.putExtra("accno", defaultAcoount);
        intent.putExtra("username", textViewUserName.getText().toString());
        intent.putExtra("password", textViewPassword.getText().toString());
        startActivity(intent);
    }


    @Override
    public void loginFail() {
        Toast.makeText(this, "Giriş başarısızz", Toast.LENGTH_SHORT).show();
    }
}