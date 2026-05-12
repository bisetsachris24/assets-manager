package com.pluralsight;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Asset> myAssets = new ArrayList<>();

        myAssets.add(new House(
                "my house",
                "2015-06-12",
                225000.00,
                "123 Amani Street, Dallas",
                1,        // excellent
                2200,     // square feet
                8000      // lot size
        ));


    }
}
