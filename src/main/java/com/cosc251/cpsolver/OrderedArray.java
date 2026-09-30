package com.cosc251.cpsolver;

import java.util.Arrays;
import java.util.Comparator;

public class OrderedArray extends CustomArray {

    /**
     * Finds the insertion index using binary search to maintain ascending order.
     * Time complexity: O(log N)
     * Explanation: Search space is halved each iteration.
     */
    private int findInsertionIndex(int target) {
        int left = 0;
        int right = count - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * Initializes an empty OrderedArray with the given capacity.
     * @param size initial capacity of the array.
     */
    public OrderedArray(int size) {
        super(size);
    }

    /**
     * Wraps and sorts an existing array.
     * Places non-null elements in ascending order at the front, and nulls at the end.
     * @param arr an Array of type {@code Integer}.
     */
    public OrderedArray(Integer[] arr) {
        super(arr);
        // Safely sorts non-null elements and moves nulls to the end
        Arrays.sort(this.arr, Comparator.nullsLast(Comparator.naturalOrder()));
    }

    /**
     * Inserts an integer while maintaining ascending order.
     * Time complexity:
     * - Best case: O(log N) if inserted at the end without resizing.
     * - Average / Worst case: O(N) due to shifting elements right (or resizing).
     *
     * @param e The element to be inserted into the array.
     */
    @Override
    public void insert(int e) {
        if (count >= arr.length) {
            resize(arr.length == 0 ? 1 : arr.length * 2);
        }

        int index = findInsertionIndex(e);

        // Shift elements right to open space for e
        for (int i = count; i > index; i--) {
            arr[i] = arr[i - 1];
        }

        arr[index] = e;
        count++;
    }

    /**
     * Removes the first occurrence of the given element.
     * Remaining elements shift left so non-null elements remain contiguous.
     * Time complexity:
     * - Best case: O(log N) if element is not found or is the last element.
     * - Average / Worst case: O(N) due to shifting remaining elements left.
     *
     * @param e The element to be removed.
     * @return {@code true} if deleted, {@code false} if not found.
     */
    @Override
    public boolean delete(int e) {
        int index = find(e);
        if (index == -1) {
            return false;
        }

        // Shift elements left to keep contiguous order
        for (int i = index; i < count - 1; i++) {
            arr[i] = arr[i + 1];
        }

        count--;
        arr[count] = null;

        // Shrink capacity if array is 1/4 full
        if (count > 0 && count <= arr.length / 4) {
            resize(arr.length / 2);
        }

        return true;
    }

    /**
     * Binary search to find the index of the element.
     * Always returns the first occurrence when duplicates exist.
     * Time complexity:
     * - Best case: O(1)
     * - Average / Worst case: O(log N)
     *
     * @param e the element to find.
     * @return index of first occurrence, or -1 if not found.
     */
    @Override
    public int find(int e) {
        int left = 0;
        int right = count - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == e) {
                result = mid;
                right = mid - 1; // Continue searching left to find first occurrence
            } else if (arr[mid] < e) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}