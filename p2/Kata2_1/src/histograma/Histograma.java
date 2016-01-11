package histograma;

public class Histograma {

    public static void main(String[] args) {
        int[] vector = {1, 2, 3, 4, 5, 5, 7};
        CalculaHistograma histo = new CalculaHistograma(vector);
        histo.execute();
        System.out.println("Resultado:");

        for (Integer clave : histo.getHmap().keySet()) {
            System.out.println("Valor: " + clave.toString() + " -->" + histo.getHmap().get(clave).toString() + " veces");
        }
    }
}
