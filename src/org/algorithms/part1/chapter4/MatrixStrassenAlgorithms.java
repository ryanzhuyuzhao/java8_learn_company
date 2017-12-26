package org.algorithms.part1.chapter4;

import java.util.Arrays;

public class MatrixStrassenAlgorithms {
    public static void main(String[] args) {
        int[][] a = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
        int[][] b = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
        int[][] c = squareMatrixMultiply(a, b);
        for (int i = 0;i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                System.out.print(c[i][j] + "\t");
            }
            System.out.println();
        }
//        Arrays.stream(c).forEach(s -> Arrays.stream(s).forEach(ss -> System.out.println(ss)));
    }

    public static int[][] squareMatrixMultiply(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    c[i][j] = c[i][j] + a[i][k]*b[k][j];
                }
            }
        }
        return c;
    }
}
