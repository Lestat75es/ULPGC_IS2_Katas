package paquete;

public class CalculaHistograma {

    public static <T> Histogram<T> calcHisto(T[] vector) {
        Histogram<T> histo = new Histogram<>();
        for (T key : vector) {
            histo.increment(key);
        }
        return histo;
    }
}
