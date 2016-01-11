package kata4;

import java.io.File;

public class Kata4 {

    public static void main(String[] args) {
        String path = "C:\\";
        File file = new File(path);
        String[] files = file.list();
        System.out.println(files.length);
        for (String f : files) {
            System.out.println(f);
        }
    }
}
