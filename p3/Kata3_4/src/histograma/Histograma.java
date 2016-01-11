package histograma;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Histograma {

    public static void main(String[] args) throws FileNotFoundException {

        Histogram<String> histogram = new Histogram<>();

        String pathName = "E:\\ULPGC\\Ingeniería del Software II\\p3\\Histograma4\\emailsfilev1.txt";
        try {
            BufferedReader fileIn = new BufferedReader(new FileReader(pathName));

            String mail;

            while ((mail = fileIn.readLine()) != null) {
                if (!mail.contains("@")) {
                    continue;
                }
                histogram.increment(mail.split("@")[1]);
            }
        } catch (Exception e) {
            System.out.println("Fichero no existe " + e);
        }
        HistogramDisplay histogramDisplay = new HistogramDisplay(histogram);
        histogramDisplay.execute();
    }
}
