import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Move {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Usage: java Move <source_file> <destination_file>");
            return;
        }

        File sourceFile = new File(args[0]);
        File destinationFile = new File(args[1]);

        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0] + " doesn't exist");
            return;
        }

        if (!sourceFile.canRead()) {
            System.out.println("Source file " + args[0] + " cannot be read");
            return;
        }

        if (destinationFile.exists()) {
            System.out.println("Destination file " + args[1] + " already exists. Overwrite? (yes/no)");
            String response = System.console().readLine().toLowerCase();
            if (!response.equals("yes")) {
                System.out.println("Move operation canceled.");
                return;
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destinationFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

            if (sourceFile.delete()) {
                System.out.println("File moved successfully to: " + args[1]);
            } else {
                System.out.println("File copied successfully, but could not delete the source file.");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
