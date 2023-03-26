package pl.justyna.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal balance;
    private BigDecimal credit;

    private int withdrawals = 0;

    private BigDecimal debt = BigDecimal.valueOf(0);

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
            throw new WithdrawalOverLimitException();
        }
        if (withdrawAmount.compareTo(balance) > 0){
            throw new NotEnoughMoneyException();
        }
        if(withdrawals >= 10){
            throw new AlreadyWithdrawn10TimesException();
        }

        this.balance = balance.subtract(withdrawAmount);
        withdrawals++;
        debt = debt.add(withdrawAmount);
    }

    public void repay(BigDecimal repayAmount){             // zakladam, ze splacic mozna kwote wyplacona, zmienna debt
        debt = debt.subtract(repayAmount);
    }

    public BigDecimal getDebt() {
        return debt;
    }
}
