package ba.sum.fpmoz.culinarycraft;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.Map;

public class RecipeModel {
    public String title;
    
    public String porcion;
    public String time;
    public String ingredients;
    public String preparation;

    public Map<String, Float> ratings;

    public RecipeModel() {


    }

    public RecipeModel(String title, String porcion, String time, String ingredients, String preparation) {
        this.title = title;
        this.porcion = porcion;
        this.time = time;
        this.ingredients = ingredients;
        this.preparation = preparation;
    }
    public float getAverageRating() {
        if (ratings == null || ratings.isEmpty()) {
            return 0;
        }
        float sum = 0;
        for (Float rating : ratings.values()) {
            sum += rating;
        }
        return sum / ratings.size();
    }
    public void saveToFirebase() {
        DatabaseReference recipesRef = FirebaseDatabase.getInstance().getReference("jelo");
        String recipeKey = recipesRef.push().getKey();
        recipesRef.child(recipeKey).setValue(this);
    }

}

