package histograma;

import java.util.ArrayList;

public class MailHistogramBuilder {

    public static Histogram<String> execute(ArrayList<String> mailList) {

        Histogram<String> histogram = new Histogram<>();
        for (String mail : mailList) {
            histogram.increment(new Mail(mail).getDominio());
        }
        return histogram;
    }
}
