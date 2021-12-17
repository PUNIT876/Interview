package com.example.test.Recursion;

import java.util.Scanner;

public class MinTradeDay {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Initial Price of the Stock");
        int n = s.nextInt();
        System.out.println("Final Price");
        int m = s.nextInt();

        int result = minDay(n,m);
        System.out.println(result);
    }

    private static int minDay(int n, int m) {

        if(n == m) return 0;

        int reduce = 1 + minDay(n-1, m);
        int increase = 1 + minDay(n*2, m);

        return Math.min(reduce,increase);
    }
}
