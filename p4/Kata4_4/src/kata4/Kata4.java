package kata4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class Kata4 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String path = "C:\\Users\\usuario\\Documents";
        File file = new File(path);
        File[] fileList = file.listFiles();
        print(fileList, "");

        String from = "C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg";
        String to = "C:\\pub\\tmp\\Koala.jpg";

        BufferedInputStream input = new BufferedInputStream(new FileInputStream(new File(from)));
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(new File(to)));
        Date date = new Date();

        while (true) {
            int read = input.read();
            if (read < 0) {
                break;
            }
            output.write(read);
        }
        System.out.println(new Date().getTime() - date.getTime() + "ms");

        input.close();
        output.close();
    }

    private static void print(File[] fileList, String ident) {
        if (fileList == null) {
            return;
        }

        for (File file : fileList) {
            System.out.println(ident + (file.isDirectory() ? "+" : " ") + file.getName());
            if (!file.isHidden() && file.isDirectory()) {
                print(file.listFiles(), ident + " ");
            }
        }
    }
}
