import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Diff {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Usage: java Diff <file1> <file2>");
            return;
        }

        try (BufferedReader br1 = new BufferedReader(new FileReader(args[0]));
             BufferedReader br2 = new BufferedReader(new FileReader(args[1]))) {

            String line1, line2;
            int lineNumber = 1;
            boolean filesAreEqual = true;

            while ((line1 = br1.readLine()) != null | (line2 = br2.readLine()) != null) {
                if (line1 == null || line2 == null || !line1.equals(line2)) {
                    System.out.println("Difference at line " + lineNumber + ":");
                    System.out.println("< " + (line1 != null ? line1 : "EOF"));
                    System.out.println("> " + (line2 != null ? line2 : "EOF"));
                    filesAreEqual = false;
                }
                lineNumber++;
            }

            if (filesAreEqual) {
                System.out.println("Files are identical.");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
