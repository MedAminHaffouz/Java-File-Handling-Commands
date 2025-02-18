import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        
        if (args.length < 1) {
            System.out.println("Usage: java ListFiles <directory-path>");
            return;
        }

        
        File dir = new File(args[0]);

        
        if (dir.isDirectory()) {
            
            String[] fileList = dir.list();

            
            if (fileList != null) {
                
                for (String fileName : fileList) {
                    System.out.println(fileName);
                }
            } else {
                System.out.println("Cannot access the directory or it's empty.");
            }
        } else {
            System.out.println("The specified path is not a directory.");
        }
    }
}
