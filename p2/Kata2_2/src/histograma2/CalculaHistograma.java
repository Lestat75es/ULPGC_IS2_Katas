package histograma2;

import java.util.HashMap;

public class CalculaHistograma<T> {

    private final T[] vector;
    private HashMap<T, Integer> histograma;

    public T[] getVector() {
        return vector;
    }

    public HashMap<T, Integer> getHistograma() {
        return histograma;
    }

    public CalculaHistograma(T[] vector) {
        this.vector = vector;
    }

    public void execute() {
        histograma = new HashMap<>();
        int n;
        for (int i = 0; i < vector.length; i++) {
            if (histograma.containsKey(vector[i])) {
                n = histograma.get(vector[i]);
            } else {
                n = 0;
            }
            histograma.put(vector[i], n + 1);
        }
    }
}
