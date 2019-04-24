import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileGenerator {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("N = ");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.print("M = ");
        int m = Integer.parseInt(scanner.nextLine());
        System.out.print("min = ");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.print("max = ");
        int max = Integer.parseInt(scanner.nextLine());

        String matrix = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int randomNumber = min + (int) (Math.random() * (max - min + 1));
                matrix += randomNumber + " ";
            }
            matrix += "\n";
        }

        File file = new File("matrix.txt");
        file.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter("matrix.txt"));
        writer.write(matrix);
        writer.close();
    }
}
