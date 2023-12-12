package com.example.clothes_store.clothes;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Clothing implements Parcelable {
    private final String type;
    private double price;
    private int quantity;
    private String countryOfOrigin;

    public Clothing(String type, double price, int quantity, String countryOfOrigin) {
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.countryOfOrigin = countryOfOrigin;
    }

    protected Clothing(Parcel in) {
        type = in.readString();
        price = in.readDouble();
        quantity = in.readInt();
        countryOfOrigin = in.readString();
    }

    public static final Creator<Clothing> CREATOR = new Creator<Clothing>() {
        @Override
        public Clothing createFromParcel(Parcel in) {
            return new Clothing(in);
        }

        @Override
        public Clothing[] newArray(int size) {
            return new Clothing[size];
        }
    };

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(type);
        parcel.writeDouble(price);
        parcel.writeInt(quantity);
        parcel.writeString(countryOfOrigin);
    }
}
