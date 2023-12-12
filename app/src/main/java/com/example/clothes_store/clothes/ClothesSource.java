package com.example.clothes_store.clothes;

import java.util.ArrayList;
import java.util.List;

public class ClothesSource {
    public static List<Clothing> getClothes(){
        List<Clothing> clothes = new ArrayList<>();
        clothes.add(new Clothing("Shirt", 20.00, 20, "Bulgaria"));
        clothes.add(new Clothing("Shorts", 25.00, 23, "Turke"));
        clothes.add(new Clothing("Jeans", 30.00, 22, "Taiwan"));
        clothes.add(new Clothing("Pants", 30.00, 25, "China"));
        clothes.add(new Clothing("Underwear", 5.00, 30, "Germany"));
        clothes.add(new Clothing("Shoes", 100.00, 35, "USA"));

        return clothes;
    }
}
