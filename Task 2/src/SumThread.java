public class SumThread extends Thread {
    private int[] numbers;
    private int start;
    private int end;
    private long sum;

    public SumThread(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        // Include start, but stop before end so each number is counted once.
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
    }

    public long getSum() {
        return sum;
    }
}
