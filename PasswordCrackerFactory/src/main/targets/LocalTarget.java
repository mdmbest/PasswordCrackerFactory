package main.targets;

import main.interfaces.Target;

public class LocalTarget implements Target {
    private final String correctLogin = "admin";
    private final String correctPassword = "passer1234";

    @Override
    public boolean attemptLogin(String login, String password) {
        return login.equals(correctLogin) && password.equals(correctPassword);
    }
}
