package Repository;

import Table.Kund;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class KundRep {

    Properties prop = new Properties();
    InputStream input = null;
    String url = null;
    String name = null;
    String password = null;
    ResultSet rows = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    public Kund loggaKund(String namn, int pin) {

        Kund kund = new Kund();

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
            preparedStatement = connection.prepareStatement("select * from kund" +
                    " where NAMN = ? and PIN = ?");
            preparedStatement.setString(1, namn);
            preparedStatement.setInt(2, pin);

            rows = preparedStatement.executeQuery();

            while (rows.next()) {
                kund.setKundnummer(rows.getInt("kundnummer"));
                kund.setNamn(rows.getString("namn"));
                kund.setPersonnummer(rows.getInt("personnummer"));
                kund.setPin(rows.getInt("pin"));
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
        return kund;
    }
}