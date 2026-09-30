package com.cosc251.cpsolver.model;

/**
 * An array that always keeps its elements sorted in ascending order.
 * The Integer[] arr field and the get, size, count and resize methods come from CustomArray.
 */
public class OrderedArray extends CustomArray {

    /**
     * Creates an empty ordered array with the given capacity.
     * Time complexity: O(n), Java fills all n slots of the new array with null.
     *
     * @param size the capacity of the array
     * @throws IllegalArgumentException if size is less than 1
     */
    public OrderedArray(int size) {
        super(size);
    }

    /**
     * Creates an ordered array from a copy of the given elements and sorts them with insertion sort.
     * Null values are treated as unused slots and end up at the back.
     * Time complexity: O(n^2) in the worst case, when the elements are in descending order and each one
     * has to move past all the elements before it. O(n) in the best case, when they're already sorted.
     *
     * @param elements the starting elements
     * @throws IllegalArgumentException if elements is empty
     */
    public OrderedArray(Integer[] elements) {
        super(elements);

        // insertion sort: put each element into the sorted part on its left
        for (int i = 1; i < count; i++) {
            insertIntoSortedPart(arr[i], i);
        }
    }

    /**
     * Inserts x at its sorted position. If the array is full, its size is doubled first.
     * Time complexity: O(n). In the worst case x is the smallest element and every element shifts
     * one slot right. Best case O(1) when x is the largest and there is still room. Resizing also
     * costs O(n), but with doubling it only happens once every n or so inserts.
     *
     * @param x the integer to insert
     */
    @Override
    public void insert(int x) {
        boolean isArrayFull = count == arr.length;

        if (isArrayFull) {
            resize(arr.length * 2);
        }
        insertIntoSortedPart(x, count);
        count++;
    }

    /**
     * Removes the first occurrence of x and shifts the remaining elements left so there are no gaps.
     * Time complexity: O(n). Binary search finds x in O(log n), but the shift is O(n) in the worst
     * case (removing the first element). Best case O(log n) when x is the last element or isn't there.
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
     * Binary search for x. If x appears more than once, the index of the first one is returned.
     * Time complexity: O(log n). Every step cuts the search range in half. After a match we keep
     * searching the left half for an earlier copy, so it takes O(log n) steps in every case.
     *
     * @param x the integer to look for
     * @return the index of the first occurrence of x, or -1 if it isn't in the array
     */
    @Override
    public int find(int x) {
        int low = 0;
        int high = count - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;  // same as (low + high) / 2 but can't overflow

            if (arr[mid] == x) {
                index = mid;
                high = mid - 1;  // keep looking left for an earlier copy
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }

    /**
     * Places x into the sorted part arr[0..sortedCount - 1] by shifting every bigger element one slot
     * right. arr[sortedCount] has to be free (or hold x itself), because the last element may move into it.
     * Time complexity: O(n) in the worst case when x is smaller than everything, O(1) when x is
     * greater than or equal to the last element.
     *
     * @param x the integer to place
     * @param sortedCount how many elements at the front are already sorted
     */
    private void insertIntoSortedPart(int x, int sortedCount) {
        int i = sortedCount - 1;
        while (i >= 0 && arr[i] > x) {
            arr[i + 1] = arr[i];
            i--;
        }
        arr[i + 1] = x;
    }
}
