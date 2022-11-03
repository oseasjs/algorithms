package com.study.algorithms.example;

import com.study.algorithms.examples.StringCases;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCasesTest {

    private final StringCases stringCases = new StringCases();

    @Test
    public void allDuplicationsForGivenValueSuccessful() {
        Assert.assertEquals("abc", stringCases.allDuplications("abcabcdbb"));
    }

    @Test
    public void allDuplicationsUsingFunctionForGivenValueSuccessful() {
        Assert.assertEquals("abc", stringCases.allDuplicationsUsingFunction("abcabcdbb"));
    }

    @Test
    public void nonDuplicationsForGivenValueSuccessful() {
        Assert.assertEquals("d", stringCases.nonDuplications("abcabcdbb"));
    }

    @Test
    public void nonDuplicationsUsingFunctionalForGivenValueSuccessful() {
        Assert.assertEquals("d", stringCases.nonDuplicationsUsingFunctional("abcabcdbb"));
    }

    @Test
    public void longestNonDuplicationsForGivenValueSuccessful() {
        Assert.assertEquals("abcd", stringCases.longestSubSetWithNoDuplication("abcabcdbb"));
        Assert.assertEquals("wke", stringCases.longestSubSetWithNoDuplication("pwwkew"));
    }

    @Test
    public void getFirstNonRepeatedCharacterSucessfull() {
        Assert.assertEquals("c", stringCases.firstNonRepeatingCharacter("aabcdbdd"));
    }

    @Test
    public void getFirstNonRepeatedCharacterOptimizedSucessfull() {
        Assert.assertEquals("c", stringCases.firstNonRepeatingCharacterOptmized("aabcdebdd"));
    }

    @Test
    public void getFirstNonRepeatedCharacterOptimizedFunctionalSucessfull() {
        Assert.assertEquals("c", stringCases.firstNonRepeatingCharacterOptmizedUsingFunctional("aabcdebdd"));
    }

    @Test
    public void sortUsingArraysSucessfull() {
        Assert.assertEquals("abcd", stringCases.sortUsingArrays("bdac"));
    }

    @Test
    public void sortReverseUsingArraysAndFunctionalSucessfull() {
        Assert.assertEquals("dcba", stringCases.sortReverseUsingArraysAndFunctional("bdac"));
    }

    @Test
    public void splitStringInFiveEqualsPartsSucessfull() {
        String[] values = stringCases.splitStringInEqualsParts("abcdefghijklmnopqrstuvwxy", 5, false);
        Assert.assertEquals(5, values.length);
        Assert.assertEquals(5, values[0].length());
        Assert.assertEquals(5, values[1].length());
        Assert.assertEquals(5, values[2].length());
        Assert.assertEquals(5, values[3].length());
        Assert.assertEquals(5, values[4].length());
        Assert.assertEquals("abcde", values[0]);
        Assert.assertEquals("fghij", values[1]);
        Assert.assertEquals("klmno", values[2]);
        Assert.assertEquals("pqrst", values[3]);
        Assert.assertEquals("uvwxy", values[4]);
    }

    @Test
    public void splitStringInThreeEqualsPartsSucessfull() {
        String[] values = stringCases.splitStringInEqualsParts("abcfdefghijkl", 3, false);
        Assert.assertEquals(4, values.length);
        Assert.assertEquals(4, values[0].length());
        Assert.assertEquals(4, values[1].length());
        Assert.assertEquals(4, values[2].length());
        Assert.assertEquals(1, values[3].length());
        Assert.assertEquals("abcf", values[0]);
        Assert.assertEquals("defg", values[1]);
        Assert.assertEquals("hijk", values[2]);
        Assert.assertEquals("l", values[3]);
    }

    @Test
    public void splitStringInTwoEqualsPartsSucessfull() {
        String[] values = stringCases.splitStringInEqualsParts("abcfdefghi", 2, false);
        Assert.assertEquals(2, values.length);
        Assert.assertEquals(5, values[0].length());
        Assert.assertEquals(5, values[1].length());
        Assert.assertEquals("abcfd", values[0]);
        Assert.assertEquals("efghi", values[1]);
    }

    @Test
    public void splitStringInFiveEqualsPartsInvertedSucessfull() {
        String[] values = stringCases.splitStringInEqualsParts("abcdefghijklmnopqrstuvwxy", 5, true);
        Assert.assertEquals(5, values.length);
        Assert.assertEquals(5, values[0].length());
        Assert.assertEquals(5, values[1].length());
        Assert.assertEquals(5, values[2].length());
        Assert.assertEquals(5, values[3].length());
        Assert.assertEquals(5, values[4].length());
        Assert.assertEquals("yxwvu", values[0]);
        Assert.assertEquals("tsrqp", values[1]);
        Assert.assertEquals("onmlk", values[2]);
        Assert.assertEquals("jihgf", values[3]);
        Assert.assertEquals("edcba", values[4]);
    }

    @Test
    public void splitStringInThreeEqualsPartsInvertedSucessfull() {
        String[] values = stringCases.splitStringInEqualsParts("abcfdefghijkl", 3, true);
        Assert.assertEquals(4, values.length);
        Assert.assertEquals(4, values[0].length());
        Assert.assertEquals(4, values[1].length());
        Assert.assertEquals(4, values[2].length());
        Assert.assertEquals(1, values[3].length());
        Assert.assertEquals("lkji", values[0]);
        Assert.assertEquals("hgfe", values[1]);
        Assert.assertEquals("dfcb", values[2]);
        Assert.assertEquals("a", values[3]);
    }

    @Test
    public void splitStringInTwoEqualsPartsInvertedSucessfull() {
        String[] values = stringCases.splitStringInEqualsParts("abcfdefghi", 2, true);
        Assert.assertEquals(2, values.length);
        Assert.assertEquals(5, values[0].length());
        Assert.assertEquals(5, values[1].length());
        Assert.assertEquals("ihgfe", values[0]);
        Assert.assertEquals("dfcba", values[1]);
    }

    @Test
    public void reductionReplaceABCSucessfull() {

        Assert.assertEquals("bb", stringCases.reductionReplacingABC("cab"));
        Assert.assertEquals("b", stringCases.reductionReplacingABC("bcab"));
        Assert.assertEquals("ccccc", stringCases.reductionReplacingABC("ccccc"));

    }

    @Test
    public void reductionReplaceABCOptimizedSucessfull() {

        Assert.assertEquals("bb", stringCases.reductionReplacingABCOptimized("cab"));
        Assert.assertEquals("b", stringCases.reductionReplacingABCOptimized("bcab"));
        Assert.assertEquals("ccccc", stringCases.reductionReplacingABCOptimized("ccccc"));

    }

    @Test
    public void fibonacciSucessfull() {

        Assert.assertEquals("1;2;3", stringCases.fibonacci(3));
        Assert.assertEquals("1;2;3;5;8;13", stringCases.fibonacci(6));
        Assert.assertEquals("1;2;3;5;8;13;21;34;55", stringCases.fibonacci(9));

    }

    @Test
    public void fibonacciOptimizedSucessfull() {

        Assert.assertEquals("1;2;3", stringCases.fibonacciOptimized(3));
        Assert.assertEquals("1;2;3;5;8;13", stringCases.fibonacciOptimized(6));
        Assert.assertEquals("1;2;3;5;8;13;21;34;55", stringCases.fibonacciOptimized(9));

    }

    @Test
    public void frequencyOfEachCharacterSuccessful() {
        String value = "mytest";

        Map<String, Long> expected = Stream.of(new Object[][]{
            {"m", 1l},
            {"y", 1l},
            {"t", 2l},
            {"e", 1l},
            {"s", 1l},
        }).collect(
            Collectors.toMap(
                data -> (String) data[0], data -> (Long) data[1]
            )
        );

        Assert.assertEquals(expected, stringCases.frequenceOfEachCharacter(value));
    }

}
