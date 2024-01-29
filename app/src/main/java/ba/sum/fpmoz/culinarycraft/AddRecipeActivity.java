package ba.sum.fpmoz.culinarycraft;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;

import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddRecipeActivity extends AppCompatActivity {

    EditText imejela, potrebnovrijeme, slika, brojporcija;
    Button btnnazad, spremi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        imejela = (EditText)findViewById(R.id.imejela1);
        potrebnovrijeme = (EditText)findViewById(R.id.txtpotrebnovrijeme1);
        slika = (EditText)findViewById(R.id.urlslike1);
        brojporcija = (EditText)findViewById(R.id.brojporcija1);

        spremi = (Button)findViewById(R.id.spremi);
        btnnazad = (Button)findViewById(R.id.btnnazad);

        spremi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
                clearAll();
            }
        });

        btnnazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddRecipeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
    private void insertData()
    {
        Map<String,Object> map = new HashMap<>();
        map.put("imejela",imejela.getText().toString());
        map.put("potrebnovrijeme",potrebnovrijeme.getText().toString());
        map.put("brojporcija",brojporcija.getText().toString());
        map.put("slika",slika.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("jela").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddRecipeActivity.this, "Podaci uspješno dodani.", Toast.LENGTH_SHORT).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddRecipeActivity.this, "Greška pri dodavanju.", Toast.LENGTH_SHORT).show();

                    }
                });
    }
    private void clearAll()
    {
        imejela.setText("");
        potrebnovrijeme.setText("");
        brojporcija.setText("");
        slika.setText("");
    }
}