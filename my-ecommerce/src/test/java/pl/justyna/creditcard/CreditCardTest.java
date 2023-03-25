package pl.justyna.creditcard;

import org.junit.jupiter.api.Test;
import pl.justyna.creditcard.CreditCard;
import pl.justyna.creditcard.CreditBelowLimitException;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class CreditCardTest {

    @Test
    void itAllowsToAssignCreditLimit(){
            //Arrange
        CreditCard card = new CreditCard("1234-4567");
            //Act
        card.assignCredit(BigDecimal.valueOf(1000));
            //Assert
        assertEquals(BigDecimal.valueOf(1000), card.getBalance());
        }

    @Test
    void itAllowsToAssignDifferentCreditLimit(){
        //Arrange
        CreditCard card1 = new CreditCard("1234-4567");
        CreditCard card2 = new CreditCard("1234-4568");
        //Act
        card1.assignCredit(BigDecimal.valueOf(1000));
        card2.assignCredit(BigDecimal.valueOf(1100));
        //Assert
        assertEquals(BigDecimal.valueOf(1000), card1.getBalance());
        assertEquals(BigDecimal.valueOf(1100), card2.getBalance());
    }

    @Test
    void itCanAssignLimitBelowCertainThreshold(){
        CreditCard card = new CreditCard("1234-4567");
        assertThrows(
                CreditBelowLimitException.class,
                () -> card.assignCredit(BigDecimal.valueOf(10)));              //Lambda

        try{
            card.assignCredit(BigDecimal.valueOf(10));
            fail("Should throw exception");

        } catch (CreditBelowLimitException e){
            assertTrue(true);
        }


//        assertThrows(CreditBelowLimitException.class,
//                () -> card.assignCredit(BigDecimal.valueOf(99)));
//        assertDoesNotThrow(CreditBelowLimitException.class,
//                () -> card.assignCredit(BigDecimal.valueOf(100)));


    }

    @Test
    void itDenyAssignLimitTwice(){
        CreditCard card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1000));

        assertThrows(
                CantAssignCreditTwiceException.class,
                () -> card.assignCredit(BigDecimal.valueOf(1000))
        );
    }

    @Test
    void itAllowWithdraw() {
        //Arrange
        CreditCard card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1000));
        //Act
        card.withdraw(BigDecimal.valueOf(800));
        ///Assert
        assertEquals(BigDecimal.valueOf(200), card.getBalance());
    }




    @Test
    void checkDoublesAndFloats() {
        double x1 = 0.01;
        double x2 = 0.03;
        double result = x2 - x1;

        float y1 = 0.01f;
        float y2 = 0.03f;
        float yResult = y2-y1;
            }
        }