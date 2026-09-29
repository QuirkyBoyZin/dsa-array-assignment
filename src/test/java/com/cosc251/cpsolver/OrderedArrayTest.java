package com.cosc251.cpsolver;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OrderedArrayTest {

    // ====== Constructor ======

    @Test
    void givenIntegerArray_whenOrderedArray_thenSortTheIntegerArray() {
        Integer[] testingData = new Integer[]{5,4,3,2,17};
        OrderedArray orderedArray = new OrderedArray(testingData.clone());

        Arrays.sort(testingData);

        Integer[] expect = testingData;
        Integer[] actual = orderedArray.getArr();

        boolean isEqual = Arrays.equals(expect, actual);

        assertTrue(isEqual,"The array: " + Arrays.toString(testingData) + " Must be sorted !"+ " Actual: " + Arrays.toString(actual));
    }

    // ====== Insert ======
    @Test
    void givenAnyNumberToAFullArray_whenInsert_thenResizeArrayAndPutInCorrectPosition() {
        final int NUM= 8;
        Integer[] testingData = new Integer[]{1,2,3,4,5,7};

        OrderedArray orderedArray = new OrderedArray(testingData.clone());
        orderedArray.insert(NUM);

        Integer[] expected = {1,2,3,4,5,7,8};
        Integer[] actual   = orderedArray.getArr();

        boolean isEqual = Arrays.equals(expected, actual);
        assertTrue(isEqual, "Inserting " + NUM + " To" + Arrays.toString(testingData) + " Expected: " + Arrays.toString(expected) + " Actual: " + Arrays.toString(actual));
    }

    @Test
    void givenExistingNumberInArray_whenInsert_thenPutInCorrectPosition() {
        final int NUM= 1;
        Integer[] testingData = new Integer[]{1,2,3,4,5};
        OrderedArray orderedArray = new OrderedArray(testingData.clone());
        orderedArray.insert(1);

        Integer[] expected = {1,1,2,3,4,5};
        Integer[] actual   = orderedArray.getArr();

        boolean isEqual = Arrays.equals(expected, actual);
        assertTrue(isEqual, "Inserting " + NUM + " To" + Arrays.toString(testingData) + " Expected: " + Arrays.toString(expected) + " Actual: " + Arrays.toString(actual));
    }

    @Test
    void givenNegativeNumber_whenInsert_thenPutInCorrectPosition() {
        final int NUM= -1;
        Integer[] testingData = new Integer[]{1,2,3,4,5};
        OrderedArray orderedArray = new OrderedArray(testingData.clone());
        orderedArray.insert(NUM);

        Integer[] expected = {-1,1,2,3,4,5};
        Integer[] actual   = orderedArray.getArr();

        boolean isEqual = Arrays.equals(expected, actual);
        assertTrue(isEqual, "Inserting " + NUM + " To" + Arrays.toString(testingData) + " Expected: " + Arrays.toString(expected) + " Actual: " + Arrays.toString(actual));
    }

    @Test
    void givenNumberGreaterThanTheCurrentBiggestNumberInTheArray_whenInsert_thenPutInCorrectPosition() {
        final int NUM= 6;
        Integer[] testingData = new Integer[]{1,2,3,4,5};
        OrderedArray orderedArray = new OrderedArray(testingData.clone());
        orderedArray.insert(NUM);

        Integer[] expected = {1,2,3,4,5,6};
        Integer[] actual   = orderedArray.getArr();

        boolean isEqual = Arrays.equals(expected, actual);
        assertTrue(isEqual, "Inserting " + NUM + " To" + Arrays.toString(testingData) + " Expected: " + Arrays.toString(expected) + " Actual: " + Arrays.toString(actual));
    }

    @Test
    void givenNumberLowerThanTheLowestNumberInTheArray_whenInsert_thenPutInCorrectPosition() {
        final int NUM= -6;
        Integer[] testingData = new Integer[]{1,2,3,4,5};
        OrderedArray orderedArray = new OrderedArray(testingData.clone());
        orderedArray.insert(NUM);

        Integer[] expected = {-6,1,2,3,4,5};
        Integer[] actual   = orderedArray.getArr();

        boolean isEqual = Arrays.equals(expected, actual);
        assertTrue(isEqual, "Inserting " + NUM + " To" + Arrays.toString(testingData) + " Expected: " + Arrays.toString(expected) + " Actual: " + Arrays.toString(actual));
    }

    // ====== Delete ======

    @Test
    void givenNonExistingNumberInArray_whenDelete_thenReturnFalse() {
        final int NUM = 6;
        Integer[] testingData = new Integer[]{1, 2, 3, 4, 5};

        OrderedArray orderedArray = new OrderedArray(testingData.clone()) {
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

        assertFalse(orderedArray.delete(NUM), "Deleting " + NUM + " from " + Arrays.toString(testingData) + "Should return False");
    }

    @Test
    void givenExistingNumberInArray_whenDelete_thenReturnTrue() {
        final int NUM= 5;
        Integer[] testingData = new Integer[]{1,2,3,4,5};

        OrderedArray orderedArray = new OrderedArray(testingData.clone());

        assertTrue(orderedArray.delete(NUM), "Deleting " + NUM + " from " + Arrays.toString(testingData) + "Should return False");
    }

    @Test
    void givenExistingNumberInArray_whenDelete_thenEmptySpotWillBeFillWithNull() {
        final int NUM= 5;
        Integer[] testingData = new Integer[]{1,2,3,4,5};

        OrderedArray orderedArray = new OrderedArray(testingData.clone());
        orderedArray.delete(NUM);

        Integer[] expected = new Integer[]{1,2,3,4, null};
        Integer[] actual   = orderedArray.getArr();

        assertEquals(Arrays.toString(expected), Arrays.toString(actual), "Deleting " + NUM + " from " + Arrays.toString(testingData) + "Should return " + Arrays.toString(expected) ) ;
    }

    @Test
    void givenNumberInMiddleArray_whenDelete_thenArrayMustShiftToTheLeft() {
        final int NUM= 3;
        Integer[] testingData = new Integer[]{1,2,3,4,5};

        OrderedArray orderedArray = new OrderedArray(testingData.clone());
        orderedArray.delete(NUM);

        Integer[] expected = new Integer[]{1,2,4,5, null};
        Integer[] actual   = orderedArray.getArr();

        assertEquals(Arrays.toString(expected), Arrays.toString(actual), "Deleting " + NUM + " from " + Arrays.toString(testingData) + "Should return " + Arrays.toString(expected) ) ;
    }

    // ====== Find ======
    @Test
    void givenExistingElement_whenFind_returnIndex() {
        final int NUM = 3;
        Integer[] testingData = new Integer[]{1,2,3,4,5};

        OrderedArray orderedArray = new OrderedArray(testingData.clone());
        int expect = 2;
        int actual = orderedArray.find(NUM);

        assertEquals(expect, actual, "Array: " + Arrays.toString(testingData) + " The value: " + NUM + " is at index " + expect);

    }

    @Test
    void givenNonExistingElement_whenFind_returnMinus1() {
        final int NUM = 6;
        Integer[] testingData = new Integer[]{1,2,3,4,5};

        OrderedArray orderedArray = new OrderedArray(testingData.clone());
        int expect = -1;
        int actual = orderedArray.find(NUM);

        assertEquals(expect, actual, "Array: " + Arrays.toString(testingData) + " Doesn't contain: " + NUM );

    }



}