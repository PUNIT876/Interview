package com.example.test.ThreadExample;

public class NumberGenerator {

    private int number = 1;
    private int numberOfThreads = 3;
    private int totalNumbersToPrint = 10;

    public NumberGenerator(int numberOfThreads, int totalNumbersToPrint) {
        this.numberOfThreads = numberOfThreads;
        this.totalNumbersToPrint = totalNumbersToPrint;
    }

    public void printNumbers(int result){
        synchronized (this){
            while(number < totalNumbersToPrint){
                while(number % numberOfThreads != result){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number++);
                notifyAll();
            }
        }
    }



}
