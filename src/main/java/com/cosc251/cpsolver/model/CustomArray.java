package com.cosc251.cpsolver.model;

/**
 * Base class for UnorderedArray and OrderedArray. It holds the Integer[] arr and the methods
 * that work the same way in both classes: get, size, count and resize.
 *
 * The elements are always kept together at the front of arr (index 0 to count - 1).
 * Every slot after them is null, which marks it as unused.
 */
public abstract class CustomArray {

    protected Integer[] arr;  // null means the slot is unused
    protected int count;      // number of elements stored, also the index of the next free slot

    /**
     * Creates an empty array with the given capacity.
     * Time complexity: O(n), Java fills all n slots of the new array with null.
     *
     * @param size the capacity of the array
     * @throws IllegalArgumentException if size is less than 1
     */
    public CustomArray(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size must be greater than 0!");
        }
        arr = new Integer[size];
    }

    /**
     * Creates an array from a copy of the given elements, so changing the original later has no effect.
     * Null values are treated as unused slots, so the other elements move to the front in the same order.
     * For example [1, null, 2] becomes [1, 2, null].
     * Time complexity: O(n), we go through the given array once.
     *
     * @param elements the starting elements
     * @throws IllegalArgumentException if elements is empty
     */
    public CustomArray(Integer[] elements) {
        if (elements.length == 0) {
            throw new IllegalArgumentException("Array must not be empty!");
        }

        arr = new Integer[elements.length];
        for (Integer element : elements) {
            if (element != null) {
                arr[count] = element;
                count++;
            }
        }
    }

    /**
     * Inserts x into the array. If the array is full, it is resized first.
     * Time complexity: depends on the class, see UnorderedArray and OrderedArray.
     *
     * @param x the integer to insert
     */
    public abstract void insert(int x);

    /**
     * Removes the first occurrence of x and shifts the remaining elements left so there are no gaps.
     * Time complexity: depends on the class, see UnorderedArray and OrderedArray.
     *
     * @param x the integer to remove
     * @return true if x was found and removed, false if it isn't in the array
     */
    public abstract boolean delete(int x);

    /**
     * Searches the array for x.
     * Time complexity: depends on the class, see UnorderedArray and OrderedArray.
     *
     * @param x the integer to look for
     * @return the index of x, or -1 if it isn't in the array
     */
    public abstract int find(int x);

    /**
     * Returns the element at the given index, or null if that slot is unused.
     * Time complexity: O(1), an array can jump straight to any index.
     *
     * @param index the position to read
     * @return the element at index, or null if the slot is unused
     * @throws IndexOutOfBoundsException if index is negative or not less than size()
     */
    public Integer get(int index) {
        if (index < 0 || index >= arr.length) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for size " + arr.length);
        }
        return arr[index];
    }

    /**
     * Returns the total capacity of the array, counting both used and unused slots.
     * Time complexity: O(1), Java stores the length with the array.
     */
    public int size() {
        return arr.length;
    }

    /**
     * Returns the number of non-null elements currently stored.
     * Time complexity: O(1), count is updated on every insert and delete, so we never have to recount.
     */
    public int count() {
        return count;
    }

    /**
     * Changes the capacity to newSize and keeps the elements in the same order.
     * If newSize is smaller than count, the elements past the new size are discarded.
     * Time complexity: O(n), every element is copied into a new array.
     *
     * @param newSize the new capacity
     * @throws IllegalArgumentException if newSize is less than 1
     */
    public void resize(int newSize) {
        if (newSize < 1) {
            throw new IllegalArgumentException("New size must be greater than 0!");
        }

        arr = copyElements(newSize);
        if (newSize < count) {
            count = newSize;
        }
    }

    /**
     * Returns a copy of the whole array, unused (null) slots included.
     * Time complexity: O(n), every element is copied.
     */
    public Integer[] getArr() {
        return copyElements(arr.length);
    }

    /**
     * Returns the array as text, for example [1, 2, null].
     * Time complexity: O(n), each slot is visited once.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                result.append(", ");
            }
            result.append(arr[i]);
        }
        return result.append("]").toString();
    }

    /**
     * Removes the element at index by shifting every element after it one slot to the left.
     * Both classes use this in delete.
     * Time complexity: O(n) in the worst case (removing the first element), O(1) when removing the last one.
     *
     * @param index the position to remove, must be less than count
     */
    protected void removeAt(int index) {
        for (int i = index; i < count - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[count - 1] = null;
        count--;
    }

    /**
     * Copies the elements into a new array of the given length. Slots without an element stay null.
     * Time complexity: O(n), each element is copied once.
     *
     * @param length the length of the new array
     * @return the new array
     */
    private Integer[] copyElements(int length) {
        Integer[] copy = new Integer[length];
        for (int i = 0; i < count && i < length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }
}
