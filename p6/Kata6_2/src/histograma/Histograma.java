package histograma;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Histograma {

    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, SQLException {

        System.out.println("Inicio");
        String pathName = "emailsfilev1.txt";
        //Hacer las clases estáticas
        MailReader mailReader = new MailReader(pathName);
        ArrayList<Person> domis = mailReader.getArrayList();
        ArrayList<Person1> domis1 = PersonLoader.read();
        System.out.println(domis1.size());
        HistogramaBuilder<Person> builder = new HistogramaBuilder(domis);

        HistogramaBuilder<Person1> builder1 = new HistogramaBuilder(domis1);

        Histogram<String> domains = builder.build(new Attribute<Person, String>() {

            @Override
            public String get(Person item) {
                return item.getMail();
            }
        });

        Histogram<String> domains1 = builder1.build(new Attribute<Person1, String>() {

            @Override
            public String get(Person1 item) {
                return item.getMail().split("@")[1];
            }
        });

        Histogram<Float> pesos = builder1.build(new Attribute<Person1, Float>() {

            @Override
            public Float get(Person1 item) {
                return item.getPeso();
            }
        });

        Histogram<Character> letters = builder.build(new Attribute<Person, Character>() {

            @Override
            public Character get(Person item) {
                return item.getMail().charAt(0);
            }
        });

        new HistogramDisplay(domains, "Dominios").execute();
        new HistogramDisplay(letters, "Caracter").execute();
        new HistogramDisplay(domains1, "Dominios").execute();
        new HistogramDisplay(pesos, "Pesos").execute();
        System.out.println("Fin");
    }
}
