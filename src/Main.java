import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Matrix a = new Matrix();
        a.readFromFile("Data.txt");
        a.print();
        a.sort();
        a.print();
        additionalTask(a.getMatrix());
    }

    private static void additionalTask(int[][] matrix) throws IOException {
        int countEvenElements = 0;
        int sumOfEvenElements = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] % 2 == 0) {
                    countEvenElements++;
                    sumOfEvenElements += matrix[i][j];
                }
            }
        }

        int averageOfEvenElements = sumOfEvenElements / countEvenElements;

        System.out.println("Середнє парних елементів: " + averageOfEvenElements);

        FileWriter fileWriter = new FileWriter("Data.txt");
        fileWriter.write("Середнє парних елементів: " + averageOfEvenElements);
        fileWriter.close();
    }
}
