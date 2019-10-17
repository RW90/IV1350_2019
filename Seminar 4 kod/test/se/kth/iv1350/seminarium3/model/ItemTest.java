package se.kth.iv1350.seminarium3.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    private Item testItem;
    @BeforeEach
    void setUp() {
        testItem = new Item(1, "Lax", 50, 0.2f, "Odlad Lax");
    }

    @AfterEach
    void tearDown() {
        testItem = null;
    }

    @Test
    void isItemIdNormalFunctionTrue() {
        boolean expResult = true;
        boolean result = testItem.isItemId(1);
        assertEquals(expResult, result, "The function does not identify an item.");
    }

    @Test
    void isItemIdNormalFunctionFalse() {
        boolean expResult = false;
        boolean result = testItem.isItemId(2);
        assertEquals(expResult, result, "The function identifies an item with wrong id.");
    }

    @Test
    void changeAmountByPositive() {
        boolean expResult = true;
        int amountToChangeBy = 5;
        int amountExpValue = amountToChangeBy + testItem.getAmount();
        testItem.changeAmountBy(amountToChangeBy);
        boolean result = amountExpValue == testItem.getAmount();
        assertEquals(expResult, result, "Changing the amount by a positive value doesn't work.");
    }

    @Test
    void changeAmountByNegative() {
        boolean expResult = true;
        int amountToChangeBy = -5;
        int amountExpValue = amountToChangeBy + testItem.getAmount();
        testItem.changeAmountBy(amountToChangeBy);
        boolean result = amountExpValue == testItem.getAmount();
        assertEquals(expResult, result, "Changing the amount by a negative value doesn't work.");
    }

    @Test
    void changeAmountByZero() {
        boolean expResult = true;
        int amountToChangeBy = 0;
        int amountExpValue = amountToChangeBy + testItem.getAmount();
        testItem.changeAmountBy(amountToChangeBy);
        boolean result = amountExpValue == testItem.getAmount();
        assertEquals(expResult, result, "Changing the amount by zero changes the amount.");
    }

    @Test
    void changeAmountByOverflow() {
        boolean expResult = true;
        int amountToChangeBy = Integer.MAX_VALUE;
        testItem.changeAmountBy(1);
        testItem.changeAmountBy(amountToChangeBy);
        boolean result = 0 < testItem.getAmount();
        assertEquals(expResult, result, "Changing the amount can cause overflow.");
    }

    @Test
    void changeAmountByUnderflow() {
        boolean expResult = true;
        int amountToChangeBy = Integer.MIN_VALUE;
        testItem.changeAmountBy(-1);
        testItem.changeAmountBy(amountToChangeBy);
        boolean result = 0 > testItem.getAmount();
        assertEquals(expResult, result, "Changing the amount can cause underflow.");
    }

    @Test
    void testToString() {
        boolean expResult = true;
        testItem.changeAmountBy(1);
        String expectedString = "1x Lax\t60";
        boolean result = expectedString.equals(testItem.toString());
        assertEquals(expResult, result, "toString() is not formatted correctly.");
    }
}