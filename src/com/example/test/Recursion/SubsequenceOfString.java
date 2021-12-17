package com.example.test.Recursion;

public class SubsequenceOfString {

    public static void main(String[] args) {

        // Print all the subsequence of a String
        // abc -> "" , "a" , "b" , "c" , "ab" , "ac" , "bc" , "abc"

//        subsequence("abc");
        printSubsequence("abc" , "");
    }

    /*private static void subsequence(String input) {

        printSubsequence(input , "");
    }*/

    private static void printSubsequence(String input, String output) {

        if(input.length() == 0){
            System.out.println(output);
            return;
        }
        // Not Adding First Character of input string in output
        printSubsequence(input.substring(1) , output);

        //Adding First Character of input string in output
        printSubsequence(input.substring(1) , output+input.charAt(0));

    }
}
