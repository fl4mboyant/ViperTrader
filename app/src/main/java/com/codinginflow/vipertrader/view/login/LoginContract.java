package com.codinginflow.vipertrader.view.login;

public interface LoginContract {
    interface LoginView {
        void showValidationErrorMsg();

        void loginSuccessFully(String defaultAcoount);

        void loginFail();
    }

    interface LoginPresenter {
        void login(String username, String password);
    }
}
