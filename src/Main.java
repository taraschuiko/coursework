import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] matrix = readMatrix("matrix.txt");

        printMatrix(matrix);
        matrix = sortMatrix(matrix);
        printMatrix(matrix);
        additionalTask(matrix);
    }

    static int[][] readMatrix(String pathname) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("N = ");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.print("M = ");
        int m = Integer.parseInt(scanner.nextLine());
        System.out.print("min = ");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.print("max = ");
        int max = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][m];

        File file = new File(pathname);
        Scanner fileScanner = new Scanner(file);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = fileScanner.nextInt();
            }
        }

        return matrix;
    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int[][] sortMatrix(int[][] matrix) {
        int min = matrix[0][0];
        int max = matrix[0][0];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < min) min = matrix[i][j];
                if (matrix[i][j] > max) max = matrix[i][j];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            boolean hasMinOrMax = false;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == min || matrix[i][j] == max) {
                    hasMinOrMax = true;
                    break;
                }
            }

            if (hasMinOrMax) {
                for (int j = 1; j < matrix[0].length; j++) {
                    int temp = matrix[i][j];
                    for (int k = j; k > 0; k--) {
                        if (matrix[i][k-1] > temp) {
                            matrix[i][k] = matrix[i][k-1];
                            matrix[i][k-1] = temp;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        return matrix;
    }

    static void additionalTask(int[][] matrix) throws IOException {
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

        File file = new File("result.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write("Середнє парних елементів: " + averageOfEvenElements);
        writer.close();
    }
}
