public class NumberPrinter {
    private long next;

    public NumberPrinter(int start) {
        next = start;
    }

    // Only one thread can use this method at a time.
    public synchronized void print(long number, String name) throws InterruptedException {
        while (number != next) {
            wait(); // Let the other thread print its number first.
        }
        System.out.println(name + ": " + number);
        next++;
        notifyAll(); // Wake the waiting thread so it can take its turn.
    }
}
