package histograma;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Histograma {

    public static void main(String[] args) throws FileNotFoundException {

        String pathName = "E:\\ULPGC\\Ingeniería del Software II\\p3\\Histograma4\\emailsfilev1.txt";

        Histogram<String> histogram = new Histogram<>();
        MailReader mailReader = new MailReader(pathName);
        ArrayList<String> domis = mailReader.getArrayList();
        for (String domi : domis) {
            histogram.increment(domi.split("@")[1]);
        }
        HistogramDisplay histogramDisplay = new HistogramDisplay(histogram);
        histogramDisplay.execute();
    }
}
