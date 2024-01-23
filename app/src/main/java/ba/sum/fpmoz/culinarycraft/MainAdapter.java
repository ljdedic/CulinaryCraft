package ba.sum.fpmoz.culinarycraft;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends FirebaseRecyclerAdapter<Mainmodel, MainAdapter.myViewHolder> {

    public MainAdapter(@NonNull FirebaseRecyclerOptions<Mainmodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull Mainmodel model) {
        holder.brojporcija.setText(model.getBrojporcija());
        holder.imejela.setText(model.getImejela());
        holder.potrebnisastojci.setText(model.getPotrebnisastojci());
        holder.potrebnovrijeme.setText(model.getPotrebnovrijeme());
        holder.upute.setText(model.getUpute());

        Glide.with(holder.img.getContext())
                .load(model.getSurl())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recipe_card, parent, false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        CircleImageView img;
        TextView brojporcija, imejela, potrebnisastojci, potrebnovrijeme, upute;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.dodavanjeslike);
            brojporcija = itemView.findViewById(R.id.brojporcija);
            imejela = itemView.findViewById(R.id.imejela);
            potrebnisastojci = itemView.findViewById(R.id.potrebnisastojci);
            potrebnovrijeme = itemView.findViewById(R.id.potrebnovrijeme);
            upute = itemView.findViewById(R.id.upute);
        }
    }
}