import java.io.File;

public class IsDirectory {
    public static void main(String[] args) {
        File f=new File(args[0]);
        if (f.isDirectory()){
            System.out.println("It is a directory");
        }
        else{
            System.out.println("It is a file");
        }
    }
}
