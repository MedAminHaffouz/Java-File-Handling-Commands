import java.io.File;

public class Remove {
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: java Remove <file_or_directory>...");
            return;
        }

        for (String path : args) {
            File file = new File(path);

            if (!file.exists()) {
                System.out.println("File or directory " + path + " doesn't exist");
                continue;
            }



            if (file.delete()) {
                System.out.println("File deleted: " + path);
            } else {
                System.out.println("Failed to delete file: " + path);
            }
            }
        }
    }
