public class InsertionSort implements SortingAlgorithm {

    @Override
    public int[] sorty(int[] input) {
        insertionSort(input);
        return input;
    }


    private void insertionSort(int arr[]) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;


            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
}

