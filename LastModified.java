import java.io.File;

public class LastModified {
    public static void main(String[] args) {
        File f = new File(args[0]);
        System.out.println(f.lastModified());
    }
}
