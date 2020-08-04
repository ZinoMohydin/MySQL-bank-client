package Repository;

import Table.Konto;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class KontoRep {

    public static ArrayList<Konto> konto = new ArrayList<>();

    Properties prop = new Properties();
    InputStream input = null;
    String url = null;
    String name = null;
    String password = null;
    ResultSet rows = null;
    Connection connection = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;

    public void loggaKontoDB() {


        try {
            input = new FileInputStream("C:/Nackademin Mahmud/MySQL3/src/Info");
            prop.load(input);

            url = prop.getProperty("url");
            name = prop.getProperty("name");
            password = prop.getProperty("password");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, name, password);
            statement = connection.createStatement();

            rows = statement.executeQuery("select * from konto");

            while (rows.next()) {
                Konto k = new Konto();
                k.setKontonummer(rows.getInt("kontonummer"));
                k.setKontotyp(rows.getString("kontotyp"));
                k.setKundnummer(rows.getInt("kundnummer"));
                k.setSaldo(rows.getInt("saldo"));
                konto.add(k);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                connection.close();
                statement.close();
                rows.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Konto valjKontoTyp(int kundnummer) {

        Konto konto = new Konto();

        try {
            input = new FileInputStream("C:/Nackademin Mahmud/MySQL3/src/Info");
            prop.load(input);

            url = prop.getProperty("url");
            name = prop.getProperty("name");
            password = prop.getProperty("password");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, name, password);
            preparedStatement = connection.prepareStatement("select * from konto" +
                    " where kundnummer = ?");
            preparedStatement.setInt(1, kundnummer);

            rows = preparedStatement.executeQuery();

            while (rows.next()) {
                konto.setKundnummer(rows.getInt("kundnummer"));
                konto.setKontotyp(rows.getString("kontotyp"));
                konto.setKontonummer(rows.getInt("kontonummer"));
                konto.setSaldo(rows.getInt("saldo"));

                System.out.println("Välj ett konto: " + konto.getKontotyp() + " - Din saldo: " + konto.getSaldo());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                connection.close();
                rows.close();
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return konto;
    }
}