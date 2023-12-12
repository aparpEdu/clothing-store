package com.example.clothes_store.clothes;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clothes_store.R;

public class ClothingViewHolder extends RecyclerView.ViewHolder {

    private final TextView type;
    private final TextView price;
    public ClothingViewHolder(@NonNull View itemView) {
        super(itemView);
        type = itemView.findViewById(R.id.typeView);
        price = itemView.findViewById(R.id.priceView);
    }

    public void setType(String type) {
        this.type.setText(type);
    }

    public void setPrice(double price) {
        this.price.setText(String.valueOf(price));
    }
}
