import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] numbers = new int[100000];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100); // Random number from 0 to 99.
        }

        int cores = Runtime.getRuntime().availableProcessors();
        SumThread[] threads = new SumThread[cores];

        // Divide the array into parts of almost equal size.
        for (int i = 0; i < cores; i++) {
            int start = i * numbers.length / cores;
            int end = (i + 1) * numbers.length / cores;
            threads[i] = new SumThread(numbers, start, end);
            threads[i].start();
        }

        long total = 0;
        for (SumThread thread : threads) {
            thread.join(); // Wait before reading this thread's result.
            total += thread.getSum();
        }

        System.out.println("Threads: " + cores);
        System.out.println("Total sum: " + total);
    }
}
