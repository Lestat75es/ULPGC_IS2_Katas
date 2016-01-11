package paquete;

public class Principal {

    public static void main(String[] args) {
        Integer[] vector = {1};
        //String [] vector1 = {"1","2","3","pepe"};

        Histogram<Integer> histogram = CalculaHistograma.calcHisto(vector);
        System.out.println("ww");
        for (Object key : histogram.keySet()) {

            System.out.println("key" + key + "->" + histogram.get(key));
        }
    }
}
