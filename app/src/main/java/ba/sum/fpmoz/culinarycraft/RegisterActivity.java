package ba.sum.fpmoz.culinarycraft;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance("https://culinarycraft-3ce71-default-rtdb.europe-west1.firebasedatabase.app/");
    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText registerNameTxt = findViewById(R.id.unesiemail);
        EditText registerLastNameTxt = findViewById(R.id.unesiprezime);
        EditText registerEmailTxt = findViewById(R.id.unesieemail);
        EditText registerPassword = findViewById(R.id.lo_lozinka);
        Button registerButton = findViewById(R.id.btnregistracija);
        TextView vecimateracun = findViewById(R.id.Većimateračun);

        DatabaseReference usersDbref = mDatabase.getReference("users");

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String UnesiimeTxt = registerNameTxt.getText().toString();
                final String UnesiprezimeTxt = registerLastNameTxt.getText().toString();
                final String UnesiemailTxt = registerEmailTxt.getText().toString();
                final String UnesilozinkuTxt = registerPassword.getText().toString();

                // Check if all fields are filled before registration
                if (UnesiimeTxt.isEmpty() || UnesiprezimeTxt.isEmpty() || UnesiemailTxt.isEmpty() || UnesilozinkuTxt.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Molim Vas popunite sva mjesta!!", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(UnesiemailTxt, UnesilozinkuTxt)
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                    usersDbref.child(userId).setValue(UnesiemailTxt +" "+ UnesilozinkuTxt);
                                    Toast.makeText(RegisterActivity.this, "uspjesno prijavljeno", Toast.LENGTH_SHORT).show();
                                    Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                                    startActivity(loginIntent);
                                    finish();
                                    // You can add additional actions here if needed
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(RegisterActivity.this, "Registracija nije uspjela. Molimo pokušajte ponovo.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        vecimateracun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginIntent);
                finish();
            }
        });
    }
}
