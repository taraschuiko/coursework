import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] matrix = readMatrix("text.txt");
        printMatrix(matrix);
        matrix = sortMatrix(matrix);
        printMatrix(matrix);
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
    }

    static int[][] sortMatrix(int[][] matrix) {
        // TODO: 2019-04-15 make matrix sorting
        return matrix;
    }

    static void additionalTask(int[][] matrix) {
        // TODO: 2019-04-15 make additional task: Середнє парних елементів
    }
}
