import java.io.File;

public class RenameTo {
    public static void main(String[] args) {
        File f = new File(args[0]);
        String newName=args[1];
        boolean b = f.renameTo(new File(args[1]));
    }
}
