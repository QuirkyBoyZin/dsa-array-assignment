package com.cosc251.cpsolver;

/**
 * <p> This class serves as a blueprint to build the {@link OrderedArray} and {@link UnorderedArray} class </p>
 * <p> Implementations of this class, will have different use cases, disadvantages and advantages.</p>
 * <p> Key characteristics for the implementation will be written in the Javadoc's  {@code @implNote }  field .</p>
 */
abstract public class CustomArray {
    // Element will be set to null to indicate unused positions.
    private Integer[] arr;
    private int size; // the capacity or the maximum size that the current array could hold
    private int count; // the number of non-null elements tha the current array have

    public Integer[] getArr() {
        return arr;
    }

    public void setArr(Integer[] arr) {
        this.arr = arr;
    }

    // Overloaded constructors:

    /**
     * <p>Given a size, this constructor will create an Array of type {@code Integer } with {@code Null}
     * values according to the given size. </p>
     * <p> The {@code Null} values will be replaced when inserting elements. </p>
     * <p> The {@code Null} values indicates unused positions. </p>
     *
     * @param size the total capacity of the array.
     */
    public CustomArray(int size) {
        this.size = size;
        this.count = 0;
        this.arr = new Integer[size];
    }

    /**
     * <p> given an Array of type {@code Integer }, this constructor will create an object of the type {@code CustomArray} with the given array. </p>
     * <p> The object will preserve all the values of the given array while also providing with more
     * methods to work with. </p>
     *
     * @param arr an Array of type {@code Integer }.
     */
    public CustomArray(Integer[] arr) {
        this.arr = arr;
        this.size = arr.length;
        this.count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                count++;
            }
        }
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
     * <p> Get the element according to the given index </p>
     *
     * @param index the position of a particular element
     * @return {@code Null}  if no element exist at the inputted index, else return the {@code element} .
     * @throws IndexOutOfBoundsException If the given index is not greater or equal to 0
     */
    public Integer get(int index) {
        return null;
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
     *
     */
    public void resize(int newSize) {

    }


}
