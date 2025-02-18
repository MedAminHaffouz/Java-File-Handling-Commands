import java.io.File;

public class IsHidden {
    public static void main(String[] args) {
        File file = new File(args[0]);
        if (file.exists()) {
            if (file.isHidden()){
                System.out.println("File is hidden");
            }
            else{
                System.out.println("File is not hidden");
            }
        }
    }
}
