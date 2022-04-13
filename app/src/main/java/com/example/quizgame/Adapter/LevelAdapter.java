package com.example.quizgame.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizgame.Activity.MainActivity;
import com.example.quizgame.Model.Levels;
import com.example.quizgame.R;

import java.util.List;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Levels> levels;

    public LevelAdapter(Context context, List<Levels> items) {
        this.levels = items;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_level, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Levels levels = this.levels.get(position);
        holder.nameView.setText(levels.getName());
        holder.descriptionView.setText(levels.getDescription());
        holder.image.setImageResource(levels.getImage());
        holder.stars.setImageResource(levels.getLevelRating());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), levels.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return levels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, descriptionView;
        final ImageView image, stars;

        ViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.iv_image);
            stars = view.findViewById(R.id.ivLevelStatus);
            nameView = view.findViewById(R.id.name);
            descriptionView = view.findViewById(R.id.description);
        }
    }
}