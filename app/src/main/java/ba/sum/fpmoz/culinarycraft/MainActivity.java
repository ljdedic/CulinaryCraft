package ba.sum.fpmoz.culinarycraft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

    public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView recyclearView;
    MainAdapter mainAdapter;
    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance("https://culinarycraft-3ce71-default-rtdb.europe-west1.firebasedatabase.app/");

        @Override
        protected void onStart() {
            super.onStart();
            mainAdapter.startListening();
        }

        @Override
        protected void onStop() {
            super.onStop();
            mainAdapter.stopListening();
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.recyclearView = (RecyclerView)findViewById(R.id.rv);
        this.recyclearView.setLayoutManager(new LinearLayoutManager(this));



        FirebaseRecyclerOptions<Mainmodel> options = new FirebaseRecyclerOptions.Builder<Mainmodel>().setQuery(
                this.mDatabase.getReference("jela"),
                Mainmodel.class
        ).build();

        this.mainAdapter = new MainAdapter(options);
        this.recyclearView.setAdapter(mainAdapter);






        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, AddRecipeActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "Sada možete dodati jelo", Toast.LENGTH_SHORT).show();
            }
        });

    }
}