package Table;

public class Transaktion {

    private int transnummer;
    private int saldoandra;
    private int kontonummer;

    public Transaktion(int transnummer, int saldoandra, int kontonummer) {

        this.transnummer = transnummer;
        this.saldoandra = saldoandra;
        this.kontonummer = kontonummer;
    }

    public Transaktion() {
    }

    public int getTransnummer() {
        return transnummer;
    }

    public void setTransnummer(int transnummer) {
        this.transnummer = transnummer;
    }

    public int getSaldoandra() {
        return saldoandra;
    }

    public void setSaldoandra(int saldoandra) {
        this.saldoandra = saldoandra;
    }

    public int getKontonummer() {
        return kontonummer;
    }

    public void setKontonummer(int kontonummer) {
        this.kontonummer = kontonummer;
    }
}
