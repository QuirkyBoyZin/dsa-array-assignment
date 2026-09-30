package com.cosc251.cpsolver;

public class UnorderedArray extends CustomArray {

    public UnorderedArray(int size) {
        super(size);
    }

    public UnorderedArray(Integer[] arr) {
        super(arr);
    }

    /**
     * Appends an element to the end of the array.
     * Time complexity:
     * - Amortized: O(1)
     * - Worst case: O(N) when resizing.
     *
     * @param e The element to be inserted into the array.
     */
    @Override
    public void insert(int e) {
        if (count >= arr.length) {
            resize(arr.length == 0 ? 1 : arr.length * 2);
        }

        arr[count++] = e;
    }

    /**
     * Linear search through non-null elements.
     * Time complexity:
     * - Best case: O(1) if target is at index 0.
     * - Average / Worst case: O(N)
     *
     * @param e the element to find.
     * @return index of element, or -1 if not found.
     */
    @Override
    public int find(int e) {
        for (int i = 0; i < count; i++) {
            if (arr[i] != null && arr[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes the first occurrence of the given element.
     * Shifts remaining elements left to maintain contiguous non-null order.
     * Time complexity:
     * - Average / Worst case: O(N)
     *
     * @param x The element to be removed.
     * @return {@code true} if deleted, {@code false} if not found.
     */
    @Override
    public boolean delete(int x) {
        int index = find(x);
        if (index == -1) {
            return false;
        }

        // Shift remaining elements left
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
}