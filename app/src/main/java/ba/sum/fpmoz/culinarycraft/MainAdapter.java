package ba.sum.fpmoz.culinarycraft;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;


public class MainAdapter extends FirebaseRecyclerAdapter<Mainmodel, MainAdapter.myViewHolder> {
    Context cxt;

    public MainAdapter(@NonNull FirebaseRecyclerOptions<Mainmodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull Mainmodel model) {
        holder.brojporcija.setText(String.valueOf(model.getBrojporcija()));
        holder.imejela.setText(model.getImejela());
        holder.potrebnovrijeme.setText(model.getPotrebnovrijeme());

        Picasso
                .get()
                .load(model.getSlika())
                .into(holder.img);

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_popup))
                        .setExpanded(true,1700)
                        .create();

                //dialogPlus.show();

                View view = dialogPlus.getHolderView();

                EditText imejela = view.findViewById(R.id.txtjela);
                EditText potrebnovrijeme = view.findViewById(R.id.txtpotrebnovrijeme);
                EditText brojporcija = view.findViewById(R.id.txtbrojporcija);
                EditText slika = view.findViewById(R.id.txtnazivslike);

                Button btnUpdate = view.findViewById(R.id.btnUpdate);


                imejela.setText(model.getImejela());
                potrebnovrijeme.setText(model.getPotrebnovrijeme());
                brojporcija.setText(String.valueOf(model.getBrojporcija()));
                slika.setText(model.getSlika());

                dialogPlus.show();

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("imejela",imejela.getText().toString());
                        map.put("potrebnovrijeme",potrebnovrijeme.getText().toString());
                        map.put("brojporcija",brojporcija.getText().toString());
                        map.put("slika",slika.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("jela")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.imejela.getContext(), "Ažuriranje podataka uspješno.", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(holder.imejela.getContext(), "Pogreška tjekom anžuriranja.", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                });

                    }
                });


            }
        });
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.cxt = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recipe_card, parent, false);
        return new myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView brojporcija, imejela, potrebnovrijeme;

        Button btnEdit,btnDelete;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imageView_food);
            brojporcija = itemView.findViewById(R.id.brojporcija);
            imejela = itemView.findViewById(R.id.imejela);
            potrebnovrijeme = itemView.findViewById(R.id.txtpotrebnovrijeme);

            btnEdit = (Button)itemView.findViewById(R.id.btnEdit);
            btnDelete = (Button)itemView.findViewById(R.id.btnDelete);
        }
    }
}