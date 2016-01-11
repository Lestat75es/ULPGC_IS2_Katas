package kata4;

import java.io.File;

public class Kata4 {

    public static void main(String[] args) {
        String path = "C:\\";
        File file = new File(path);
        print(file.listFiles(), "");
    }

    private static void print(File[] listFiles, String ident) {
        if (listFiles == null) {
            return;
        }

        for (File listFile : listFiles) {
            System.out.println(ident + (listFile.isDirectory() ? "+" : " ") + listFile.getName());
            if (!listFile.isHidden() && listFile.isDirectory()) {
                print(listFile.listFiles(), ident + " ");
            }
        }
    }
}
