package com.example.test.Recursion;

import java.util.Scanner;

public class MinCost {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter m : ");
        int m = s.nextInt();
        System.out.println("Enter n : ");
        int n = s.nextInt();
        int[][] path = new int[m][n];

        System.out.println("Enter " + m + " Rows and " + n + " Columns value : ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                path[i][j] = s.nextInt();
            }
        }

        int result = minCostPath(0, 0, path, m, n);
        System.out.printf("Minimum Cost Path : " + result);
    }

    private static int minCostPath(int i, int j, int[][] path, int m, int n) {

        if(i == m-1 && j == n-1) return path[i][j];

        if(i >= m || j >= n) return Integer.MAX_VALUE;

        int right =  minCostPath(i, j+1, path, m , n);
        int bottom = minCostPath(i+1, j, path, m, n);

        return path[i][j] + Math.min(right, bottom);
    }
}
