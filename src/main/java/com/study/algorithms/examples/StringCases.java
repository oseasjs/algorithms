package com.study.algorithms.examples;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// Inspired on:
// https://medium.com/javarevisited/20-array-coding-problems-and-questions-from-programming-interviews-869b475b9121
// https://www.youtube.com/watch?v=5co5Gvp_-S0

public class StringCases {

    public String allDuplications(final String value) {

        String duplication = "";
        String all = "";

        for (int i = 0; i < value.toCharArray().length; i++) {
            String _char = "" + value.charAt(i);
            if (all.contains(_char) && !duplication.contains(_char)) {
                duplication += _char;
            }
            all += _char;

        }

        return duplication;

    }

    public String allDuplicationsUsingFunction(final String values) {
        return values
                .chars()
                .mapToObj(v -> (char)v)
                .map(String::valueOf)
                .filter(v -> values.indexOf(v) != values.lastIndexOf(v))
                .collect(Collectors.toSet())
                .stream()
                .collect(Collectors.joining());
    }

    public String nonDuplications(final String values) {

        String nonDuplication = "";
        String all = "";

        for (int i = 0; i < values.toCharArray().length; i++) {
            String _char = "" + values.charAt(i);
            if (!all.contains(_char)) {
                nonDuplication += _char;
            }
            else {
                nonDuplication = nonDuplication.replaceAll(_char, "");
            }
            all += _char;
        }

        return nonDuplication;

    }

    public String nonDuplicationsUsingFunctional(final String values) {
        return values
                .chars()
                .mapToObj(v -> (char) v)
                .map(String::valueOf)
                .filter(v -> values.indexOf(v) == values.lastIndexOf(v))
                .collect(Collectors.joining());

    }

    public String longestSubSetWithNoDuplication(final String values) {

        String nonDuplication = "";
        String longestSubSet = "";

        for (int i = 0; i < values.length(); i++) {
            String value = "" + values.charAt(i);
            if (!nonDuplication.contains(value)) {
                nonDuplication += value;
            }
            else {
                if (longestSubSet.length() < nonDuplication.length()) {
                    longestSubSet = nonDuplication;
                }
                nonDuplication = value;
            }
        }

        return longestSubSet;

    }

    public String firstNonRepeatingCharacter(final String values) {

        String nonRepeatedValue = "";
        for (int i = 0; i < values.length(); i++) {
            final String value = String.valueOf(values.charAt(i));
            if (nonRepeatedValue.contains(value)) {
                nonRepeatedValue = nonRepeatedValue.replaceAll(value, "");
            }
            else  {
                nonRepeatedValue += value;
            }
        }
        return nonRepeatedValue.length() > 0 ? String.valueOf(nonRepeatedValue.charAt(0)) : "";

    }

    public String firstNonRepeatingCharacterOptmized(final String values) {

        for (int i = 0; i < values.length(); i++) {
            if (values.indexOf(values.charAt(i)) == values.lastIndexOf(values.charAt(i))) {
                return String.valueOf(values.charAt(i));
            }
        }
        return "";

    }

    public String firstNonRepeatingCharacterOptmizedUsingFunctional(final String values) {

        return values
                .chars()
                .mapToObj(v -> (char) v)
                .map(String::valueOf)
                .filter(v -> values.indexOf(v) == values.lastIndexOf(v))
                .findFirst()
                .orElse("");

    }

    public String sortUsingArrays(final String values) {

        char[] chars = values.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);

    }

    public String sortReverseUsingArraysAndFunctional(final String values) {

        String[] chars = values
                .chars()
                .mapToObj(v -> (char) v)
                .map(String::valueOf)
                .toArray(size -> new String[size]);
        Arrays.sort(chars, Comparator.reverseOrder());
        return Arrays.stream(chars).collect(Collectors.joining());

    }

    public String[] splitStringInEqualsParts(final String value, final int parts, final boolean inverted) {

        List<String> valueOrdered = Arrays.stream(value.split("")).collect(Collectors.toList());
        if (inverted) {
            Collections.reverse(valueOrdered);
        }

        String valueToProcess = valueOrdered.stream().collect(Collectors.joining());

        int partsLength = valueToProcess.length() / parts;

        String valuesAsString = "";
        for (int i = 0; i < valueToProcess.length(); i++) {

            String val = valueToProcess.substring(i, i+1);
            String[] values = valuesAsString.split(";");

            if (values[values.length -1].length() < partsLength) {
                valuesAsString += val;
            }
            else {
                valuesAsString += ";" + val;
            }

        }

        return valuesAsString.split(";");

    }

    public String reductionReplacingABC(String value) {

        String abc = "abc";

        if (value.length() >= 2) {

            String lastVal = null;
            String finalValue = "";
            for (int i = 0; i < value.length(); i++) {

                String currentVal = value.substring(i, i+1);
                finalValue += currentVal;
                if (lastVal == null) {
                    lastVal = currentVal;
                }
                else {

                    if (!lastVal.equalsIgnoreCase(currentVal)) {

                        String missingVal = abc
                                .replaceAll(lastVal, "")
                                .replaceAll(currentVal, "");

                        finalValue = value.replaceFirst(lastVal.concat(currentVal), missingVal);
                        break;

                    }

                }

            }

            if (finalValue.equalsIgnoreCase(value)) {
                return finalValue;
            }
            else {
                return reductionReplacingABC(finalValue);
            }

        }
        else {
            return value;
        }

    }

    public String reductionReplacingABCOptimized(String value) {

        String abc = "abc";

        String nonDuplicatedVal = value
            .chars()
            .mapToObj(v -> (char) v)
            .map(String::valueOf)
            .filter(v -> v.lastIndexOf(v) == v.indexOf(v))
            .collect(Collectors.joining());

        if (nonDuplicatedVal.length() == 1) {
            return value;
        }
        else {

            String firstChar = nonDuplicatedVal.substring(0, 1);
            String secondChar = nonDuplicatedVal.substring(1, 2);

            String missingVal = abc.replaceAll(firstChar, "").replaceAll(secondChar, "");

            return missingVal.length() > 1 ?
                value :
                reductionReplacingABC(value.replaceFirst(firstChar.concat(secondChar),missingVal));

        }

    }

    public String fibonacci(int iteractions) {

        List<Integer> list = new ArrayList<>();
        int valueA = 1;
        int valueB = 0;

        for (int i = 0; i < iteractions; i++) {

            int currentVal = valueA + valueB;
            list.add(currentVal);
            valueB = valueA;
            valueA = currentVal;

        }

        return list
            .stream()
            .map(String::valueOf)
            .collect(Collectors.joining(";"));

    }

    public String fibonacciOptimized(int iteractions) {

        Integer[] values = new Integer[iteractions];
        int valueA = 1;
        int valueB = 0;
        for (int i = 0; i < values.length; i++) {
            values[i] = valueA + valueB;
            valueB = valueA;
            valueA = values[i];
        }

        return Arrays.stream(values).map(String::valueOf).collect(Collectors.joining(";"));

    }

    public Map<String, Long> frequenceOfEachCharacter(String value) {

        return Arrays.stream(value.split(""))
            .collect(
                Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()
                )
            );
    }

}
