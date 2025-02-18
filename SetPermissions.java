import java.io.File;

public class SetPermissions {
    public static void main(String[] args) {
        File f = new File(args[0]);
        String newperms=args[1];

        f.setReadable(newperms.charAt(0) == 'r');
        f.setWritable(newperms.charAt(1) == 'w');
        f.setExecutable(newperms.charAt(2) == 'x');
    }
}
