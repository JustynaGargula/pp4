package pl.justyna.creditcard;

import org.junit.jupiter.api.Test;
import pl.justyna.creditcard.CreditCard;
import pl.justyna.creditcard.CreditLimitBelowCertainThresholdException;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class CreditCardTest {

    @Test
    void itAllowsToAsignCreditLimit(){
            //Arrange
        CreditCard card = new CreditCard("1234-4567");
            //Act
        card.assignCredit(BigDecimal.valueOf(1000));
            //Assert
        assertEquals(BigDecimal.valueOf(1000), card.getBalance());
        }

    @Test
    void itAllowsToAsignDifferentCreditLimit(){
        //Arrange
        CreditCard card1 = new CreditCard("1234-4567");
        CreditCard card2 = new CreditCard("1234-4568");
        //Act
        card1.assignCredit(BigDecimal.valueOf(1000));
        card2.assignCredit(BigDecimal.valueOf(1000));
        //Assert
        assertEquals(BigDecimal.valueOf(1000), card1.getBalance());
        assertEquals(BigDecimal.valueOf(1000), card2.getBalance());
    }

    @Test
    void itCanAssignLimitBelowCertainThreshold(){
        CreditCard card = new CreditCard("1234-4567");

        try{
            card.assignCredit(BigDecimal.valueOf(10));
            fail("Should throw exception");

        } catch (CreditLimitBelowCertainThresholdException e){
            assertTrue(true);
        }

        assertThrows(CreditLimitBelowCertainThresholdException.class,
                () -> card.assignCredit(BigDecimal.valueOf(10)));              //Lambda
        assertThrows(CreditLimitBelowCertainThresholdException.class,
                () -> card.assignCredit(BigDecimal.valueOf(99)));
        assertDoesNotThrow(CreditLimitBelowCertainThresholdException.class,
                () -> card.assignCredit(BigDecimal.valueOf(100)));


    }



    @Test
    void checkDoublesAndFloats() {
        double x1 = 0.01;
        double x2 = 0.03;
        double result = x2 - x1;

        float y1 = 0.01f;
        float y2 = 0.03f;
        float yresult = y2-y1;
            }
        }