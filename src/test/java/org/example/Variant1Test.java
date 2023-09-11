package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class Variant1Test {
    @Test(dataProvider = "meterData")
    public void meterTest(int L, int expected) {
        int actual = new Variant1().inMeter(L);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] meterData() {
        return new Object[][] {
                {90, 0}, // 1 метр
                {350, 3}, // 3 метра
                {1000, 10}, // 10 метрів
                {1550, 15}, // 15 метрів
                {100000, 1000} // 1000 метрів
        };
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negMeterTest() {
        new Variant1().inMeter(-100);
    }

    @Test(dataProvider = "positiveNumberData")
    public void testIsPositiveNumber(int number, boolean expected) {
        boolean actual = new Variant1().isPositiveNumber(number);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] positiveNumberData() {
        return new Object[][] {
                { 5, true },    // Позитивне число
                { 0, false },   // Нуль не вважається позитивним
                { -5, false },  // Від'ємне число
                { 100, true },  // Позитивне число
                { -100, false } // Від'ємне число
        };
    }

    @Test(dataProvider = "modifyNumberData")
    public void testModifyNumber(int input, int expected) {
        int actual = new Variant1().modifyNumber(input);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] modifyNumberData() {
        return new Object[][] {
                { 5, 6 },     // Позитивне число
                { -5, -5 },   // Від'ємне число
                { 0, 0 },     // Нуль не повинен змінюватися
                { 100, 101 }, // Позитивне число
                { -100, -100 } // Від'ємне число
        };
    }

    @Test(dataProvider = "dayOfWeekData")
    public void testGetDayOfWeek(int dayNumber, String expected) {
        String actual = new Variant1().getDayOfWeek(dayNumber);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] dayOfWeekData() {
        return new Object[][] {
                { 1, "понеділок" },
                { 2, "вівторок" },
                { 3, "середа" },
                { 4, "четвер" },
                { 5, "п'ятниця" },
                { 6, "субота" },
                { 7, "неділя" },
                { 0, "невідомий день" }, // Тест на невірний вхідний параметр
                { 8, "невідомий день" }  // Тест на невірний вхідний параметр
        };
    }

    ///////
    @Test(dataProvider = "numberArrayData")
    public void testCreateNumberArray(int K, int N, int[] expected) {
        int[] actual = new Variant1().createNumberArray(K, N);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] numberArrayData() {
        return new Object[][] {
                { 2, 5, new int[]{2, 2, 2, 2, 2} },    // П'ять чисел, всі рівні 2
                { 0, 3, new int[]{0, 0, 0} },         // Три числа, всі рівні 0
                { -1, 4, new int[]{-1, -1, -1, -1} }, // Чотири числа, всі рівні -1
                { 10, 1, new int[]{10} },             // Одне число, рівне 10
        };
    }


    @Test(dataProvider = "remainingLengthData")
    public void testFindRemainingLength(int A, int B, int expected) {
        int actual = new Variant1().findRemainingLength(A, B);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] remainingLengthData() {
        return new Object[][] {
                { 15, 4, 3 },  // A = 15, B = 4, залишок = 3
                { 10, 3, 1 },  // A = 10, B = 3, залишок = 1
                { 7, 2, 1 },   // A = 7, B = 2, залишок = 1
                { 8, 5, 3 },   // A = 8, B = 5, залишок = 3
                { 20, 7, 6 },  // A = 20, B = 7, залишок = 6
                { 100, 25, 0 },// A = 100, B = 25, залишок = 0
                { 1, 1, 0 },   // A = 1, B = 1, залишок = 0
        };
    }

    @Test(dataProvider = "oddNumbersData")
    public void testGenerateOddNumbers(int N, int[] expected) {
        int[] actual = new Variant1().generateOddNumbers(N);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] oddNumbersData() {
        return new Object[][] {
                { 7, new int[]{1, 3, 5, 7, 9, 11, 13} }, // Перші 7 непарних чисел
                { 5, new int[]{1, 3, 5, 7, 9} },  // Перші 5 непарних чисел
                { 3, new int[]{1, 3, 5} },        // Перші 3 непарних числа
                { 1, new int[]{1} },              // Перше непарне число
        };
    }

    @Test(dataProvider = "matrixData")
    public void testCreateMatrix(int M, int N, int[][] expectedMatrix) {
        int[][] actualMatrix = new Variant1().createMatrix(M, N);
        assertEquals(expectedMatrix, actualMatrix);
    }

    @DataProvider
    public Object[][] matrixData() {
        return new Object[][] {
                {3, 3, new int[][]{{10, 10, 10}, {20, 20, 20}, {30, 30, 30}}}, // Матриця 3x3
                {2, 4, new int[][]{{10, 10, 10, 10}, {20, 20, 20, 20}}}, // Матриця 2x4
                {4, 2, new int[][]{{10, 10}, {20, 20}, {30, 30}, {40, 40}}}, // Матриця 4x2
        };
    }

    @Test(dataProvider = "minMaxData")
    public void testFindMinMax(int[] numbers, int[] expected) {
        int[] actual = new Variant1().findMinMax(numbers);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] minMaxData() {
        return new Object[][] {
                { new int[]{1, 3, 5, 7, 9, 11, 13}, new int[]{1, 13} }, // Мінімальне та максимальне
                { new int[]{1, 3, 5, 7, 9}, new int[]{1, 9} },
                { new int[]{5, 8, 2, 12, 6}, new int[]{2, 12} },
                { new int[]{42}, new int[]{42, 42} },
        };
    }
}