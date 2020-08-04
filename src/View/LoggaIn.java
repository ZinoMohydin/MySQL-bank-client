package View;

import Repository.KontoRep;
import Repository.KundRep;
import Table.Konto;
import Table.Kund;

import java.util.Scanner;

public class LoggaIn {

    private Kund kund = new Kund();
    private KundRep kundRep = new KundRep();
    Scanner sc = new Scanner(System.in);
    private Konto konto = new Konto();
    private KontoRep kontoRep = new KontoRep();

    public void LoggaIn() {

        System.out.println("Skriv in ditt namn");
        String namn = sc.nextLine().trim();
        System.out.println("Skriv in din PIN-kod");
        String s = sc.nextLine().trim();
        int pin = Integer.parseInt(s);
        kund = kundRep.loggaKund(namn, pin);

        if (kund.getNamn() == null) {
            System.out.println("Du har angett fel namn eller PIN");
            LoggaIn();
        } else if (kund.kollaPin(pin)) {
            System.out.println("Du är inloggad som " + kund.getNamn() + " " + kund.getPersonnummer() + "\n");
        }
    }

    public void ValjKonto(){

        kontoRep.loggaKontoDB();
        kontoRep.valjKontoTyp(kund.getKundnummer());
        String val = sc.nextLine().trim();



        if (val.equals("Privatkonto")) {
            System.out.println("hej " + konto.getSaldo());
            System.out.println("Du har " + konto.getSaldo() + ":- " + " hur mycket vill du dra ut?");
        }

        else if (val.equals("Sparkonto")){
            System.out.println("Du har " + konto.getKontotyp() + ":- " + " hur mycket vill du dra ut?");
        }
         else {
            System.out.println("Välj ett konto igen");
            kontoRep.valjKontoTyp(kund.getKundnummer());
        }

    }
}