package histograma;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Histograma {

    public static void main(String[] args) throws FileNotFoundException {

        String pathName = "E:\\ULPGC\\Ingeniería del Software II\\p3\\Histograma4\\emailsfilev1.txt";

        MailReader mailReader = new MailReader(pathName);
        ArrayList<String> domis = mailReader.getArrayList();
        Histogram<String> histogram = DominioHistogramBuilder.execute(domis);

        HistogramDisplay histogramDisplay = new HistogramDisplay(histogram);
        histogramDisplay.execute();
    }
}
