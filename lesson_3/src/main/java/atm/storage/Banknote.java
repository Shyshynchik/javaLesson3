package atm.storage;

import java.util.Arrays;

public enum Banknote {

    TEN(10),
    FIFTY(50),
    ONE_HUNDRED(100),
    TWO_HUNDRED(200),
    FIVE_HUNDRED(500),
    ONE_THOUSAND(1000),
    TWO_THOUSAND(2000),
    FIVE_THOUSAND(5000);

    private final int nominal;

    Banknote(int nominal) {
        this.nominal = nominal;
    }

    public int getNominal() {
        return nominal;
    }

    public static Banknote getValueByNominal(int nominal) {
        var banknoteOptional = Arrays.stream(Banknote.values()).filter(banknote -> banknote.getNominal() == nominal).findFirst();

        return banknoteOptional.orElse(null);
    }

}
