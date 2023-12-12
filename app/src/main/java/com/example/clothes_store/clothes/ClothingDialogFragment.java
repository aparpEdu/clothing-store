package com.example.clothes_store.clothes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.clothes_store.R;


public class ClothingDialogFragment extends DialogFragment {

    private ClothingClickListener listener;

    public ClothingDialogFragment() {
    }


    public static ClothingDialogFragment newInstance(Bundle bundle) {
        ClothingDialogFragment fragment = new ClothingDialogFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView type = view.findViewById(R.id.typeView2);
        EditText price = view.findViewById(R.id.priceEdit);
        EditText quantity = view.findViewById(R.id.quantityEdit);
        EditText country = view.findViewById(R.id.countryEdit);
        Bundle bundle = getArguments();
        if (bundle != null) {
            Clothing clothing = bundle.getParcelable("clothing");
            if (clothing != null) {
                type.setText(clothing.getType());
                price.setText(String.valueOf(clothing.getPrice()));
                quantity.setText(String.valueOf(clothing.getQuantity()));
                country.setText(clothing.getCountryOfOrigin());
                view.findViewById(R.id.save).setOnClickListener(v -> {
                    clothing.setPrice(Double.parseDouble(price.getText().toString()));
                    clothing.setQuantity(Integer.parseInt(quantity.getText().toString()));
                    clothing.setCountryOfOrigin(country.getText().toString());
                    listener.updateItem(bundle.getInt("pos"), clothing);
                    dismiss();
                });
            }

        }
        view.findViewById(R.id.cancel).setOnClickListener(v ->  dismiss());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_clothing_dialog, container, false);
    }

    public void setListener(ClothingClickListener listener) {
        this.listener = listener;
    }
}