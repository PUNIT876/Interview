package com.example.test.Recursion;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "ABCDE";
        String s2 = "ACE";
        int i = 0;
        int j = 0;
        int[][] dp = new int[s1.length()][s2.length()];
//        Arrays.fill(dp, -1);

        for (int[] row: dp)
            Arrays.fill(row, -1);

        int result = longestCommonSubsequence(i, j, s1, s2, dp );
        System.out.println(result);
    }

    private static int longestCommonSubsequence(int i, int j, String s1, String s2 , int[][] dp) {

        if (i >= s1.length() || j >= s2.length()) return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + longestCommonSubsequence(i + 1, j + 1, s1, s2, dp);
        } else {
            int left = longestCommonSubsequence(i + 1, j, s1, s2, dp);
            int right = longestCommonSubsequence(i, j + 1, s1, s2, dp);
            return dp[i][j] = Math.max(left, right);
        }
    }
}