package ba.sum.fpmoz.culinarycraft;

public class Mainmodel {

    String brojporcija,imejela,potrebnisastojci,potrebnovrijeme,upute;

    Mainmodel()
    {

    }

    public Mainmodel(String brojporcija, String imejela, String potrebnisastojci, String potrebnovrijeme, String upute) {
        this.brojporcija = brojporcija;
        this.imejela = imejela;
        this.potrebnisastojci = potrebnisastojci;
        this.potrebnovrijeme = potrebnovrijeme;
        this.upute = upute;
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

    public String getPotrebnisastojci() {
        return potrebnisastojci;
    }

    public void setPotrebnisastojci(String potrebnisastojci) {
        this.potrebnisastojci = potrebnisastojci;
    }

    public String getPotrebnovrijeme() {
        return potrebnovrijeme;
    }

    public void setPotrebnovrijeme(String potrebnovrijeme) {
        this.potrebnovrijeme = potrebnovrijeme;
    }

    public String getUpute() {
        return upute;
    }

    public void setUpute(String upute) {
        this.upute = upute;
    }
}
