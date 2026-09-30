package com.cosc251.cpsolver.model;

/**
 * An array that keeps elements in the order they were inserted. It is not sorted.
 * The Integer[] arr field and the get, size, count and resize methods come from CustomArray.
 */
public class UnorderedArray extends CustomArray {

    /**
     * Creates an empty unordered array with the given capacity.
     * Time complexity: O(n), Java fills all n slots of the new array with null.
     *
     * @param size the capacity of the array
     * @throws IllegalArgumentException if size is less than 1
     */
    public UnorderedArray(int size) {
        super(size);
    }

    /**
     * Creates an unordered array from a copy of the given elements, keeping their order.
     * Null values are treated as unused slots and end up at the back.
     * Time complexity: O(n), we go through the given array once.
     *
     * @param elements the starting elements
     * @throws IllegalArgumentException if elements is empty
     */
    public UnorderedArray(Integer[] elements) {
        super(elements);
    }

    /**
     * Adds x right after the last element. If the array is full, its size is doubled first.
     * Time complexity: O(1) amortized. Usually x just goes into the next free slot. When the array
     * is full, resizing copies all n elements (O(n)), but because the size doubles this only happens
     * once every n or so inserts, so on average each insert is still O(1).
     *
     * @param x the integer to insert
     */
    @Override
    public void insert(int x) {
        boolean isArrayFull = count == arr.length;

        if (isArrayFull) {
            resize(arr.length * 2);
        }
        arr[count] = x;
        count++;
    }

    /**
     * Removes the first occurrence of x and shifts the remaining elements left so there are no gaps.
     * Time complexity: O(n) in every case. Finding x at index i takes i + 1 steps and shifting the
     * elements after it takes n - i - 1, which adds up to n. If x isn't there, the search checks all n.
     *
     * @param x the integer to remove
     * @return true if x was found and removed, false if it isn't in the array
     */
    @Override
    public boolean delete(int x) {
        int index = find(x);
        boolean isFound = index != -1;

        if (isFound) {
            removeAt(index);
        }
        return isFound;
    }

    /**
     * Linear search: checks the elements one by one from the start.
     * Time complexity: O(n). Best case O(1) when x is the first element. Worst case O(n) when x is
     * the last element or missing, since the array isn't sorted and every element has to be checked.
     *
     * @param x the integer to look for
     * @return the index of the first occurrence of x, or -1 if it isn't in the array
     */
    @Override
    public int find(int x) {
        for (int i = 0; i < count; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }
}
