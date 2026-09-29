package com.cosc251.cpsolver;

public class UnorderedArray extends CustomArray {

    /**
     * <p>Given a size, this constructor will create an Array of type {@code Integer } with {@code Null}
     * values according to the given size. </p>
     * <p> The {@code Null} values will be replaced when inserting elements. </p>
     * <p> The {@code Null} values indicates unused positions. </p>
     *
     * @param size the total capacity of the array.
     */
    public UnorderedArray(int size) {
        super(size);
    }

    /**
     * <p> given an Array of type {@code Integer }, this constructor will create an object of the type {@code CustomArray} with the given array. </p>
     * <p> The object will preserve all the values of the given array while also providing with more
     * methods to work with. </p>
     *
     * @param arr an Array of type {@code Integer }.
     */
    public UnorderedArray(Integer[] arr) {
        super(arr);
    }

    @Override
    public boolean delete(int x) {
        int index = find(x);
        if (index == -1) {
            return false;
        }

        arr[index] = arr[count - 1];
        arr[count - 1] = null;
        count--;

        if (count > 0 && count <= arr.length / 4) {
            resize(arr.length / 2);
        }
        return true;

    }

    /**
     * <p>Inserting an integer to the array. </p>
     * <p> The array will automatically resize if it is full after insertion</p>
     *
     * @param e The element to be inserted into the array.
     */
    @Override
    void insert(int e) {
        if (count >= arr.length) {
            resize(arr.length * 2);
        }

        arr[count++] = e;
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
        for (int i = 0; i < count; i++) {
            if (arr[i] == e) {
                return i;
            }
        }
        return -1;
    }
}
