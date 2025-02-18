import java.io.File;

public class Permissions {
    public static void main(String[] args) {
        File f = new File(args[0]);
        boolean Exec=f.canExecute();
        boolean Red=f.canRead();
        boolean Write=f.canWrite();
        String res="";
        if (Exec) {
            res+="x";
        }
        else{res+="-";}
        if (Red) {
            res+="r";
        }
        else{res+="-";}
        if (Write) {
            res+="w";
        }
        else{res+="-";}
        System.out.println(res);
    }
}
