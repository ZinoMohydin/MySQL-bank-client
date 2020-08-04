package Table;

public class Kund {

    private int kundnummer;
    private String namn;
    private int personnummer;
    private int pin;

    public Kund(int kundnummer, String namn, int personnummer, int pin) {

        this.kundnummer = kundnummer;
        this.namn = namn;
        this.personnummer = personnummer;
        this.pin = pin;
    }

    public Kund() {
    }

    public int getKundnummer() {
        return kundnummer;
    }

    public void setKundnummer(int kundnummer) {
        this.kundnummer = kundnummer;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public int getPersonnummer() {
        return personnummer;
    }

    public void setPersonnummer(int personnummer) {
        this.personnummer = personnummer;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public boolean kollaPin(int pin) {
        boolean bool = false;
        if (this.pin == pin) {
            bool = true;
        }
        return bool;
    }
}
