package pl.justyna.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    public CreditCard(String cardNumber){

    }

    public void assignCredit(int creditAmount) {
        if ( creditAmount.compareTo(BigDecimal.valueOf(100)) < 0 {          //isBelowThereshold - funkcja zmienic
            throw new CreditLimitBelowCertainThresholdException();
        }

        this.balance = creditAmount;

    }

    public BigDecimal getBalance() {
        return balance;
    }
}
