class PrintTable {
    synchronized void printTwoTable() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + (2 * i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized void printFiveTable() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + (5 * i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TwoTableThread extends Thread {
    private PrintTable printTable;

    public TwoTableThread(PrintTable printTable) {
        this.printTable = printTable;
    }

    public void run() {
        printTable.printTwoTable();
    }
}

class FiveTableThread extends Thread {
    private PrintTable printTable;

    public FiveTableThread(PrintTable printTable) {
        this.printTable = printTable;
    }

    public void run() {
        printTable.printFiveTable();
    }
}

public class q16 {
    public static void main(String[] args) {
        PrintTable printTable = new PrintTable();
        
        // Create threads
        Thread twoTableThread = new TwoTableThread(printTable);
        Thread fiveTableThread = new FiveTableThread(printTable);

        // Start threads
        twoTableThread.start();
        fiveTableThread.start();

        // Wait for threads to finish
        try {
            twoTableThread.join();
            fiveTableThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Demonstrate daemon thread
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon Thread is running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        daemonThread.setDaemon(true);
        daemonThread.start();

        // Main thread ends here
    }
}
