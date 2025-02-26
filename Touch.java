import java.io.File;
import java.io.IOException;

public class Touch {
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: java Touch <file>...");
            return;
        }

        for (String filePath : args) {
            File file = new File(filePath);

            try {
                if (file.exists()) {
                    // Update the last modified timestamp
                    if (file.setLastModified(System.currentTimeMillis())) {
                        System.out.println("Updated timestamp: " + filePath);
                    } else {
                        System.out.println("Failed to update timestamp: " + filePath);
                    }
                } else {
                    // Create a new empty file
                    if (file.createNewFile()) {
                        System.out.println("Created file: " + filePath);
                    } else {
                        System.out.println("Failed to create file: " + filePath);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
