package com.cosc251.cpsolver;

import com.cosc251.cpsolver.model.UnorderedArray;
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

        assertEquals(expected,actual, "Inserting " + NUM + " to " + Arrays.toString(testingData) + " Should return " + Arrays.toString(expected));

    }

    @Test
    void givenElementToAFullArray_whenInsert_thenResizeArrayToAddNewElement() {
        final int NUM = 8;
        Integer[] testingData = new Integer[]{5,4,1,2,5};

        UnorderedArray unorderedArray = new UnorderedArray(testingData.clone());
        unorderedArray.insert(NUM);

        Integer[] expected = new Integer[]{5,4,1,2,5,8};
        Integer[] actual = unorderedArray.getArr();

        assertEquals(expected,actual, "Inserting " + NUM + " to " + Arrays.toString(testingData) + " Should return " + Arrays.toString(expected));
    }

    // ====== Delete ======
    @Test
    void givenNonExistingNumberInArray_whenDelete_thenReturnFalse() {
        final int NUM = 6;
        Integer[] testingData = new Integer[]{1, 2, 3, 4, 5};

        UnorderedArray unOrderedArray = new UnorderedArray(testingData.clone()) {
            @Override
            boolean delete(int e) {
                return false;
            }

            @Override
            int find(int e) {
                return 0;
            }

            @Override
            void insert(int e) {

            }
        };

        assertFalse(unOrderedArray.delete(NUM), "Deleting " + NUM + " from " + Arrays.toString(testingData) + "Should return False");
    }

    @Test
    void givenExistingNumberInArray_whenDelete_thenReturnFalse() {
        final int NUM= 5;
        Integer[] testingData = new Integer[]{1,2,3,4,5};

        UnorderedArray unOrderedArray = new UnorderedArray(testingData.clone()) {
            @Override
            boolean delete(int e) {
                return false;
            }

            int find(int e) {
                return 0;
            }

            void insert(int e) {

            }
        };

        assertTrue(unOrderedArray.delete(NUM), "Deleting " + NUM + " from " + Arrays.toString(testingData) + "Should return False");
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
}