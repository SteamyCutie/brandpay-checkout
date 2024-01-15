package io.brandpay;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Map<Character, Integer> unitPrices = new HashMap<>();
        unitPrices.put('A', 50);
        unitPrices.put('B', 30);
        unitPrices.put('C', 20);
        unitPrices.put('D', 15);

        Map<Character, SpecialPrice> specialPrices = new HashMap<>();
        specialPrices.put('A', new SpecialPrice(3, 130));
        specialPrices.put('B', new SpecialPrice(2, 45));

        CheckOut co = new CheckOut(unitPrices, specialPrices);
        co.scan('A');
        co.scan('B');
        co.scan('A');

        int price = co.total();
        System.out.println("Total price: " + price);
    }
}