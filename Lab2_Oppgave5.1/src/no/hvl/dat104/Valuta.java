package no.hvl.dat104;

public class Valuta {
    private String kode;
    private String navn;

    public Valuta () {
        this.kode = "";
        this.navn = "";
    }
    public Valuta(String navn, String kode) {
        this.navn = navn;
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
