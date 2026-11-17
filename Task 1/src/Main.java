import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Start number: ");
        int start = scanner.nextInt();
        System.out.print("End number: ");
        int end = scanner.nextInt();

        if (start > end) {
            System.out.println("Start must be less than or equal to end.");
            return;
        }

        NumberPrinter printer = new NumberPrinter(start);
        NumberThread odd = new NumberThread("Odd Thread", start, end, true, printer);
        NumberThread even = new NumberThread("Even Thread", start, end, false, printer);
        odd.start();
        even.start();

        // Wait until both threads finish.
        odd.join();
        even.join();
        System.out.println("Printing complete.");
    }
}
