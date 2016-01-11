package kata5vm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Kata5vm {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        try {
            //Class.forName("org.sqlite.JDBC");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@10.22.143.90:1521:orcl", "system", "orcl");
            Statement state = c.createStatement();
            ResultSet rs = state.executeQuery("select * from mail;");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("MAIL: " + rs.getString("mail"));
            }

            String fileName = "src//emailsfilev1.txt";
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
            String mail = null;
            while ((mail = reader.readLine()) != null) {
                String query = "Insert into mail (mail) values ('" + mail + "')";
                state.executeUpdate(query);
            }
            rs.close();
            state.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Kata5vm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
