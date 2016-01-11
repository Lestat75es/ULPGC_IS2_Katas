package histograma;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Histograma {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Inicio");
        String pathName = "emailsfilev1.txt";

        MailReader mailReader = new MailReader(pathName);
        ArrayList<Person> domis = mailReader.getArrayList();
        HistogramaBuilder<Person> builder = new HistogramaBuilder(domis);

        Histogram<String> domains = builder.build(new Attribute<Person, String>() {

            @Override
            public String get(Person item) {
                return item.getMail();
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
        System.out.println("Fin");
    }
}
