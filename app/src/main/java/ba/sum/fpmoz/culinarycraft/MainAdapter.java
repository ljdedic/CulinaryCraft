package ba.sum.fpmoz.culinarycraft;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;


public class MainAdapter extends FirebaseRecyclerAdapter<Mainmodel, MainAdapter.myViewHolder> {
    Context cxt;

    public MainAdapter(@NonNull FirebaseRecyclerOptions<Mainmodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull Mainmodel model) {
        holder.brojporcija.setText(model.getBrojporcija());
        holder.imejela.setText(model.getImejela());
        holder.potrebnovrijeme.setText(model.getPotrebnovrijeme());

        Picasso
                .get()
                .load(model.getSlika())
                .into(holder.img);
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

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.dodavanjeslike);
            brojporcija = itemView.findViewById(R.id.brojporcija);
            imejela = itemView.findViewById(R.id.imejela);
            potrebnovrijeme = itemView.findViewById(R.id.potrebnovrijeme);
        }
    }
}