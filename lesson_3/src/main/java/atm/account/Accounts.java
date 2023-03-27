package atm.account;

import java.util.HashMap;
import java.util.Map;

public class Accounts {
    private final static Map<String , AccountInterface> accounts = new HashMap<>();

    static {
        accounts.put("semen", new Account(1500));
    }

    public static AccountInterface getAccount(String login) {
        return accounts.get(login);
    }
}
