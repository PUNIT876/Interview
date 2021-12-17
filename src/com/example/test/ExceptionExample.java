package com.example.test;

public class ExceptionExample {
    public static void main(String[] args) {

        int a = 5;
        int b = 0;

        try{
            System.out.println("Hi in Try");
            int ans = a/b;
            System.out.println("Bye in Try");
        }catch (ArithmeticException ae){
            System.out.println("Hi in Arithmetic Exception");
            throw new RuntimeException("Throwing in Arithmetic Catch");
        }catch (Exception e){
            System.out.println("In Exception");
        }finally {
            System.out.println("Hi in Finally");
            throw new RuntimeException("Throwing in Finally");
        }
    }
}
