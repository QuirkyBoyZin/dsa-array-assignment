package com.cosc251.cpsolver.model;

/**
 * This class extends {@link CustomArray}.
 * @implNote The array in this class will not be sorted
 */
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
     * Removing the first occurrence of the given element {@code e}.
     * <p>
     * After deletion, remaining elements will shift to the left such that all non-null
     * elements remain contiguous.
     *
     * @param e The element to be removed in the array.
     * @return {@code true}: the element is found deleted <br>
     *         {@code false}: the element is not found.
     *
     * @implNote Utilizes {@code Brute-Force} searching algorithm to search for the element to be removed.
     * <p>
     * <b>Time Complexity Analysis:</b>
     * <ul>
     *   <li><b>Best Case O(1):</b> When {@code e} is at the first index</li>
     *   <li><b>Worst Case O(n):</b> When {@code e} is at the last index or is not found</li>
     * </ul>
     */
    @Override
    public boolean delete(int e) {
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
     * @implNote {@code O(1)} Time Complexity in all cases.
     */
    @Override
    public void insert(int e) {
        boolean isArrayFull = pointer == size;

        if (isArrayFull) {
            resize(size() + 1);
            arr[pointer] = e;

        } else {
            arr[pointer] = e;
        }

        pointer++;

        System.out.println("pointer is: " + pointer + " for " + this);


    }

    /**
     * Searches through the array to find the given element {@code e}.
     *
     * @param e the element to be found or not found
     * @return {@code Index} of the corresponding inputted element <br>
     *         {@code -1} if the inputted element doesn't exist
     *
     * @implNote Utilizes a {@code Brute-Force} searching algorithm.
     * <p>
     * <b>Time Complexity Analysis:</b>
     * <ul>
     *   <li><b>Best Case O(1):</b> When {@code e} is at the first index</li>
     *   <li><b>Worst Case O(n):</b> When {@code e} is at the last index</li>
     * </ul>
     */
    @Override
    public int find(int e) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == e) {
                return i;
            }
        }
        return -1;
    }


}
