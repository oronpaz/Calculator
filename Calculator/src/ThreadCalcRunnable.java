public class ThreadCalcRunnable implements Runnable {

    private String name;
    final double[] values;

    public ThreadCalcRunnable(String name, double[] values){
         this.name = name;
         this.values = values;
    }

    public void run() {

        Calculator crystal = new Calculator(name);

        int numOfIterations = 20;
        int numOfSuccess = 0;

        System.out.println("Calculator " + name + ":");

        for (int i = 0; i < numOfIterations; i++) {

            double temp1 = Math.random();
            double temp2 = Math.random();

            double calc = crystal.add(temp1, temp2);

            System.out.print(temp1 + " + " + temp2 + " = " + calc);

            PrintSpaces(temp1, temp2);

            if (temp1+temp2 == calc) {
                System.out.println("(correct)");
                numOfSuccess++;
            }
            else
                System.out.println("(error)");
        }

        System.out.println("");

        values[0] = numOfSuccess / (double) numOfIterations;

    }

    private void PrintSpaces(Double temp1, Double temp2) {

        String spaces1 = temp1.toString();
        int numOfSpaces1 = spaces1.length();
        String spaces2 = temp2.toString();
        int numOfSpaces2 = spaces2.length();
        int totalNumOfSpaces = 42 - numOfSpaces1 - numOfSpaces2;

        for(int i = 0; i < totalNumOfSpaces; i++)
            System.out.print(" ");

    }

    public static void printBestCrystal(double crystal1, double crystal2){

        System.out.println("Crystal 1 Success rate: " + crystal1);
        System.out.println("Crystal 2 Success rate: " + crystal2);

        if(crystal1 > crystal2)
            System.out.println("Crystal 1 is better");
        else
            System.out.println("Crystal 2 is better");
    }
}
