import java.util.*;

public class SortingComparison {

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000};

        for (int n : sizes) {
            int[] arr = generateRandomArray(n);

            System.out.println("Dataset Size: " + n);

            // Bubble Sort
            int[] bubbleArr = arr.clone();
            long start = System.nanoTime();
            bubbleSort(bubbleArr);
            long end = System.nanoTime();
            System.out.println("Bubble Sort: " + (end - start) / 1_000_000.0 + " ms");

            // Merge Sort
            int[] mergeArr = arr.clone();
            start = System.nanoTime();
            mergeSort(mergeArr, 0, mergeArr.length - 1);
            end = System.nanoTime();
            System.out.println("Merge Sort: " + (end - start) / 1_000_000.0 + " ms");

            // Quick Sort
            int[] quickArr = arr.clone();
            start = System.nanoTime();
            quickSort(quickArr, 0, quickArr.length - 1);
            end = System.nanoTime();
            System.out.println("Quick Sort: " + (end - start) / 1_000_000.0 + " ms");

            System.out.println("-----------------------------------");
        }
    }

    // Generate random array
    public static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = rand.nextInt(n * 10);
        return arr;
    }

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // already sorted
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
