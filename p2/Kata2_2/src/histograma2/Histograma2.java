package histograma2;

public class Histograma2 {

    public static void main(String[] args) {
        Integer[] vector = {1, 2, 3, 4, 4, 6, 7};
        CalculaHistograma histo = new CalculaHistograma(vector);
        histo.execute();
        for (Object clave : histo.getHistograma().keySet()) {
            System.out.println("Valor: " + clave.toString() + " -->" + histo.getHistograma().get(clave).toString() + " veces");
        }
    }
}
