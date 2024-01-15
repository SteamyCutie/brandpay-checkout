package io.brandpay;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CheckOutTest {

    @Test
    public void testTotalPriceWithoutSpecialPrice() {
        CheckOut co = createCheckOutWithPricingRules();

        co.scan("ABCD");
        int totalPrice = co.total();

        assertEquals(115, totalPrice);
    }

    private CheckOut createCheckOutWithPricingRules() {
        Map<Character, Integer> unitPrices = new HashMap<>();
        unitPrices.put('A', 50);
        unitPrices.put('B', 30);
        unitPrices.put('C', 20);
        unitPrices.put('D', 15);

        Map<Character, SpecialPrice> specialPrices = new HashMap<>();
        specialPrices.put('A', new SpecialPrice(3, 130));
        specialPrices.put('B', new SpecialPrice(2, 45));

        return new CheckOut(unitPrices, specialPrices);
    }
}
