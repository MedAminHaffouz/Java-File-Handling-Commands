import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCount {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: java WordCount <file>");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String line;
            int lineCount = 0, wordCount = 0, charCount = 0;

            while ((line = br.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }

            System.out.println("Lines: " + lineCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Characters: " + charCount);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
