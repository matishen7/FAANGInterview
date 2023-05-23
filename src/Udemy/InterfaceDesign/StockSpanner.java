package Udemy.InterfaceDesign;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanner {
    List<Integer> prices;

    public StockSpanner() {
        prices = new ArrayList<>();
    }

    public int next(int price) {
        prices.add(price);
        int count = 0;
        for (int i = 0; i < prices.size(); i++)
            if (price > prices.get(i)) count++;
        for (int i = 0; i < prices.size(); i++)
            if (price >= prices.get(i)) count++;
        return count;
    }
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // return 1
        System.out.println(stockSpanner.next(80));  // return 1
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(70));  // return 2
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(75));  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
        System.out.println(stockSpanner.next(85));  // return 6
    }
}


