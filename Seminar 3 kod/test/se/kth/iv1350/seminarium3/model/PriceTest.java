package se.kth.iv1350.seminarium3.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {
    Price testPrice;
    Item testItem;
    @BeforeEach
    void setUp() {
        testPrice = new Price();
        testItem = new Item(1, "Lax", 50, 0.2f, "Odlad Lax");
    }

    @AfterEach
    void tearDown() {
        testPrice = null;
        testItem = null;
    }

    @Test
    void updatePriceWithItem() {
        int expectedTotalPrice = ((int)Math.floor(testItem.getPrice()*(1 + testItem.getRateVAT())))*2;
        int expectedPrice = testItem.getPrice()*2;
        int expectedTax = (int) Math.floor(testItem.getPrice()*2*testItem.getRateVAT());
        boolean expResult = true;
        testPrice.updatePrice(testItem, 2);
        boolean resultTotal = testPrice.getTotalPrice() == expectedTotalPrice;
        boolean resultTax = testPrice.getTaxAmount() == expectedTax;
        boolean resultPrice = testPrice.getPriceWithoutTax() == expectedPrice;
        assertEquals(expResult, resultTax, "Tax gets calculated wrong.");
        assertEquals(expResult, resultPrice, "Price without tax gets calculated wrong.");
        assertEquals(expResult, resultTotal, "Total price gets calculated wrong.");
    }

    void updatePriceWithZeroItem() {
        int expectedTotalPrice = 0;
        int expectedPrice = 0;
        int expectedTax = 0;
        boolean expResult = true;
        testPrice.updatePrice(testItem, 0);
        boolean resultTotal = testPrice.getTotalPrice() == expectedTotalPrice;
        boolean resultTax = testPrice.getTaxAmount() == expectedTax;
        boolean resultPrice = testPrice.getPriceWithoutTax() == expectedPrice;
        assertEquals(expResult, resultTax, "Tax gets calculated wrong.");
        assertEquals(expResult, resultPrice, "Price without tax gets calculated wrong.");
        assertEquals(expResult, resultTotal, "Total price gets calculated wrong.");
    }

    @Test
    void updatePriceWithItemNegativeAmount() {
        int expectedTotalPrice = ((int)Math.floor(testItem.getPrice()*(1 + testItem.getRateVAT())))*-2;
        int expectedPrice = testItem.getPrice()*-2;
        int expectedTax = (int) Math.floor(testItem.getPrice()*-2*testItem.getRateVAT());
        boolean expResult = true;
        testPrice.updatePrice(testItem, -2);
        boolean resultTotal = testPrice.getTotalPrice() == expectedTotalPrice;
        boolean resultTax = testPrice.getTaxAmount() == expectedTax;
        boolean resultPrice = testPrice.getPriceWithoutTax() == expectedPrice;
        assertEquals(expResult, resultTax, "Tax gets calculated wrong.");
        assertEquals(expResult, resultPrice, "Price without tax gets calculated wrong.");
        assertEquals(expResult, resultTotal, "Total price gets calculated wrong.");
    }

    @Test
    void updatePriceWithItemNull() {
        testItem = null;
        boolean expResult = true;
        boolean result = false;
        try {
            testPrice.updatePrice(testItem, 0);
        } catch(NullPointerException e){
            result = true;
        }
        assertEquals(expResult, result, "Nullpointerexception doesn't get thrown when item is null.");
    }

    @Test
    void testUpdatePriceDiscount() {
        DiscountDTO testDiscount = new DiscountDTO(0.9f, "Test");

        int expectedTotalPrice = ((int)Math.floor(testItem.getPrice()*(1 + testItem.getRateVAT())))*2;
        int expectedPrice = testItem.getPrice()*2;
        int expectedTax = (int) Math.floor(testItem.getPrice()*2*testItem.getRateVAT());
        expectedTotalPrice *= testDiscount.getDiscountAmount();
        expectedPrice *= testDiscount.getDiscountAmount();
        expectedTax *= testDiscount.getDiscountAmount();

        testPrice.updatePrice(testItem, 2);
        testPrice.updatePrice(testDiscount);

        boolean expResult = true;
        boolean resultTotal = testPrice.getTotalPrice() == expectedTotalPrice;
        boolean resultTax = testPrice.getTaxAmount() == expectedTax;
        boolean resultPrice = testPrice.getPriceWithoutTax() == expectedPrice;

        assertEquals(expResult, resultTax, "Tax gets calculated wrong.");
        assertEquals(expResult, resultPrice, "Price without tax gets calculated wrong.");
        assertEquals(expResult, resultTotal, "Total price gets calculated wrong.");

    }

    @Test
    void testUpdatePriceDiscountNoEffect() {
        DiscountDTO testDiscount = new DiscountDTO(1.0f, "Test");

        int expectedTotalPrice = ((int)Math.floor(testItem.getPrice()*(1 + testItem.getRateVAT())))*2;
        int expectedPrice = testItem.getPrice()*2;
        int expectedTax = (int) Math.floor(testItem.getPrice()*2*testItem.getRateVAT());

        testPrice.updatePrice(testItem, 2);
        testPrice.updatePrice(testDiscount);

        boolean expResult = true;
        boolean resultTotal = testPrice.getTotalPrice() == expectedTotalPrice;
        boolean resultTax = testPrice.getTaxAmount() == expectedTax;
        boolean resultPrice = testPrice.getPriceWithoutTax() == expectedPrice;

        assertEquals(expResult, resultTax, "Tax gets calculated wrong.");
        assertEquals(expResult, resultPrice, "Price without tax gets calculated wrong.");
        assertEquals(expResult, resultTotal, "Total price gets calculated wrong.");

    }

    @Test
    void testUpdatePriceDiscountNegative() {
        DiscountDTO testDiscount = new DiscountDTO(-0.9f, "Test");

        boolean result = false;
        try {
            testPrice.updatePrice(testDiscount);
        } catch(ArithmeticException e){
            result = true;
        }

        boolean expResult = true;

        assertEquals(expResult, result, "Negative discounts doesn't throw an Arithmetic exception.");
    }

    @Test
    void testUpdatePriceDiscountFree() {
        DiscountDTO testDiscount = new DiscountDTO(0f, "Test");

        int expectedTotalPrice = ((int)Math.floor(testItem.getPrice()*(1 + testItem.getRateVAT())))*2;
        int expectedPrice = testItem.getPrice()*2;
        int expectedTax = (int) Math.floor(testItem.getPrice()*2*testItem.getRateVAT());
        expectedTotalPrice *= testDiscount.getDiscountAmount();
        expectedPrice *= testDiscount.getDiscountAmount();
        expectedTax *= testDiscount.getDiscountAmount();

        testPrice.updatePrice(testItem, 2);
        testPrice.updatePrice(testDiscount);

        boolean expResult = true;
        boolean resultTotal = testPrice.getTotalPrice() == expectedTotalPrice;
        boolean resultTax = testPrice.getTaxAmount() == expectedTax;
        boolean resultPrice = testPrice.getPriceWithoutTax() == expectedPrice;

        assertEquals(expResult, resultTax, "Tax gets calculated wrong.");
        assertEquals(expResult, resultPrice, "Price without tax gets calculated wrong.");
        assertEquals(expResult, resultTotal, "Total price gets calculated wrong.");
    }

    @Test
    void testUpdatePriceDiscountNull() {
        DiscountDTO testDiscount = null;

        boolean result = false;

        try{
            testPrice.updatePrice(testDiscount);
        } catch(NullPointerException e){
            result = true;
        }

        boolean expResult = true;

        assertEquals(expResult, result, "Null reference doesn't throw NullPointerException.");
    }
}