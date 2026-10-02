package com.cosc251.cpsolver;

import com.cosc251.cpsolver.model.OrderedArray;
import com.cosc251.cpsolver.model.UnorderedArray;

public class Main {
    public static void main(String[] args) {
        OrderedArray  orderedArray     = new OrderedArray(10);
        UnorderedArray unorderedArray  = new UnorderedArray(10);


        orderedArray.insert(5);
        orderedArray.insert(4);
        orderedArray.insert(3);
        orderedArray.insert(2);
        orderedArray.insert(2);
        orderedArray.insert(2);
        orderedArray.insert(2);




        System.out.println(orderedArray);



//
//        unorderedArray.insert(1);
//        unorderedArray.insert(2);
//        unorderedArray.insert(4);
//        unorderedArray.insert(5);
//
//        System.out.println(unorderedArray);

    }
}
