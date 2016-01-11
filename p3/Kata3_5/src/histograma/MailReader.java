package histograma;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class MailReader {

    private final String pathName;

    public MailReader(String path) {
        this.pathName = path;
    }

    public ArrayList<String> getArrayList() {
        ArrayList<String> emailList = new ArrayList<>();

        try {
            BufferedReader fileIn = new BufferedReader(new FileReader(pathName));

            String mail;

            while ((mail = fileIn.readLine()) != null) {
                if (!mail.contains("@")) {
                    continue;
                }

                emailList.add(mail.split("@")[1]);
            }
        } catch (Exception e) {
            System.out.println("Fichero no existe " + e);
        }

        return emailList;
    }
}
