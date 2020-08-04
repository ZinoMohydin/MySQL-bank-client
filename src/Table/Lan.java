package Table;

public class Lan {

    private int lannummer;
    private int saldo;
    private int kundnummer;

    public Lan(int lannummer, int saldo, int kundnummer) {

        this.lannummer = lannummer;
        this.saldo = saldo;
        this.kundnummer = kundnummer;
    }

    public Lan() {
    }

    public int getLannummer() {
        return lannummer;
    }

    public void setLannummer(int lannummer) {
        this.lannummer = lannummer;
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
