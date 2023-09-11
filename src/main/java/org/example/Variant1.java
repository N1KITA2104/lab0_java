package org.example;

import java.util.Arrays;

public class Variant1 {
    public int inMeter(int l) {
        return l / 100;
    }

    public boolean isPositiveNumber(int number) {
        return number > 0;
    }

    public int modifyNumber(int number) {
        if (number > 0) {
            number += 1;
        }
        return number;
    }

    public String getDayOfWeek(int dayNumber) {
        return switch (dayNumber) {
            case 1 -> "понеділок";
            case 2 -> "вівторок";
            case 3 -> "середа";
            case 4 -> "четвер";
            case 5 -> "п'ятниця";
            case 6 -> "субота";
            case 7 -> "неділя";
            default -> "невідомий день";
        };
    }

    public int[] createNumberArray(int K, int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N має бути більше нуля");
        }

        int[] result = new int[N];
        Arrays.fill(result, K);

        return result;
    }

    public int findRemainingLength(int a, int b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Як A, так і B повинні бути позитивними числами.");
        }

        while (a >= b) {
            a -= b;
        }

        return a;
    }

    public int[] generateOddNumbers(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N повинно бути більше 0");
        }

        int[] oddNumbers = new int[N];
        oddNumbers[0] = 1;

        for (int i = 1; i < N; i++) {
            oddNumbers[i] = oddNumbers[i - 1] + 2;
        }

        return oddNumbers;
    }

    public int[][] createMatrix(int M, int N) {
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = 10 * (i + 1); // Елементи I-го рядку мають значення 10*I
            }
        }
        return matrix;
    }

    public int[] findMinMax(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return new int[]{};
        }

        int min = numbers[0];
        int max = numbers[0];

        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }
        return new int[]{min, max};
    }
}
