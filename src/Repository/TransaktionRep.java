package Repository;

import Table.Transaktion;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class TransaktionRep {

    Properties prop = new Properties();
    InputStream input = null;
    String url = null;
    String name = null;
    String password = null;
    ResultSet rows = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    public Transaktion taUt(int kundnummer, int kontonummer, int saldoandra) {

        Transaktion transaktion = new Transaktion();

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
            preparedStatement = connection.prepareStatement("select * from transaktion inner join konto ko on transaktion.KONTONUMMER = ko.KONTONUMMER inner join kund k on ko.KUNDNUMMER = k.KUNDNUMMER " +
                    " where k.kundnummer = ? and kontonummer = ? and saldoandra = ?");
            preparedStatement.setInt(1, kundnummer);
            preparedStatement.setInt(2, kontonummer);
            preparedStatement.setInt(3, saldoandra);

            rows = preparedStatement.executeQuery();

            while (rows.next()) {
                transaktion.setTransnummer(rows.getInt("transnummer"));
                transaktion.setSaldoandra(rows.getInt("saldoandra"));
                transaktion.setKontonummer(rows.getInt("kontonummer"));

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
        return transaktion;
    }
}