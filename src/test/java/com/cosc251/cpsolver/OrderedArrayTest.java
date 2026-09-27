package com.cosc251.cpsolver;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OrderedArrayTest {

    // ====== Insert ======
    @Test
    void givenAnyNumberToAFullArray_whenInsert_thenResizeArrayAndPutInCorrectPosition() {
        final int NUM= 8;
        Integer[] testingData = new Integer[]{1,2,3,4,5,7};

        OrderedArray orderedArray = new OrderedArray(testingData.clone());
        orderedArray.insert(NUM);

        Integer[] expected = {1,2,3,4,5,6,7};

        assertEquals(expected,orderedArray.getArr(),"\nInserting " + NUM + " should return: " + Arrays.toString(expected));
    }

    @Test
    void givenExistingNumberInArray_whenInsert_thenPutInCorrectPosition() {
        final int NUM= 1;
        Integer[] testingData = new Integer[]{1,2,3,4,5};
        OrderedArray orderedArray = new OrderedArray(testingData.clone());
        orderedArray.insert(1);

        Integer[] expected = {1,1,2,3,4,5};

        assertEquals(expected,orderedArray.getArr(),"\nInserting " + NUM + " should return: " + Arrays.toString(expected));
    }

    @Test
    void givenNegativeNumber_whenInsert_thenPutInCorrectPosition() {
        final int NUM= -1;
        Integer[] testingData = new Integer[]{1,2,3,4,5};
        OrderedArray orderedArray = new OrderedArray(testingData.clone());
        orderedArray.insert(NUM);

        Integer[] expected = {-1,1,2,3,4,5};

        assertEquals(expected,orderedArray.getArr(),"\nInserting " + NUM + " should return: " + Arrays.toString(expected));
    }

    @Test
    void givenNumberGreaterThanTheCurrentBiggestNumberInTheArray_whenInsert_thenPutInCorrectPosition() {
        final int NUM= 6;
        Integer[] testingData = new Integer[]{1,2,3,4,5};
        OrderedArray orderedArray = new OrderedArray(testingData.clone());
        orderedArray.insert(NUM);

        Integer[] expected = {1,2,3,4,5,6};

        assertEquals(expected,orderedArray.getArr(),"\nInserting " + NUM + " should return: " + Arrays.toString(expected));
    }

    @Test
    void givenNumberLowerThanTheLowestNumberInTheArray_whenInsert_thenPutInCorrectPosition() {
        final int NUM= -6;
        Integer[] testingData = new Integer[]{1,2,3,4,5};
        OrderedArray orderedArray = new OrderedArray(testingData.clone());
        orderedArray.insert(NUM);

        Integer[] expected = {-6,1,2,3,4,5,6};

        assertEquals(expected,orderedArray.getArr(),"\nInserting " + NUM + " should return: " + Arrays.toString(expected));
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
    void givenExistingNumberInArray_whenDelete_thenReturnFalse() {
        final int NUM= 5;
        Integer[] testingData = new Integer[]{1,2,3,4,5};

        OrderedArray orderedArray = new OrderedArray(testingData.clone()) {
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
    void find() {
    }
}