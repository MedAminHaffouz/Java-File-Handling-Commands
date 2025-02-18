import java.io.File;

public class ExistFile {
    public static void main(String[] args) {
        File f=new File(args[0]);
        if (f.exists()) {
            System.out.println("File exist");
        }
        else {
            System.out.println("File doesn't exist");
        }
    }
}
