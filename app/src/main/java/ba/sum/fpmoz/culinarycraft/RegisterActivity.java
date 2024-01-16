package ba.sum.fpmoz.culinarycraft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;



public class RegisterActivity extends AppCompatActivity {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText registerNameTxt = findViewById(R.id.unesiemail);
        EditText registerLastNameTxt = findViewById(R.id.);
        EditText registerEmailTxt = findViewById(R.id.unesieemail);
        EditText registerPassword = findViewById(R.id.lo_lozinka);
        EditText registerButton= findViewById(R.id.btnregistracija);
        Butoon = findViewById(R.id.btnprijavise);



        btnregistracija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String UnesiimeTxt = Unesiime.getText().toString();
                final String UnesiprezimeTxt = Unesiprezime.getText().toString();
                final String UnesiemailTxt = Unesiemail.getText().toString();
                final String UnesilozinkuTxt = Unesilozinku.getText().toString();

                //probjera da li se sve popunjeno prije registracije
                if(UnesiimeTxt.isEmpty() || UnesiprezimeTxt.isEmpty() || UnesiemailTxt.isEmpty() ||  UnesilozinkuTxt.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Molim Vas popunite sva mjesta!!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        TextView btn=findViewById(R.id.Većimateračun);
        btn_prijavi_se.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}