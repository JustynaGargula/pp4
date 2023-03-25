package pl.justyna.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal balance;
    private BigDecimal credit;

    private int withdrawals = 0;
    public CreditCard(String cardNumber){

    }

    public void assignCredit(BigDecimal creditAmount) {                 //ustawiamy wysokosc kredytu
        if (isBelowThreshold(creditAmount)) {                           // threshold - granica
            throw new CreditBelowLimitException();
        }

        if (credit != null){
            throw new CantAssignCreditTwiceException();                 //nie mozna dwa razy przypisac kredytu
        }

        this.balance = creditAmount;
        this.credit = creditAmount;

    }

    private static boolean isBelowThreshold(BigDecimal creditAmount){       //sprawdza czy ustawiany kredyt jest < 100
        return creditAmount.compareTo(BigDecimal.valueOf(100)) < 0;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void withdraw(BigDecimal withdrawAmount) {

        if (withdrawAmount.compareTo(credit) > 0){      //jeśli kwota do wziecia > limitu kredytu
            throw new WithdrawalOverLimit();
        }
        if (withdrawAmount.compareTo(balance) > 0){
            throw new NotEnoughMoney();
        }
        if(withdrawals >= 10){
            throw new AlreadyWithdrawn10Times();
        }

        this.balance = balance.subtract(withdrawAmount);
        withdrawals++;
    }
}
