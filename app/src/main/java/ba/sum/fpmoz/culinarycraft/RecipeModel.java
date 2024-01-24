package ba.sum.fpmoz.culinarycraft;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.Map;

public class RecipeModel {
    private String dodajjelo;
    private String imejela;
    private String potrebnisastojci;
    private String potrebnovrijeme;
    private int brojporcija;
    private String upute;

    public RecipeModel() {}

    public RecipeModel(String dodajjelo, String imejela,String potrebnisastojci, String potrebnovrijeme,int brojporcija, String upute){
        this.dodajjelo = dodajjelo;
        this.imejela = imejela;
        this.potrebnisastojci = potrebnisastojci;
        this.potrebnovrijeme = potrebnovrijeme;
        this.brojporcija = brojporcija;
        this.upute = upute;
    }

    public String getDodajjelo() {
        return dodajjelo;
    }

    public void setDodajjelo(String dodajjelo) {
        this.dodajjelo = dodajjelo;
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

    public int getBrojporcija() {
        return brojporcija;
    }

    public void setBrojporcija(int brojporcija) {
        this.brojporcija = brojporcija;
    }

    public String getUpute() {
        return upute;
    }

    public void setUpute(String upute) {
        this.upute = upute;
    }
    public void saveToFirebase() {
        DatabaseReference recipesRef = FirebaseDatabase.getInstance().getReference("jelo");
        String recipeKey = recipesRef.push().getKey();
        recipesRef.child(recipeKey).setValue(this);
    }

}

