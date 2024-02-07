import java.util.Random;

public class Tester {
    private final SortingAlgorithm sortingAlgorithm;

    public Tester(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

//    public double singleTest(int size) {
//        int[] array = generateRandomArray(size);
//
//        long startTime = System.nanoTime();
//        sortingAlgorithm.sorty(array);
//        long endTime = System.nanoTime();
//
//        return (endTime - startTime) / 1e6;
//    }

    public double singleTest(int size) {
        int[] array = generateKSorted(size);

        long startTime = System.nanoTime();
        sortingAlgorithm.sorty(array);
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1e6;

    }





    public void test(int iterations, int size) {
        double totalTime = 0;

        for (int i = 0; i < iterations; i++) {
            double time = singleTest(size);
            totalTime += time;
            System.out.println("Iteration " + (i + 1) + ": " + time + " milliseconds");
        }

        double averageTime = totalTime / iterations;
        System.out.println("\nAverage time over " + iterations + " iterations for array size " + size +
                ": " + averageTime + " milliseconds");
    }

    private int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }

        return array;
    }

    int[] generateKSorted(int size) {
        Random random = new Random();
        int[] arr = new int[size];

        if (size < 10) {
            for (int i = 0; i < size; i++) {
                arr[i] = random.nextInt();
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (i < 10) {
                    arr[i] = random.nextInt();
                } else {
                    int rando = random.nextInt() + arr[i-10];
                    arr[i] = rando;
                }
            }
        }
        return arr;
    }
}



