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

        @Override
        protected void onStart() {
            super.onStart();
        }

        @Override
        protected void onStop() {
            super.onStop();
        }

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclearView = (RecyclerView)findViewById(R.id.rv);
        recyclearView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<Mainmodel> options =
                new FirebaseRecyclerOptions.Builder<Mainmodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("jela"), Mainmodel.class)
                        .build();

        mainAdapter = new MainAdapter(options);
        recyclearView.setAdapter(mainAdapter);




        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Add_recipe_activity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "Sada možete dodati jelo", Toast.LENGTH_SHORT).show();
            }
        });

    }
}