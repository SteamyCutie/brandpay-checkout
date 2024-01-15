package io.brandpay;

import java.util.HashMap;
import java.util.Map;

public class CheckOut {
    private Map<Character, Integer> unitPrices = new HashMap<>();
    private Map<Character, SpecialPrice> specialPrices = new HashMap<>();
    private Map<Character, Integer> itemCounts = new HashMap<>();

    public CheckOut(Map<Character, Integer> unitPrices, Map<Character, SpecialPrice> specialPrices) {
        this.unitPrices = unitPrices;
        this.specialPrices = specialPrices;
    }

    public void scan(String items) {
        for (char item: items.toCharArray()) {
            itemCounts.put(item, itemCounts.getOrDefault(item, 0) + 1);
        }
    }

    public void empty() {
        itemCounts.clear();
        System.out.println("Cart Cleared.");
    }

    public int total() {
        int totalPrice = 0;
        for (Map.Entry<Character, Integer> entry: itemCounts.entrySet()) {
            char item = entry.getKey();
            int count = entry.getValue();
            if (specialPrices.containsKey(item) && count >= specialPrices.get(item).quantity) {
                int specialPrice = specialPrices.get(item).price;
                int specialQuantity = specialPrices.get(item).quantity;
                totalPrice += (count / specialQuantity) * specialPrice + (count % specialQuantity) * unitPrices.get(item);
            } else {
                totalPrice += count * unitPrices.get(item);
            }
        }
        return totalPrice;
    }
}
