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

                        @Override
                        boolean delete(int e) {
                            return false;
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

                @Override
                boolean delete(int e) {
                    return false;
                }

                int find(int e) {
                    return 0;
                }
            };
        }
        , "Array Must be at least size 1 !");
    }


    // ====== Get ======
    @Test
    void givenIndexIsNotGreaterOrEqualTo0_whenGet_thenThrowIndexOutOfBound() {
        CustomArray customArray = new CustomArray(1) {
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

        assertThrows(IndexOutOfBoundsException.class, () ->{
            customArray.get(-1);
                }
        );
    }

    @Test
    void givenIndexIsGreaterThanArraySize_whenGet_thenThrowIndexOutOfBound() {
        CustomArray customArray = new CustomArray(1) {
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

        assertThrows(IndexOutOfBoundsException.class, () ->{
                    customArray.get(1);
                }
        );
    }

    @Test
    void givenIndexToNonNullElement_whenGet_thenReturnElement() {
        final int index= 3;
        Integer[] testingData = new Integer[]{1,2,3,4,5};

        CustomArray customArray = new CustomArray(testingData) {
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

        int expected = 4;
        Integer actual   = customArray.get(index);
        assertEquals(expected,actual, "For index: " + index + "\n" + Arrays.toString(testingData) + " should return " + expected );
    }

    @Test
    void givenIndexToNullElement_whenGet_thenReturnNull() {
        final int index= 3;
        Integer[] testingData = new Integer[]{1,2,3,null,5};

        CustomArray customArray = new CustomArray(testingData) {
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

        Integer expected = testingData[3];
        Integer actual   = customArray.get(index);
        assertEquals(expected,actual, "For index: " + index + "\n" + Arrays.toString(testingData) + " should return " + expected );
    }

    // ======= size =======
    @Test
    void givenArrayLength4_whenSize_thenReturn4() {
        CustomArray customArray = new CustomArray(4) {
            @Override
            void insert(int e) {
            }

            @Override
            boolean delete(int e) {
                return false;
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
            boolean delete(int e) {
                return false;
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
            boolean delete(int e) {
                return false;
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
            boolean delete(int e) {
                return false;
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
    void givenNewSize_whenResize_thenSizeChangeToNewSize() {
        CustomArray customArray = new CustomArray(new Integer[]{1,2,null,null}) {
            @Override
            void insert(int e) {
            }

            @Override
            boolean delete(int e) {
                return false;
            }

            @Override
            int find(int e) {
                return 0;
            }
        };
        customArray.resize(2);
        int actualSizeAfterResize = customArray.size();
        assertEquals(2,actualSizeAfterResize);
    }

    @Test
    void givenNewSizeLargerThanCurrentSize_whenResize_thenArrayHaveMorePositionsWithNullValuesAndPreserveOriginalOrder() {
        CustomArray customArray = new CustomArray(new Integer[]{1,2,3,4,5}) {
            @Override
            void insert(int e) {
            }

            @Override
            boolean delete(int e) {
                return false;
            }

            @Override
            int find(int e) {
                return 0;
            }
        };
        customArray.resize(10);
        Integer[] actualArray  = customArray.getArr();
        Integer[] expectedArray = new Integer[]{1,2,3,4,5,null,null,null,null,null};

        assertEquals(expectedArray, actualArray, "Expected: " + Arrays.toString(expectedArray) + "\nActual: " + Arrays.toString(actualArray));

    }

    @Test
    void givenNewSizeSmallerThanCurrentSize_whenResize_thenArrayTruncatesAndPreserveOriginalOrder() {
        CustomArray customArray = new CustomArray(new Integer[]{1,2,3,4,5}) {
            @Override
            void insert(int e) {
            }


            @Override
            boolean delete(int e) {
                return false;
            }

            @Override
            int find(int e) {
                return 0;
            }
        };
        customArray.resize(3);
        Integer[] actualArray = customArray.getArr();
        Integer[] expectedArray = new Integer[]{1,2,3};

        assertEquals(expectedArray, actualArray, "Expected: " + Arrays.toString(expectedArray) + "\nActual: " + Arrays.toString(actualArray));

    }

}
