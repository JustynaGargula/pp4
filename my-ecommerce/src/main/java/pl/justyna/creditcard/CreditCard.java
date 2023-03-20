package pl.justyna.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal balance;
    private BigDecimal credit;
    public CreditCard(String cardNumber){

    }

    public void assignCredit(BigDecimal creditAmount) {                 //ustawiamy wysokosc kredytu
        if (isBelowThreshold(creditAmount)) {
            throw new CreditBelowLimitException();
        }

        if (credit != null){
            throw new CantAssignCreditTwiceException();
        }

        this.balance = creditAmount;
        this.credit = creditAmount;

    }

    private static boolean isBelowThreshold(BigDecimal creditAmount){
        return creditAmount.compareTo(BigDecimal.valueOf(100)) < 0;
    }

    public BigDecimal getBalance() {

        return balance;
    }

    public void withdraw(BigDecimal withdrawAmount) {
        this.balance = balance.substract(withdrawAmount);
//        if (withdrawAmount.compareTo(credit) < 0){      //<0 ? czy inaczej - sprawdzic
//            String works = "works";                     //przykladowe cos
//        }
    }
}
