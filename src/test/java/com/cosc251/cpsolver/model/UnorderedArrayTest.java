package com.cosc251.cpsolver.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UnorderedArrayTest {

    // ====== Insert ======
    @Test
    void givenElement_whenInsert_thenAppendToTheArray() {
        final int NUM = 1;
        Integer[] testingData = new Integer[2];

        UnorderedArray unorderedArray = new UnorderedArray(testingData.clone());
        unorderedArray.insert(NUM);

        Integer[] expected = new Integer[]{1,null};
        Integer[] actual = unorderedArray.getArr();

        assertArrayEquals(expected,actual, "Inserting " + NUM + " to " + Arrays.toString(testingData) + " Should return " + Arrays.toString(expected));

    }

    @Test
    void givenElementToAFullArray_whenInsert_thenResizeArrayToAddNewElement() {
        final int NUM = 8;
        Integer[] testingData = new Integer[]{5,4,1,2,5};

        UnorderedArray unorderedArray = new UnorderedArray(testingData.clone());
        unorderedArray.insert(NUM);

        Integer[] expected = new Integer[]{5,4,1,2,5,8,null,null,null,null};
        Integer[] actual = unorderedArray.getArr();

        assertArrayEquals(expected,actual, "Inserting " + NUM + " to " + Arrays.toString(testingData) + " Should return " + Arrays.toString(expected));
    }

    // ====== Delete ======
    @Test
    void givenNonExistingNumberInArray_whenDelete_thenReturnFalse() {
        final int NUM = 6;
        Integer[] testingData = new Integer[]{1, 2, 3, 4, 5};

        UnorderedArray unOrderedArray = new UnorderedArray(testingData.clone());

        assertFalse(unOrderedArray.delete(NUM), "Deleting " + NUM + " from " + Arrays.toString(testingData) + "Should return False");
    }

    @Test
    void givenExistingNumberInArray_whenDelete_thenReturnTrue() {
        final int NUM= 5;
        Integer[] testingData = new Integer[]{1,2,3,4,5};

        UnorderedArray unOrderedArray = new UnorderedArray(testingData.clone());

        assertTrue(unOrderedArray.delete(NUM), "Deleting " + NUM + " from " + Arrays.toString(testingData) + "Should return True");
    }

    @Test
    void givenExistingNumberInArray_whenDelete_thenEmptySpotWillBeFillWithNull() {
        final int NUM= 5;
        Integer[] testingData = new Integer[]{1,2,3,4,5};

        UnorderedArray unOrderedArray = new UnorderedArray(testingData.clone());
        unOrderedArray.delete(NUM);

        Integer[] expected = new Integer[]{1,2,3,4, null};
        Integer[] actual   = unOrderedArray.getArr();

        assertEquals(Arrays.toString(expected), Arrays.toString(actual), "Deleting " + NUM + " from " + Arrays.toString(testingData) + "Should return " + Arrays.toString(expected) ) ;
    }

    @Test
    void givenNumberInMiddleArray_whenDelete_thenArrayMustShiftToTheLeft() {
        final int NUM= 3;
        Integer[] testingData = new Integer[]{1,2,3,4,5};

        UnorderedArray unOrderedArray = new UnorderedArray(testingData.clone());
        unOrderedArray.delete(NUM);

        Integer[] expected = new Integer[]{1,2,4,5, null};
        Integer[] actual   = unOrderedArray.getArr();

        assertEquals(Arrays.toString(expected), Arrays.toString(actual), "Deleting " + NUM + " from " + Arrays.toString(testingData) + "Should return " + Arrays.toString(expected) ) ;
    }

    // ====== Find ======
    @Test
    void givenExistingElement_whenFind_returnIndex() {
        final int NUM = 3;
        Integer[] testingData = new Integer[]{1,2,3,4,5};

        UnorderedArray unOrderedArray = new UnorderedArray(testingData.clone());
        int expect = 2;
        int actual = unOrderedArray.find(NUM);

        assertEquals(expect, actual, "Array: " + Arrays.toString(testingData) + " The value: " + NUM + " is at index " + expect);

    }

    @Test
    void givenNonExistingElement_whenFind_returnMinus1() {
        final int NUM = 6;
        Integer[] testingData = new Integer[]{1,2,3,4,5};

        UnorderedArray unOrderedArray = new UnorderedArray(testingData.clone());
        int expect = -1;
        int actual = unOrderedArray.find(NUM);

        assertEquals(expect, actual, "Array: " + Arrays.toString(testingData) + " Doesn't contain: " + NUM );

    }

    // ====== Count ======
    @Test
    void given4InsertsAnd1Delete_whenCount_thenReturn3() {
        UnorderedArray unOrderedArray = new UnorderedArray(3);
        unOrderedArray.insert(5);
        unOrderedArray.insert(1);
        unOrderedArray.insert(4);
        unOrderedArray.insert(2);     // the array is full, so it resizes
        unOrderedArray.delete(4);

        assertEquals(3, unOrderedArray.count(), "Array: " + unOrderedArray + " has 3 elements");
    }

    // ====== Resize ======
    @Test
    void givenArrayShrunkByResize_whenInsert_thenAppendAfterTheRemainingElements() {
        final int NUM = 9;
        Integer[] testingData = new Integer[]{1,2,3,4,5};

        UnorderedArray unOrderedArray = new UnorderedArray(testingData.clone());
        unOrderedArray.resize(3);
        unOrderedArray.insert(NUM);

        Integer[] expected = new Integer[]{1,2,3,9,null,null};
        Integer[] actual   = unOrderedArray.getArr();

        assertArrayEquals(expected, actual, "Inserting " + NUM + " after resizing " + Arrays.toString(testingData) + " to 3 Should return " + Arrays.toString(expected));
    }

    @Test
    void givenArrayGrownByResize_whenInsert_thenAppendRightAfterTheLastElement() {
        final int NUM = 3;
        Integer[] testingData = new Integer[]{1,2};

        UnorderedArray unOrderedArray = new UnorderedArray(testingData.clone());
        unOrderedArray.resize(4);
        unOrderedArray.insert(NUM);

        Integer[] expected = new Integer[]{1,2,3,null};
        Integer[] actual   = unOrderedArray.getArr();

        assertArrayEquals(expected, actual, "Inserting " + NUM + " after resizing " + Arrays.toString(testingData) + " to 4 Should return " + Arrays.toString(expected));
    }
}