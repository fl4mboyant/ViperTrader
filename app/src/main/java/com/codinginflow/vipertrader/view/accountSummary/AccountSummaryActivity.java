package com.codinginflow.vipertrader.view.accountSummary;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codinginflow.vipertrader.R;
import com.codinginflow.vipertrader.data.AccountSummaryResponse;
import com.codinginflow.vipertrader.view.accountSummary.AccountSummaryContract.AccountSummaryView;

public class AccountSummaryActivity extends AppCompatActivity implements AccountSummaryContract.AccountSummaryView {

    private AccountSummaryContract.AccountSummaryPresenter accountSummaryPresenter;
    private AccountSummaryAdapter accountSummaryAdapter;
    private TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String accno = getIntent().getStringExtra("accno");
        String password = getIntent().getStringExtra("password");
        String username = getIntent().getStringExtra("username");
        Log.d("AccountSummaryActivity", "default acc no: " + accno);

        total = findViewById(R.id.total);
        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        accountSummaryAdapter = new AccountSummaryAdapter();
        recyclerView.setAdapter(accountSummaryAdapter);


        accountSummaryPresenter = new AccountSummaryPresenterImpl(this);
        accountSummaryPresenter.getAccountSummary(username, password, accno);


    }

    @Override
    public void setAccountSummary(AccountSummaryResponse response) {
        accountSummaryAdapter.setAccountSummaryItems(response.getItemList());
    }

    @Override
    public void setTotalAmount(double totalAmount) {
        total.setText(String.valueOf(totalAmount));
    }


    @Override
    public void fail() {
        Toast.makeText(this, "Hesap Bilgileri Alınamadığ", Toast.LENGTH_SHORT).show();
    }


}
