public class Main {
    public static void main(String[] args) {
        //Let n be an integer given as a command line argument. Validate the argument!
        long startTime = System.nanoTime();
        try{
           Integer.parseInt(args[0]);
        }catch(NumberFormatException e){
            System.out.println("Something went wrong.");
        }
        int n = Integer.parseInt(args[0]);
        int ok = 1;
        if(n>100)
            ok = 0;
        //Create a n x n Latin Square as a matrix, having as symbols numbers from 1 to n.

        int[][] latinSquareMatrix = new int[n][n];
        int i, j;
        for(i = 0; i < latinSquareMatrix.length; i++)
            latinSquareMatrix[0][i] = i+1;
        int aux;
        for(i = 1; i < latinSquareMatrix.length; i++) {
            aux = latinSquareMatrix[i-1][n-1];
            latinSquareMatrix[i][0] = aux;
            for (j = 1; j < latinSquareMatrix.length; j++) {
                latinSquareMatrix[i][j] = latinSquareMatrix[i-1][j-1];
            }
        }
        if(ok == 1) {//afisez doar daca n este rezonabil
            for (i = 0; i < latinSquareMatrix.length; i++) {
                for (j = 0; j < latinSquareMatrix[i].length; j++) {
                    System.out.print(latinSquareMatrix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
        }
        /*
        For each line, and each column of the matrix, create and display on the screen String objects
        representing the concatenation of the symbols in the respective line or column.
         */
        for (i = 0; i < latinSquareMatrix.length; i++){
            String concatSybmLine = new String(Integer.toString(latinSquareMatrix[i][0]));
            for(j = 1; j < latinSquareMatrix.length; j++){
                concatSybmLine += latinSquareMatrix[i][j];
            }
            if(ok == 1)
                System.out.println(concatSybmLine);
        }
        System.out.println();

        for (j = 0; j < latinSquareMatrix.length; j++){
            String concatSybmColumn = new String(Integer.toString(latinSquareMatrix[0][j]));
            for(i = 1; i < latinSquareMatrix.length; i++){
                concatSybmColumn += latinSquareMatrix[i][j];
            }
            if (ok == 1)
                System.out.println(concatSybmColumn);

        }
        //For larger n display ONLY the running time of the application in nanoseconds or milliseconds.
        // Try n > 30_000. You might want to adjust the JVM Heap Space using the VM options -Xms4G -Xmx4G.

        System.out.println();
        System.out.println();
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);

    }
}