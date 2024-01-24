package ba.sum.fpmoz.culinarycraft;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import ba.sum.fpmoz.culinarycraft.RecipeModel;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddRecipeActivity extends AppCompatActivity {
    FirebaseStorage storage;
    StorageReference storageReference;
    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance("https://culinarycraft-3ce71-default-rtdb.europe-west1.firebasedatabase.app/");


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

        DatabaseReference usersDbref = mDatabase.getReference("jela");

        recepiesaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imejela = addnamedihTxt.getText().toString();
                String potrebnisastojci = addingrediansTxt.getText().toString();
                String potrebnovrijeme = addingrediansTxt.getText().toString();
                String brojporcija = addportionsInt.getText().toString();
                String upute = adddirectionTxt.getText().toString();
                AddRecipeActivity r = new AddRecipeActivity();
                usersDbref.push().setValue(r);
                Intent i = new Intent(AddRecipeActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        //NE RADIIII!!!!
        //Button updateRecepie = findViewById(R.id.btnuredi);
        //updateRecepie.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {
               // ModelRecept updatedRecepie = new ModelRecept(imejela, potrebnisastojci,potrebnovrijeme,brojporcija,upute);
          //  }
        //});

        //NE RADIIIII!!!!!
        //Button deleteRecepie = findViewById(R.id.btnizbrisi);

        //deleteRecepie.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {
           //     finish();
         //   }
       // });
    }
}