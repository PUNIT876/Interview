package com.punit;

import java.util.ArrayList;
import java.util.List;

public class Test{
    public static void main(String[] args) {
        //456 --> 15 --> 6
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(7);
        list.add(9);
        list.add(3);

        System.out.println(minValue(list));
    }

    private static int minValue(List<Integer> list) {
        int min = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if(list.get(i) < min){
                min = list.get(i);
            }
        }
        return min;
    }
}