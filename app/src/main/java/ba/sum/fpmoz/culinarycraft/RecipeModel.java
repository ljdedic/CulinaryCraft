package ba.sum.fpmoz.culinarycraft;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.Map;

public class RecipeModel {
    private String imejela;

    private String txtpotrebnovrijeme;
    private int brojporcija;
    private String urlslike;

    public RecipeModel() {}

    public RecipeModel(String imejela,String txtpotrebnovrijeme, int brojporcija, String urlslike){
        this.imejela = imejela;
        this.txtpotrebnovrijeme = txtpotrebnovrijeme;
        this.brojporcija = brojporcija;
        this.urlslike = urlslike;

    }

    public String getImejela() {
        return imejela;
    }

    public void setImejela(String imejela) {
        this.imejela = imejela;
    }

    public String getTxtpotrebnovrijeme() {
        return txtpotrebnovrijeme;
    }

    public void setTxtpotrebnovrijeme(String txtpotrebnovrijeme) {
        this.txtpotrebnovrijeme = txtpotrebnovrijeme;
    }

    public int getBrojporcija() {
        return brojporcija;
    }

    public void setBrojporcija(int brojporcija) {
        this.brojporcija = brojporcija;
    }

    public String getUrlslike() {
        return urlslike;
    }

    public void setUrlslike(String urlslike) {
        this.urlslike = urlslike;
    }

    public void saveToFirebase() {
        DatabaseReference recipesRef = FirebaseDatabase.getInstance().getReference("jelo");
        String recipeKey = recipesRef.push().getKey();
        recipesRef.child(recipeKey).setValue(this);
    }

}

