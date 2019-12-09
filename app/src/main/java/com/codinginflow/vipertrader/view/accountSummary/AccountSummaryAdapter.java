package com.codinginflow.vipertrader.view.accountSummary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codinginflow.vipertrader.R;
import com.codinginflow.vipertrader.data.AccountSummaryItem;

import java.util.ArrayList;
import java.util.List;

public class AccountSummaryAdapter extends RecyclerView.Adapter<AccountSummaryAdapter.MyViewHolder> {


    private List<AccountSummaryItem> accountSummaryItems = new ArrayList<>();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView symbol, quantity, price, amount;

        public MyViewHolder(View view) {
            super(view);
            symbol = view.findViewById(R.id.symbol);
            quantity = view.findViewById(R.id.quantity);
            price = view.findViewById(R.id.price);
            amount = view.findViewById(R.id.amount);
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.account_summary_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        AccountSummaryItem accountSummaryItem = accountSummaryItems.get(position);
        holder.symbol.setText(accountSummaryItem.getSymbol());
        holder.quantity.setText(String.valueOf(accountSummaryItem.getQuantity()));
        holder.price.setText(String.valueOf(accountSummaryItem.getPrice()));
        double amount = accountSummaryItem.getPrice() * accountSummaryItem.getQuantity();
        holder.amount.setText(String.valueOf(amount));

    }

    @Override
    public int getItemCount() {
        return accountSummaryItems.size();
    }

    public void setAccountSummaryItems(List<AccountSummaryItem> accountSummaryItems) {
        this.accountSummaryItems = accountSummaryItems;
        notifyDataSetChanged();
    }
}
