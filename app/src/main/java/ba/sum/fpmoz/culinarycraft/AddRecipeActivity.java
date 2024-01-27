package ba.sum.fpmoz.culinarycraft;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import ba.sum.fpmoz.culinarycraft.RecipeModel;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class AddRecipeActivity extends AppCompatActivity {
    FirebaseStorage storage;
    StorageReference storageReference;
    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mRef = mDatabase.getReference();


    Button selectImageBtn;
    Button uploadImageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        //EditText adddishTxt = findViewById(R.id.dodajjelo);
        EditText addnamedihTxt = findViewById(R.id.imejela);
        EditText addingrediansTxt = findViewById(R.id.potrebnisastojci);
        EditText addtimeTxt = findViewById(R.id.potrebnovrijeme);
        EditText addportionsInt = findViewById(R.id.brojporcija);
        EditText adddirectionTxt = findViewById(R.id.upute);

        Button addButton = findViewById(R.id.dodajsliku);
        Button recepiesaveButton = findViewById(R.id.spremi);

        DatabaseReference recepiesRef = mRef.child("jela");

        recepiesaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String imejela = addnamedihTxt.getText().toString();
                final String potrebnisastojci = addingrediansTxt.getText().toString();
                final String potrebnovrijeme = addingrediansTxt.getText().toString();
                final String brojporcija = addportionsInt.getText().toString();
                final String upute = adddirectionTxt.getText().toString();

                HashMap<String, Object> recipeDta = new HashMap<>();
                recipeDta.put("imejela", imejela);
                recipeDta.put("potrebnisastojci", potrebnisastojci);
                recipeDta.put("potrebnovrijeme", potrebnovrijeme);
                recipeDta.put("brojporcija", brojporcija);
                recipeDta.put("upute", upute);


                recepiesRef.push().setValue(recipeDta).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(AddRecipeActivity.this, "Recept uspješno dodan!", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(AddRecipeActivity.this, "Recept neuspješno dodan!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}