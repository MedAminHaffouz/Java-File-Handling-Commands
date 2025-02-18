import java.io.File;

public class SizeFile {
    public static void main(String[] args) {
        File f = new File(args[0]);
        System.out.println(f.length());
    }
}
