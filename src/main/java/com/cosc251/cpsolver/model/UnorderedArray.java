package com.cosc251.cpsolver.model;

public class UnorderedArray extends CustomArray {
    /**
     * <p>Given a size, this constructor will create an Array of type {@code Integer } with {@code Null}
     * values according to the given size. </p>
     * <p> The {@code Null} values will be replaced when inserting elements. </p>
     * <p> The {@code Null} values indicates unused positions. </p>
     *
     * @param size the total capacity of the array.
     */
    public UnorderedArray(int size) {
        super(size);
    }

    /**
     * <p> given an Array of type {@code Integer }, this constructor will create an object of the type {@code CustomArray} with the given array. </p>
     * <p> The object will preserve all the values of the given array while also providing with more
     * methods to work with. </p>
     *
     * @param arr an Array of type {@code Integer }.
     */
    public UnorderedArray(Integer[] arr) {
        super(arr);
    }

    /**
     *
     * <p>Removing the first occurrence of the given element. </p>
     * <p>After deletion, remaining elements will shift to the left such that all non-null elements remain contiguous.</p>
     *
     * @param e The element to be removed into the array.
     * @return {@code True}: the element is found deleted
     * {@code False}: the element is not found.
     */
    @Override
    boolean delete(int e) {
        int index = find(e);
        boolean isFound = index != -1; // False when find(e) returns -1 (exist), false if it returns something else

        if (isFound) {
            arr[index] = null;
            UnorderedArray newArr = new UnorderedArray(arr);
            arr = newArr.arr;
            return true;
        }

        return false;

    }

    /**
     * <p>Inserting an integer to the array. </p>
     * <p> The array will automatically resize if it is full after insertion</p>
     *
     * @param e The element to be inserted into the array.
     */
    @Override
    void insert(int e) {
        boolean isArrayFull = pointer == arr.length;

        if (isArrayFull) {
            resize(pointer + 1);
            arr[pointer] = e;
            pointer ++;
        } else {
            arr[pointer] = e;
        }

    }

    /**
     * <p> Searches through the array to find the inputted element. </p>
     *
     * @param e the element to be found or not found
     * @return <p>{@code Index} of the corresponding inputted  element</p>
     * <p>{@code -1 } if the inputted element doesn't exist</p>
     *
     *
     */
    @Override
    int find(int e) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == e) {
                return i;
            }
        }
        return -1;
    }
}
