package ba.sum.fpmoz.culinarycraft.models;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class Recipe {
    public String title;
    public String porcion;
    public String time;
    public String ingredients;
    public String preparation;

    public Map<String, Float> ratings;

    public Recipe() {
    }

    public Recipe(String title, String porcion, String time, String ingredients, String preparation) {
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
}
