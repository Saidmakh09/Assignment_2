import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Performance {

    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("performance_report.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            int[] arraySizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};
            int iterations = 20;


            SortingAlgorithm[] sortingAlgorithms = {
                    new BubbleSort(),
                    new QuickSort(),
                    new MergeSort(),
                    new InsertionSort(),
                    new SelectionSort(),
                    new ShellSort()

            };


            for (SortingAlgorithm algorithm : sortingAlgorithms) {
                Tester tester = new Tester(algorithm);

                printWriter.println("Sorting algorithm - " + algorithm.getClass().getSimpleName());
                printWriter.println();

                System.out.println("Sorting algorithm - " + algorithm.getClass().getSimpleName());
                System.out.println();

                for (int size : arraySizes) {
                    double totalTime = 0;

                    for (int i = 0; i < iterations; i++) {
                        totalTime += tester.singleTest(size);
                    }

                    double averageTime = totalTime / iterations;

                    printWriter.println("Sorted " + size + " elements in " + averageTime + " milliseconds (avg)");
                    System.out.println("Sorted " + size + " elements in " + averageTime + " milliseconds (avg)");
                }

                printWriter.println();
                System.out.println();
            }

            printWriter.close();
            System.out.println("Performance report generated successfully.");

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
