package com.example.test;

import java.util.Scanner;


public class RecurssionExample {

    static int first = 0 , second = 1 , sum = 0 ;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(fact(n));

        if(n > 2){
            System.out.print(first + " " + second + " ");
            fibo(n-2);
        }

        int result = fib(n);
        System.out.println(result);

    }
    private static int fib(int n) {

        if(n == 0) return 0;
        if(n == 1) return 1;

        return fib(n-1) + fib(n-2);
    }


    private static void fibo(int n) {
        // 0 , 1 , 1 , 2 , 3 , 5 , 8

        /*if(n == 1)
            System.out.print(first);
        if(n == 2)
            System.out.print(first + " " + second);*/

        if(n > 2){
            sum = first + second;
            first = second;
            second = sum;
            System.out.print(sum + " ");
            fibo(n-1);
        }
        System.out.println(" ");
        // Sub-Problem  -->


    }

    private static int fact(int n) {
        // 5! = 5 * 4 * 3 * 2 * 1 ;

        // Base Case -> 0 = 1 , 1 = 1
        if(n == 0 || n ==1)
            return 1;

        // Sub-Problem  5! = 4! * 5  --> n! = (n-1)! * n  --> f(n) = f(n-1) * n
        return fact(n-1) * n;
    }
}
