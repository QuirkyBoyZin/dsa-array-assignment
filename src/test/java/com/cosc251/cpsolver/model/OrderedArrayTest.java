package com.cosc251.cpsolver.model;

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

    @Test
    void givenIntegerArrayWithNull_whenOrderedArray_thenSortTheElementsAndMoveNullToTheEnd() {
        Integer[] testingData = new Integer[]{5,null,1,3};
        OrderedArray orderedArray = new OrderedArray(testingData.clone());

        Integer[] expect = {1,3,5,null};
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

        Integer[] expected = {1,2,3,4,5,7,8,null,null,null,null,null};
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

        Integer[] expected = {1,1,2,3,4,5,null,null,null,null};
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

        Integer[] expected = {-1,1,2,3,4,5,null,null,null,null};
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

        Integer[] expected = {1,2,3,4,5,6,null,null,null,null};
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

        Integer[] expected = {-6,1,2,3,4,5,null,null,null,null};
        Integer[] actual   = orderedArray.getArr();

        boolean isEqual = Arrays.equals(expected, actual);
        assertTrue(isEqual, "Inserting " + NUM + " To" + Arrays.toString(testingData) + " Expected: " + Arrays.toString(expected) + " Actual: " + Arrays.toString(actual));
    }

    @Test
    void givenArrayWithUnusedPositions_whenInsert_thenPutInCorrectPositionWithoutResizing() {
        OrderedArray orderedArray = new OrderedArray(5);
        orderedArray.insert(3);
        orderedArray.insert(1);
        orderedArray.insert(2);

        Integer[] expected = {1,2,3,null,null};
        Integer[] actual   = orderedArray.getArr();

        boolean isEqual = Arrays.equals(expected, actual);
        assertTrue(isEqual, "Inserting 3, 1, 2 To an empty array of size 5" + " Expected: " + Arrays.toString(expected) + " Actual: " + Arrays.toString(actual));
    }

    // ====== Delete ======

    @Test
    void givenNonExistingNumberInArray_whenDelete_thenReturnFalse() {
        final int NUM = 6;
        Integer[] testingData = new Integer[]{1, 2, 3, 4, 5};

        OrderedArray orderedArray = new OrderedArray(testingData.clone());

        assertFalse(orderedArray.delete(NUM), "Deleting " + NUM + " from " + Arrays.toString(testingData) + "Should return False");
    }

    @Test
    void givenExistingNumberInArray_whenDelete_thenReturnTrue() {
        final int NUM= 5;
        Integer[] testingData = new Integer[]{1,2,3,4,5};

        OrderedArray orderedArray = new OrderedArray(testingData.clone());

        assertTrue(orderedArray.delete(NUM), "Deleting " + NUM + " from " + Arrays.toString(testingData) + "Should return True");
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

    @Test
    void givenNonExistingElementAfterDelete_whenFind_returnMinus1() {
        final int NUM = 6;
        Integer[] testingData = new Integer[]{1,2,3,4,5};

        OrderedArray orderedArray = new OrderedArray(testingData.clone());
        orderedArray.delete(3);     // leaves an unused (null) position at the end: [1, 2, 4, 5, null]

        int expect = -1;
        int actual = orderedArray.find(NUM);

        assertEquals(expect, actual, "Array: " + orderedArray + " Doesn't contain: " + NUM );

    }

    @Test
    void givenDuplicateElements_whenFind_returnIndexOfFirstOccurrence() {
        final int NUM = 2;
        Integer[] testingData = new Integer[]{2,3,2,1,2};

        OrderedArray orderedArray = new OrderedArray(testingData.clone());     // sorted: [1, 2, 2, 2, 3]
        int expect = 1;
        int actual = orderedArray.find(NUM);

        assertEquals(expect, actual, "Array: " + orderedArray + " The first " + NUM + " is at index " + expect);

    }

    // ====== Count ======
    @Test
    void given4InsertsAnd1Delete_whenCount_thenReturn3() {
        OrderedArray orderedArray = new OrderedArray(3);
        orderedArray.insert(5);
        orderedArray.insert(1);
        orderedArray.insert(4);
        orderedArray.insert(2);     // the array is full, so it resizes
        orderedArray.delete(4);

        assertEquals(3, orderedArray.count(), "Array: " + orderedArray + " has 3 elements");
    }

}