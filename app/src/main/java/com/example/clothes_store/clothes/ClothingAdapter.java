package com.example.clothes_store.clothes;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clothes_store.R;

import java.util.List;

public class ClothingAdapter extends RecyclerView.Adapter<ClothingViewHolder> implements ClothingClickListener {

    private final List<Clothing> clothes;

    public ClothingAdapter(List<Clothing> clothes) {
        this.clothes = clothes;
    }

    @NonNull
    @Override
    public ClothingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View shopView = inflater.inflate(R.layout.clothing, parent, false);
        return new ClothingViewHolder(shopView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClothingViewHolder holder, int position) {
        Clothing clothing = clothes.get(position);
        holder.setPrice(clothing.getPrice());
        holder.setType(clothing.getType());

        holder.itemView.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putInt("pos", position);
            bundle.putParcelable("clothing", clothing);
            ClothingDialogFragment fragment = ClothingDialogFragment.newInstance(bundle);
            fragment.setListener(this);
            FragmentManager manager = ((AppCompatActivity) view.getContext()).getSupportFragmentManager();
            fragment.show(manager, "ClothingDialogFragment");
        });
    }

    @Override
    public int getItemCount() {
        return clothes.size();
    }



    @Override
    public void updateItem(int position, Clothing clothing) {
        clothes.set(position, clothing);
        notifyItemChanged(position);
    }
}
