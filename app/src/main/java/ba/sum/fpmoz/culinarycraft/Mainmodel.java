package ba.sum.fpmoz.culinarycraft;

public class Mainmodel {
    String imejela, potrebnovrijeme, slika, brojporcija;

    Mainmodel() {
        // Default constructor
    }

    public Mainmodel(String brojporcija, String imejela, String potrebnovrijeme, String slika) {
        this.brojporcija = brojporcija;
        this.imejela = imejela;
        this.potrebnovrijeme = potrebnovrijeme;
        this.slika = slika;
    }

    public String getBrojporcija() {
        return brojporcija;
    }

    public void setBrojporcija(String brojporcija) {
        this.brojporcija = brojporcija;
    }

    public String getImejela() {
        return imejela;
    }

    public void setImejela(String imejela) {
        this.imejela = imejela;
    }

    public String getPotrebnovrijeme() {
        return potrebnovrijeme;
    }

    public void setPotrebnovrijeme(String potrebnovrijeme) {
        this.potrebnovrijeme = potrebnovrijeme;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }
}