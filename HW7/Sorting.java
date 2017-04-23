/**
* Collection of sorting algorithms for use in HW07 - Silicon Valley
* @version 1.0
* @author Samuel Gedaly
*/
public class Sorting {

/**
* Method for Insertion Sort
* @param tenXers takes in a Comparable array of tenXers
*/
    public static void insertionSort(Comparable[] tenXers) {
        Comparable key;
        for (int i = 1; i < tenXers.length; i++) {
            key = tenXers[i];
            int j;
            for  (j = i - 1; j >= 0 && tenXers[j].compareTo(key) >= 1; j--) {
                tenXers[j + 1] = tenXers[j];
            }
            tenXers[j + 1] = key;
        }
    }
/**
* Method for Merge Sort
* @param arr takes in a Comparable array
*/
    public static void mergeSort(Comparable[] arr) {
        // Your Implementation of Merge Sort
        Comparable[] temp = new TenXer[arr.length];
        int low = 0;
        int high = arr.length - 1;
        mergeSort(arr, temp, low, high);
    }

/**
* Recursive helper method for Merge Sort
* @param arr takes in a Comparable array
* @param temp is a Comparable array
* @param low is an int for the lower number
* @param high is an int for the higher number
*/
    private static void mergeSort(Comparable[] arr, Comparable[] temp,
            int low, int high) {
        // Recursive helper method for Merge Sort
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, temp, low, mid);
            mergeSort(arr, temp, mid + 1, high);
            merge(arr, temp, low, mid, high);

        }
    }
/**
* Helper method to merge sort sub arrays
* @param arr takes in a Comparable array
* @param temp is a Comparable array
* @param low is an int for the lower number
* @param high is an int for the higher number
*/
    private static void merge(Comparable[] arr, Comparable[] temp,
            int low, int mid, int high) {
        // Helper method to merge sorted sub arrays
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }
        int lo = low;
        int hi = mid + 1;
        for (int k = low; k <= high; k++) {
            if (lo > mid) {
                arr[k] = temp[hi++];
            } else if (hi > high) {
                arr[k] = temp[lo++];
            } else if (temp[lo].compareTo(temp[hi]) <= -1
                || temp[lo].compareTo(temp[hi]) == 0) {
                arr[k] = temp[lo++];
            } else {
                arr[k] = temp[hi++];
            }
        }
    }
}