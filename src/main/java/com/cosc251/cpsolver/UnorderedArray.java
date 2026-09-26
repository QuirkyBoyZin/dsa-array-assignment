package com.cosc251.cpsolver;

public class UnorderedArray extends Array{

    /**
     * <p>Inserting an integer to the array. </p>
     * <p> The array will automatically resize if it is full after insertion</p>
     *
     * @param e The element to be inserted into the array.
     */
    @Override
    void insert(int e) {

    }

    /**
     *
     * <p>Removing the first occurrence of the given element. </p>
     * <p>After deletion, remaining elements will shift to the left such that all non-null elements remain contiguous.</p>
     *
     * @param e The element to be inserted into the array.
     * @return {@code True}: the element is found deleted
     * {@code False}: the element is not found.
     */
    @Override
    boolean delete(int e) {
        return false;
    }

    /**
     * <p> Get the element according to the given index </p>
     *
     * @param index the position of a particular element
     * @return <p> {@Code Null }  if no element exist at the inputted index </p>
     */
    @Override
    Integer get(int index) {
        return 0;
    }

    /**
     * <p> Searches through the array to find the inputted element. </p>
     *
     * @param e the element to be found or not found
     * @return <p>{@code Index} of the corresponding inputted  element</p>
     * <p>{@code -1 } if the inputted element doesn't exist</p>
     * @throws IndexOutOfBoundsException If the given index is equal or more than the size of the array
     *
     */
    @Override
    int find(int e) {
        return 0;
    }
}
