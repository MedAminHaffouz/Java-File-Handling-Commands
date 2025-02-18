import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Cat {
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: java Cat <input_files>... <output_file>");
            return;
        }

        if (args.length==1){
            File f = new File(args[0]);

            if (!f.exists()) {
                System.out.println("File doesn't exist");
                return;
            }

            if (!f.canRead()) {
                System.out.println("File cannot be read");
                return;
            }

            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        if (args.length == 2) {
            File f = new File(args[0]);

            if (!f.exists()) {
                System.out.println("File doesn't exist");
                return;
            }

            if (!f.canRead()) {
                System.out.println("File cannot be read");
                return;
            }

            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        else {
            String outputFile = args[args.length - 1];
            File outFile = new File(outputFile);

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outFile))) {
                for (int i = 0; i < args.length - 1; i++) {
                    File f = new File(args[i]);

                    if (!f.exists()) {
                        System.out.println("File " + args[i] + " doesn't exist");
                        return;
                    }

                    if (!f.canRead()) {
                        System.out.println("File " + args[i] + " cannot be read");
                        return;
                    }

                    try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            bw.write(line);
                            bw.newLine();
                        }
                    } catch (IOException e) {
                        System.out.println("Error reading file: " + args[i]);
                    }
                }
                System.out.println("Contents concatenated and written to: " + outputFile);
            } catch (IOException e) {
                System.out.println("Error writing to output file: " + outputFile);
            }
        }
    }
}

