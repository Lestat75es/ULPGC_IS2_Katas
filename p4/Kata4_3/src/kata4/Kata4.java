package kata4;

import java.io.File;

public class Kata4 {

    public static void main(String[] args) {
        String path = "C:\\";
        File file = new File(path);
        File[] fileList = file.listFiles();
        print(fileList, "");
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
