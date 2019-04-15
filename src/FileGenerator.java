import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {
    public static void main(String[] args) throws IOException {
        int n = 8, m = 12;
        int min = 10, max = 45;

        String matrix = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int randomNumber = min + (int) (Math.random() * (max - min));
                matrix += randomNumber + " ";
            }
            matrix += "\n";
        }

        File file = new File("text.txt");
        file.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter("text.txt"));
        writer.write(matrix);
        writer.close();
    }
}
