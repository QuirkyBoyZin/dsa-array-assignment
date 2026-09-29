package com.cosc251.cpsolver;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        OrderedArray orderedArray= new OrderedArray(new Integer[]{1,2,3,4,5});
        System.out.println(Arrays.toString(orderedArray.getArr()));
        System.out.println(orderedArray.find(5));

    }
}
