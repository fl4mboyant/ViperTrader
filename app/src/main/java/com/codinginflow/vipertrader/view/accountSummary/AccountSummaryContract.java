package com.codinginflow.vipertrader.view.accountSummary;

import com.codinginflow.vipertrader.data.AccountSummaryResponse;

public interface AccountSummaryContract {
    interface AccountSummaryView {

        void setAccountSummary(AccountSummaryResponse accountSummaryResponse);

        void setTotalAmount(double totalAmount);

        void fail();
    }

    interface AccountSummaryPresenter {
        void getAccountSummary(String username, String password, String accountID);
    }
}
