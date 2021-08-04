package com.study.algorithms.examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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

    public String stringReduction(String value) {


        return null;
    }

}
