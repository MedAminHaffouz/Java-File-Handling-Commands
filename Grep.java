import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Grep {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Usage: java Grep <pattern> <input_files>...");
            return;
        }

        String pattern = args[0];

        for (int i = 1; i < args.length; i++) {
            File file = new File(args[i]);

            if (!file.exists()) {
                System.out.println("File " + args[i] + " doesn't exist");
                continue;
            }

            if (!file.canRead()) {
                System.out.println("File " + args[i] + " cannot be read");
                continue;
            }

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                int lineNumber = 1;
                while ((line = br.readLine()) != null) {
                    if (line.contains(pattern)) {
                        if (args.length > 2) {
                            System.out.println(args[i] + ":" + lineNumber + ":" + line);
                        } else {
                            System.out.println(line);
                        }
                    }
                    lineNumber++;
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + args[i]);
            }
        }
    }
}
