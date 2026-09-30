package com.cosc251.cpsolver;

/**
 * <p> This class serves as a blueprint to build the {@link OrderedArray} and {@link UnorderedArray} class </p>
 * <p> Implementations of this class will have different use cases, disadvantages, and advantages.</p>
 * <p> Key characteristics for the implementation will be written in the Javadoc's {@code @implNote} field.</p>
 */
public abstract class CustomArray {
    // Elements set to null indicate unused positions.
    protected Integer[] arr;
    protected int count;

    public Integer[] getArr() {
        return arr;
    }

    /**
     * Given a size, creates an array of type {@code Integer} with {@code null} values.
     * @throws IllegalArgumentException if given size is less than or equal to 0.
     * @param size the total capacity of the array.
     */
    public CustomArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0!");
        }
        this.arr = new Integer[size];
        this.count = 0;
    }

    /**
     * Wraps an existing array and counts non-null elements.
     * @param arr an Array of type {@code Integer}.
     */
    public CustomArray(Integer[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        this.arr = arr;
        this.count = 0;
        for (Integer i : this.arr) {
            if (i != null) {
                count++;
            }
        }
    }

    /**
     * Removes the first occurrence of the given element.
     * @param e The element to be removed.
     * @return {@code true} if element was found and deleted, {@code false} otherwise.
     */
    public abstract boolean delete(int e);

    /**
     * Searches through the array to find the inputted element.
     * @param e the element to find.
     * @return index of the element, or -1 if not found.
     */
    public abstract int find(int e);

    /**
     * Inserts an integer into the array.
     * Automatically resizes if capacity is exceeded.
     * @param e The element to insert.
     */
    public abstract void insert(int e);

    /**
     * Gets the element at the given index.
     * @param index the position of the element.
     * @return {@code null} if no element exists at index, otherwise the {@code Integer} value.
     * @throws IndexOutOfBoundsException if index is negative or &gt;= capacity.
     */
    public Integer get(int index) {
        if (index < 0 || index >= arr.length) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return arr[index];
    }

    /**
     * @return The length (capacity) of the underlying array.
     */
    public int size() {
        return arr.length;
    }

    /**
     * @return The number of non-null elements currently stored.
     */
    public int count() {
        return count;
    }

    /**
     * Changes the capacity of the array to {@code newSize} while preserving existing elements.
     * @throws IllegalArgumentException if {@code newSize} is negative.
     */
    public void resize(int newSize) {
        if (newSize < 0) {
            throw new IllegalArgumentException("New size must be a positive integer");
        }

        Integer[] newArr = new Integer[newSize];
        int elementsToCopy = Math.min(count, newSize);

        for (int i = 0; i < elementsToCopy; i++) {
            newArr[i] = arr[i];
        }

        this.arr = newArr;
        this.count = elementsToCopy;
    }
}