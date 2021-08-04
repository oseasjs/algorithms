package com.study.algorithms.examples;

import java.util.*;
import java.util.stream.Collectors;

public class IntegerCases {

    public int[] missingNumbers(int[] values, int count) {
        String missingValues = "";
        for (int i = 0; i <= count; i++) {
            boolean found = false;
            for (int v : values) {
                if (v == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                missingValues += i + ";";
            }
        }

        return Arrays
                .stream(missingValues.split(";"))
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    public int[] missingNumbersUsingFunctional(int[] values, int count) {

        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i <= count; i ++) intList.add(i);
        return intList
            .stream()
            .filter(i -> !Arrays.stream(values).anyMatch(j -> i == j))
            .mapToInt(Integer::intValue)
            .toArray();

    }

    public int[] duplicateNumber(int[] values) {

        String duplicatedValues = "";
        String allValues = "";

        for (int value: values) {
            if (allValues.contains(String.valueOf(value))) {
                duplicatedValues += value + ";";
            }
            allValues += value + ";";
        }

        return Arrays
                .stream(duplicatedValues.split(";"))
                .mapToInt(Integer::valueOf)
                .toArray();

    }

    public int[] duplicateNumberUsingFunctional(int[] values) {
        return Arrays
            .stream(values)
            .filter(i -> Arrays.stream(values).filter(j -> j == i).count() > 1)
            .mapToObj(Integer::valueOf)
            .collect(Collectors.toSet())
            .stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }

    public int[] smallestAndLargestNumber(int[] values) {

        int smallest = 0;
        int largest = 0;

        for (int value: values) {
            if (value < smallest || smallest == 0) {
                smallest = value;
            }
            if (value > largest || largest == 0) {
                largest = value;
            }
        }

        return new int[] {smallest, largest};

    }

    public int[] smallestAndLargestNumberUsingFunctional(int[] values) {
        return new int[] { Arrays.stream(values).min().getAsInt(), Arrays.stream(values).max().getAsInt()};
    }

    public int[][] pairOfIntArrayHavingSumEqualsToTotal(int[][] values, int total) {

        List<int[]> valuesList = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            if (values[i][0] + values[i][1] == total) {
                valuesList.add(values[i]);
            }
        }

        int[][] valuesArray = new int[valuesList.size()][2];
        for (int i = 0; i < valuesList.size(); i++) {
            valuesArray[i] = valuesList.get(i);
        }

        return valuesArray;

    }

    public int[][] pairOfIntArrayHavingSumEqualsToUsingFunctional(int[][] values, int total) {
         return Arrays
            .stream(values)
            .filter(v -> v[0] + v[1] == total)
            .collect(Collectors.toList())
            .stream()
            .toArray(size -> new int[size][2]);
    }

    public int[] removeDuplicatesOrdered(int[] values) {

        Set<Integer> valuesSet = new HashSet<>();
        for (int value : values) {
            valuesSet.add(value);
        }
        int[] valuesArray = valuesSet.stream().mapToInt(v -> v.intValue()).toArray();
        Arrays.sort(valuesArray);
        return valuesArray;

    }

    public int[] removeDuplicatesOrderedUsingFunctional(int[] values) {

        return Arrays
            .stream(values)
            .mapToObj(String::valueOf)
            .collect(Collectors.toSet())
            .stream()
            .mapToInt(Integer::valueOf)
            .sorted()
            .toArray();

    }

}
