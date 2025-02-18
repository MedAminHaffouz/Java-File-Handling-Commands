import java.io.File;

public class Find {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Usage: java Find <directory> <filename_pattern>");
            return;
        }

        File directory = new File(args[0]);
        String pattern = args[1];

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory: " + args[0]);
            return;
        }

        searchFiles(directory, pattern);
    }

    private static void searchFiles(File directory, String pattern) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchFiles(file, pattern); // Recursively search subdirectories
                } else if (file.getName().contains(pattern)) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}
