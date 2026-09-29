package com.cosc251.cpsolver;

import java.util.Arrays;

/**
 * <p> This class serves as a blueprint to build the {@link OrderedArray} and {@link UnorderedArray} class </p>
 * <p> Implementations of this class, will have different use cases, disadvantages and advantages.</p>
 * <p> Key characteristics for the implementation will be written in the Javadoc's  {@code @implNote }  field .</p>
 */
abstract public class CustomArray {
    // Element will be set to null to indicate unused positions.
    private Integer[] arr;
    private int size;
    private int count;

    public Integer[] getArr() {
        return arr;
    }

    // Overloaded constructors:

    /**
     * <p>Given a size, this constructor will create an Array of type {@code Integer } with {@code Null}
     * values according to the given size. </p>
     * <p> The {@code Null} values will be replaced when inserting elements. </p>
     * <p> The {@code Null} values indicates unused positions. </p>
     * @throws IllegalArgumentException if given size less than 1.
     * @param size the total capacity of the array.
     */
    public CustomArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0!");
        }

        this.size = size;
        this.arr = new Integer[size];
    }

    /**
     * <p> given an Array of type {@code Integer }, this constructor will create an object of the type {@code CustomArray} with the given array. </p>
     * <p> The object will preserve all the values of the given array while also providing with more
     * methods to work with. </p>
     *
     * @throws IllegalArgumentException if given empty array.
     * @param arr an Array of type {@code Integer }.
     */
    public CustomArray(Integer[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array must not be empty!");
        }
        this.arr = arr;
        this.size = arr.length;
        countNonNullElement();
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
    abstract boolean delete(int e);


    /**
     * <p> Searches through the array to find the inputted element. </p>
     *
     * @param e the element to be found or not found
     * @return <p>{@code Index} of the corresponding inputted  element</p>
     * <p>{@code -1 } if the inputted element doesn't exist</p>
     *
     *
     */
    abstract int find(int e);

    /**
     *
     * <p>Inserting an integer to the array. </p>
     * <p> The array will automatically resize if it is full after insertion</p>
     *
     * @param e The element to be inserted into the array.
     */
    abstract void insert(int e);

    /**
     * <p> Get the element according to the given index </p>
     *
     * @param index the position of a particular element
     * @return {@code Null}  if no element exist at the inputted index, else return the {@code element} .
     * @throws IndexOutOfBoundsException If the given index is not greater or equal to 0
     */
    public Integer get(int index) {
        return arr[index];

    }

    /**
     * <p>Gives the size of the array. </p>
     * <p> Consider the following array: {@code [1,2,3,4] }, the size would be equal to {@code 4} </p>
     *
     * @return The length of the array.
     */
    public int size() {
        return size;
    }

    /**
     * @return The number of non-null elements in the array.
     */
    public int count() {
        return count;
    }

    /**
     * <p> Changes the size of the array to the given {@code newSize } , While preserving the existing elements' order</p>
     * @throws IllegalArgumentException if given newSize less than 1.
     */
    public void resize(int newSize) throws IllegalArgumentException{
        if (newSize < 1) {
            throw new IllegalArgumentException("New size must be greater than 0!");
        }
        Integer[] arrResized = null;

        if (newSize > size) {
            arrResized = Arrays.copyOfRange(arr, 0, newSize);
            Arrays.fill(arrResized, size, newSize, null);

        } else {
            for (int i = 0; i < newSize; i++) {
                arrResized = Arrays.copyOfRange(arr, 0, newSize);
            }
        }

        arr  = arrResized;
        size = newSize;
        countNonNullElement();


    }

    private void countNonNullElement() {
        for (Integer i : this.arr) {
            if (i != null) {
                count++;
            }
        }

    }



}
