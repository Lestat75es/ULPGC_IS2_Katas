package histograma;

import java.util.HashMap;

public class CalculaHistograma {

    private final int[] vector;
    private HashMap<Integer, Integer> hmap;

    public HashMap<Integer, Integer> getHmap() {
        return hmap;
    }

    public int[] getVector() {
        return vector;
    }

    public CalculaHistograma(int[] vector) {
        this.vector = vector;
    }

    public void execute() {
        hmap = new HashMap<>();
        int n;
        for (int i = 0; i < vector.length; i++) {
            if (hmap.containsKey(vector[i])) {
                n = hmap.get(vector[i]);
            } else {
                n = 0;
            }
            hmap.put(vector[i], n + 1);
        }

    }
};
