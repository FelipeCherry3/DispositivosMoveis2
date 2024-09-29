package com.facens.atividadedm2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facens.atividadedm2.model.Local;

import java.io.Serializable;
import java.util.List;

public class LocalAdapter extends RecyclerView.Adapter<LocalAdapter.ViewHolder> {

    private List<Local> locais;
    private Context context;

    public LocalAdapter(List<Local> localList, Context context) {
        this.locais = localList;
        this.context = context;
    }

    @NonNull
    @Override
    public LocalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_local, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LocalAdapter.ViewHolder holder, int position) {
        Local local = locais.get(position);
        holder.textViewName.setText(local.getNome());
        holder.imageView.setImageResource(local.getImageResourceId());

        holder.buttonSaibaMais.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("local", local);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return locais.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        ImageView imageView;
        Button buttonSaibaMais;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            imageView = itemView.findViewById(R.id.imageView);
            buttonSaibaMais = itemView.findViewById(R.id.buttonSaibaMais);
        }
    }
}
