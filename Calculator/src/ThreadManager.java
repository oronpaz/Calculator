public class ThreadManager {

    public static void run() throws InterruptedException {

        double[] successRate = new double[1];
        double crystal1;
        double crystal2;

        Thread t1 = new Thread(new ThreadCalcRunnable("Crystal 1", successRate));

        Thread t2 = new Thread(new ThreadCalcRunnable("Crystal 2", successRate));


        t1.start();
        t1.join();
        crystal1 = successRate[0];

        t2.start();
        t2.join();
        crystal2 = successRate[0];

        ThreadCalcRunnable.printBestCrystal(crystal1, crystal2);
    }
}
