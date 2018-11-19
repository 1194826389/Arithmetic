package com.learn.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

import static com.learn.utils.Utils.*;
import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void reverseStringTest() {
        Assert.assertEquals("reverse string abcdefg", "fgedcba", Utils.reverseString("abcdegf"));
        Assert.assertEquals("reverse string abcdefg", "dfasdfa", Utils.reverseString("afdsafd"));
    }

    @Test
    public void reverseStackTest() {
        Stack<String> items = new Stack<String>();
        items.push("he");
        items.push("saw");
        items.push("saw1");
        items.push("saw2");
        items.push("saw3");


        reverseStack(items);

        Stack<String> exceptedItems = new Stack<String>();
        exceptedItems.push("saw3");
        exceptedItems.push("saw2");
        exceptedItems.push("saw1");
        exceptedItems.push("saw");
        exceptedItems.push("he");

        Assert.assertEquals(exceptedItems, items);
    }

    @Test
    public void findAllPrimeTest() {
        Assert.assertEquals("", Arrays.asList(2,3,5,7), findAllPrime(10));
        Assert.assertEquals("", Arrays.asList(2,3,5,7,11,13,17,19), findAllPrime(20));
        Assert.assertEquals("", Arrays.asList(2,3,5,7,11,13,17,19,23,29), findAllPrime(30));
    }

    @Test
    public void modTest() {
        int lengthMod = 1 << 4;

        Assert.assertEquals(50 % lengthMod, mod(50, lengthMod));
        Assert.assertEquals(165 % lengthMod, mod(165, lengthMod));
        Assert.assertEquals(1983 % lengthMod, mod(1983, lengthMod));

    }
}