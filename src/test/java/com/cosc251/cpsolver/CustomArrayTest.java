package com.cosc251.cpsolver;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;


class CustomArrayTest {

    // ======= Constructor =======


        // Integer[] parameter
    @Test
    void givenEmptyIntegerArray_whenCustomArray_thenThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
                    CustomArray customArray = new CustomArray(new Integer[]{}) {
                        void insert(int e) {
                        }

                        int find(int e) {
                            return 0;
                        }
                    };
                }
                , "Array must contain at least 1 element !");
    }
        // Int parameter
    @Test
    void givenIntegerLessThan1_whenCustomArray_thenThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            CustomArray customArray = new CustomArray(0) {
                void insert(int e) {
                }

                int find(int e) {
                    return 0;
                }
            };
        }
        , "Array Must be at least size 1 !");
    }



    // ====== Delete ======


    @Test
    void givenNonExistingNumberInArray_whenDelete_thenReturnFalse() {
        final int NUM = 6;
        Integer[] testingData = new Integer[]{1, 2, 3, 4, 5};

        CustomArray customArray = new CustomArray(testingData.clone()) {
            @Override
            int find(int e) {
                return 0;
            }

            @Override
            void insert(int e) {

            }
        };

        assertFalse(customArray.delete(NUM), "Deleting " + NUM + " from " + Arrays.toString(testingData) + "Should return False");
    }

    @Test
    void givenExistingNumberInArray_whenDelete_thenReturnFalse() {
        final int NUM= 5;
        Integer[] testingData = new Integer[]{1,2,3,4,5};

        CustomArray customArray = new CustomArray(testingData.clone()) {
            int find(int e) {
                return 0;
            }

            void insert(int e) {

            }
        };

        assertTrue(customArray.delete(NUM), "Deleting " + NUM + " from " + Arrays.toString(testingData) + "Should return False");
    }

    @Test
    void givenExistingNumberInArray_whenDelete_thenEmptySpotWillBeFillWithNull() {
        final int NUM= 5;
        Integer[] testingData = new Integer[]{1,2,3,4,5};

        CustomArray customArray = new CustomArray(testingData.clone()) {
            @Override
            int find(int e) {
                return 0;
            }

            @Override
            void insert(int e) {

            }
        };
        customArray.delete(NUM);

        Integer[] expected = new Integer[]{1,2,3,4, null};
        Integer[] actual   = customArray.getArr();

        assertEquals(Arrays.toString(expected), Arrays.toString(actual), "Deleting " + NUM + " from " + Arrays.toString(testingData) + "Should return " + Arrays.toString(expected) ) ;
    }

    @Test
    void givenNumberInMiddleArray_whenDelete_thenArrayMustShiftToTheLeft() {
        final int NUM= 3;
        Integer[] testingData = new Integer[]{1,2,3,4,5};

        CustomArray customArray = new CustomArray(testingData.clone()) {
            @Override
            int find(int e) {
                return 0;
            }

            @Override
            void insert(int e) {

            }
        };
        customArray.delete(NUM);

        Integer[] expected = new Integer[]{1,2,4,5, null};
        Integer[] actual   = customArray.getArr();

        assertEquals(Arrays.toString(expected), Arrays.toString(actual), "Deleting " + NUM + " from " + Arrays.toString(testingData) + "Should return " + Arrays.toString(expected) ) ;
    }



    // ====== Get ======
    @Test
    void get() {
    }




    // ======= size =======
    @Test
    void givenArrayLength4_whenSize_thenReturn4() {
        CustomArray customArray = new CustomArray(4) {
            @Override
            void insert(int e) {
            }

            @Override
            int find(int e) {
                return 0;
            }
        };
        int actualSize = customArray.size();
        assertEquals(4,actualSize);
    }

    // ======= count =======
    @Test
    void given2ElementsAnd2Null_whenCount_thenReturn2() {
        CustomArray customArray = new CustomArray(new Integer[]{1,2,null,null}) {
            @Override
            void insert(int e) {
            }

            @Override
            int find(int e) {
                return 0;
            }
        };

        int actualCount = customArray.count();
        assertEquals(2, actualCount);
    }

    // ======= Resize =======

    @Test
    void givenNewSizeLessThan1_whenResize_thenThrowIndexOutOfBound() {
        CustomArray customArray = new CustomArray(new Integer[]{1,2,3,4,5}) {
            @Override
            void insert(int e) {
            }

            @Override
            int find(int e) {
                return 0;
            }
        };

        assertThrows(IndexOutOfBoundsException.class, () ->{
            customArray.resize(0);
        });

    }

    @Test
    void givenNewSizeEqualsToCurrentSize_whenResize_thenArrayStayTheSame() {
        CustomArray customArray = new CustomArray(new Integer[]{1,2,3,4,5}) {
            @Override
            void insert(int e) {
            }

            @Override
            int find(int e) {
                return 0;
            }
        };
        Integer[] expectedArray = new Integer[]{1,2,3,4,5};
        customArray.resize(3);
        Integer[] actualArray = customArray.getArr();

        boolean isEqual = Arrays.equals(expectedArray,actualArray);

        assertTrue(isEqual);

    }

    @Test
    void givenNewSize2_whenResize_thenSizeChangeTo2() {
        CustomArray customArray = new CustomArray(new Integer[]{1,2,null,null}) {
            @Override
            void insert(int e) {
            }

            @Override
            int find(int e) {
                return 0;
            }
        };
        customArray.resize(2);
        int actualSizeAfterResize = customArray.getSize();
        assertEquals(2,actualSizeAfterResize);
    }

    @Test
    void givenNewSizeLargerThanCurrentSize_whenResize_thenArrayHaveMorePositionsWithNullValuesAndPreserveOriginalOrder() {
        CustomArray customArray = new CustomArray(new Integer[]{1,2,3,4,5}) {
            @Override
            void insert(int e) {
            }

            @Override
            int find(int e) {
                return 0;
            }
        };
        customArray.resize(10);
        Integer[] actualArray  = customArray.getArr();
        Integer[] expectedArray = new Integer[]{1,2,3,4,5,null,null,null,null,null};

        boolean isEqual = Arrays.equals(expectedArray,actualArray);

        assertTrue(isEqual, "Expected: " + Arrays.toString(expectedArray) + "\nActual: " + Arrays.toString(actualArray));
    }

    @Test
    void givenNewSizeSmallerThanCurrentSize_whenResize_thenArrayTruncatesAndPreserveOriginalOrder() {
        CustomArray customArray = new CustomArray(new Integer[]{1,2,3,4,5}) {
            @Override
            void insert(int e) {
            }


            @Override
            int find(int e) {
                return 0;
            }
        };
        customArray.resize(3);
        Integer[] actualArray = customArray.getArr();
        Integer[] expectedArray = new Integer[]{1,2,3};

        boolean isEqual = Arrays.equals(expectedArray,actualArray);

        assertTrue(isEqual, "Expected: " + Arrays.toString(expectedArray) + "\nActual: " + Arrays.toString(actualArray));

    }

}
