package histograma;

import java.io.FileNotFoundException;

public class Histograma {

    public static void main(String[] args) throws FileNotFoundException {

        String pathName = "E:\\ULPGC\\Ingeniería del Software II\\p3\\Histograma4\\emailsfilev1.txt";

        MailReader mailReader = new MailReader(pathName);
        Histogram<String> histogram = MailHistogramBuilder.execute(mailReader.getArrayList());

        HistogramDisplay histogramDisplay = new HistogramDisplay(histogram);
        histogramDisplay.execute();
    }
}
