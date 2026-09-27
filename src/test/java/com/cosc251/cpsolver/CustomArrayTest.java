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

                        boolean delete(int e) {
                            return false;
                        }

                        Integer get(int index) {
                            return 0;
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

                boolean delete(int e) {
                    return false;
                }

                Integer get(int index) {
                    return 0;
                }

                int find(int e) {
                    return 0;
                }
            };
        }
        , "Array Must be at least size 1 !");
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
            Integer get(int index) {
                return 0;
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
            Integer get(int index) {
                return 0;
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
            Integer get(int index) {
                return 0;
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
            Integer get(int index) {
                return 0;
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
            boolean delete(int e) {
                return false;
            }

            @Override
            Integer get(int index) {
                return 0;
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
            boolean delete(int e) {
                return false;
            }

            @Override
            Integer get(int index) {
                return 0;
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
            boolean delete(int e) {
                return false;
            }

            @Override
            Integer get(int index) {
                return 0;
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
