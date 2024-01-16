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

import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText loginEmailTxt = findViewById(R.id.unesiemail);
        EditText loginPasswordTxt= findViewById(R.id.unesiprezime);

        Button loginBtn = findViewById(R.id.btnprijavise);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginEmailTxt.getText().toString();
                String password = loginPasswordTxt.getText().toString();
                if (email.isEmpty() || password.isEmpty()){
                    Toast.makeText(getBaseContext(), "Ne smijete ostaviti prazno polje!", Toast.LENGTH_SHORT).show();
                }else{
                    mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                Toast.makeText(getBaseContext(), "Uspješna prijava!" , Toast.LENGTH_SHORT).show();
                                Intent movieIntent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(movieIntent);
                                finish();
                            }else{
                                Toast.makeText(getBaseContext(),"Pogrešno unešeni podaci!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        TextView btn=findViewById(R.id.btn_registriraj_se);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });

    }
}