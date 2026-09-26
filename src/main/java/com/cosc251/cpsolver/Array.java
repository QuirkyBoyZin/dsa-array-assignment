package com.cosc251.cpsolver;

abstract public class Array {
    Integer[] arr;
    int size;

    /**
     *
     * <p>Inserting an integer to the array. </p>
     * <p> The array will automatically resize if it is full after insertion</p>
     *
     * @param e The element to be inserted into the array.
     */
    abstract void insert(int e);

    /**
     *
     * <p>Removing the first occurrence of the given element. </p>
     * <p>After deletion, remaining elements will shift to the left such that all non-null elements remain contiguous.</p>
     *
     * @param e The element to be inserted into the array.
     * @return {@code True}: the element is found deleted
     * {@code False}: the element is not found.
     */
    abstract boolean delete(int e);

    /**
     * <p> Get the element according to the given index </p>
     *
     * @param index the position of a particular element
     * @return <p> {@Code Null }  if no element exist at the inputted index </p>
     */
    abstract Integer get(int index);


    /**
     * <p> Searches through the array to find the inputted element. </p>
     * @param e the element to be found or not found
     * @return <p>{@code Index} of the corresponding inputted  element</p>
     *         <p>{@code -1 } if the inputted element doesn't exist</p>
     * @throws IndexOutOfBoundsException  If the given index is equal or more than the size of the array
     *
     */
    abstract int find(int e);

    /**
     * <p>Gives the size of the array. </p>
     * <p> Consider the following array: {@code [1,2,3,4] }, the size would be equal to {@code 4} </p>
     *
     * @return The length of the array.
     */
    public int size() {
        return 0;
    }

    /**
     * @return The number of non-null elements in the array.
     */
    public int count() {
        return 0;
    }

    /**
     * <p> Changes the size of the array to the given {@code newSize } , While preserving the existing elements' order</p>
     *
     *
     */
    public void resize(int newSize) {

    }


}
