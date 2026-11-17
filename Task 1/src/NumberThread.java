public class NumberThread extends Thread {
    private long first;
    private int end;
    private NumberPrinter printer;

    public NumberThread(String name, int start, int end, boolean odd, NumberPrinter printer) {
        super(name);
        this.first = start;
        this.end = end;
        this.printer = printer;

        // Move to the first number belonging to this thread.
        boolean startIsOdd = start % 2 != 0;
        if (startIsOdd != odd) {
            first++;
        }
    }

    @Override
    public void run() {
        try {
            for (long number = first; number <= end; number += 2) {
                printer.print(number, getName());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
