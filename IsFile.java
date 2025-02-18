import java.io.File;

public class IsFile {
    public static void main(String[] args) {
        File f = new File(args[0]);
        System.out.println(f.isFile());
    }
}
