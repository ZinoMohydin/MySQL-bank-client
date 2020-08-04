package Table;

public class Konto {

    private int kontonummer;
    private String kontotyp;
    private int saldo;
    private int kundnummer;

    public Konto(int kontonummer, String kontotyp, int saldo, int kundnummer) {

        this.kontonummer = kontonummer;
        this.kontotyp = kontotyp;
        this.saldo = saldo;
        this.kundnummer = kundnummer;
    }

    public Konto() {
    }

    public int getKontonummer() {
        return kontonummer;
    }

    public void setKontonummer(int kontonummer) {
        this.kontonummer = kontonummer;
    }

    public String getKontotyp() {
        return kontotyp;
    }

    public void setKontotyp(String kontotyp) {
        this.kontotyp = kontotyp;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getKundnummer() {
        return kundnummer;
    }

    public void setKundnummer(int kundnummer) {
        this.kundnummer = kundnummer;
    }
}
