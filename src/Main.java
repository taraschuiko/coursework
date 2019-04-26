import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Matrix matrix = new Matrix();
        matrix.readFromFile("matrix.txt");
        matrix.print();
        matrix.sort();
        matrix.print();
        additionalTask(matrix.getMatrix());
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

        BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write("Середнє парних елементів: " + averageOfEvenElements);
        writer.close();
    }
}
