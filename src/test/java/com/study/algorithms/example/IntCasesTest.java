package com.study.algorithms.example;

import com.study.algorithms.examples.IntCases;
import org.junit.Assert;
import org.junit.Test;

public class IntCasesTest {

    private IntCases intCases = new IntCases();

    @Test
    public void checkMissingNumbersCount5Successful() {
        Assert.assertArrayEquals(new int[] {0, 3, 4},
                intCases.missingNumbers(new int[] {1, 2, 5}, 5));
    }

    @Test
    public void checkMissingNumbersCount5UsingFunctionalSuccessful() {
        Assert.assertArrayEquals(new int[] {0, 3, 4},
                intCases.missingNumbersUsingFunctional(new int[] {1, 2, 5}, 5));
    }

    @Test
    public void checkMissingNumbersCount10Successful() {
        Assert.assertArrayEquals(new int[] {0, 4, 5, 6},
                intCases.missingNumbers(new int[] {1, 2, 3, 7, 8, 9, 10}, 10));
    }

    @Test
    public void checkMissingNumbersCount10UsingFunctionalSuccessful() {
        Assert.assertArrayEquals(new int[] {0, 4, 5, 6},
                intCases.missingNumbersUsingFunctional(new int[] {1, 2, 3, 7, 8, 9, 10}, 10));
    }

    @Test
    public void duplicatedNumbersSuccessful() {
        Assert.assertArrayEquals(new int[] {1, 5},
                intCases.duplicateNumber(new int[] {1, 2, 3, 4, 1, 5, 6, 7, 8, 9, 5}));
    }

    @Test
    public void duplicatedNumbersUsingFunctionalSuccessful() {
        Assert.assertArrayEquals(new int[] {1, 5},
                intCases.duplicateNumberUsingFunctional(new int[] {1, 2, 3, 4, 1, 5, 6, 7, 8, 9, 5}));
    }

    @Test
    public void smallestAndLargestNumbersSuccessful() {
        Assert.assertArrayEquals(new int[] {2, 9},
                intCases.smallestAndLargestNumber(new int[] {3, 4, 2, 8, 6, 9, 7}));
    }

    @Test
    public void smallestAndLargestNumbersUsingFunctionalSuccessful() {
        Assert.assertArrayEquals(new int[] {2, 9},
                intCases.smallestAndLargestNumberUsingFunctional(new int[] {3, 4, 2, 8, 6, 9, 7}));
    }

    @Test
    public void getPairsOfIntsHavingSumEqualsTotalSuccessful() {
        int[][] pairs = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{1, 4}};
        int[][] expected = new int[][]{new int[]{2, 3}, new int[]{1, 4}};

        Assert.assertArrayEquals(expected, intCases.pairOfIntArrayHavingSumEqualsToTotal(pairs, 5));
    }

    @Test
    public void getPairsOfIntsHavingSumEqualsTotalUsingFunctionalSuccessful() {

        int[][] pairs = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{1, 4}};
        int[][] expected = new int[][]{new int[]{2, 3}, new int[]{1, 4}};

        Assert.assertArrayEquals(expected, intCases.pairOfIntArrayHavingSumEqualsToUsingFunctional(pairs, 5));
    }

    @Test
    public void removeDuplicatedSuccessful() {
        Assert.assertArrayEquals(new int[] {1, 2, 3, 4, 5},
                intCases.removeDuplicatesOrdered(new int[]{3, 5, 2, 1, 2, 1, 3, 2, 5, 4, 5, 4, 4}));
    }

    @Test
    public void removeDuplicatedUsingFunctionalSuccessful() {
        Assert.assertArrayEquals(new int[] {1, 2, 3, 4, 5},
                intCases.removeDuplicatesOrderedUsingFunctional(new int[]{3, 5, 2, 1, 2, 1, 3, 2, 5, 4, 5, 4, 4}));
    }

}
