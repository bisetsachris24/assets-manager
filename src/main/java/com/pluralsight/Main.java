package com.pluralsight;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Asset> myAssets = new ArrayList<>();
// adding 2 houses
        myAssets.add(new House(
                "my house",
                "2015-06-12",
                225000.00,
                "123 Amani Street, Dallas",
                1,        // excellent
                2200,     // square feet
                8000      // lot size
        ));

        myAssets.add(new House(
                " Beach home",
                "2019-08-03",
                180000.00,
                "47 Dallas  Drive, Hike Lake",
                2,        // good
                1500,     // square feet
                12000     // lot size
        ));

        // adding 2 vehicles
        myAssets.add(new Vehicle(
                "my car",
                "2022-04-20",
                28000.00,
                "Honda Accord",
                2022,
                45000
        ));

        myAssets.add(new Vehicle(
                "Chris's truck",
                "2016-11-09",
                35000.00,
                "Ford F-150",
                2014,
                145000
        ));
        // Loop through the Asset collection and display info
        for (int i = 0; i < myAssets.size(); i++) {
            Asset asset = myAssets.get(i);

            String typeDetail = "";
            if (asset instanceof House) {
                House house = (House) asset;
                typeDetail = "House at " + house.getAddress();
            } else if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset;
                typeDetail = "Vehicle: " + vehicle.getYear() + " " + vehicle.getMakeModel();
            }
            System.out.println("Description    : " + asset.getDescription());
            System.out.println("Detail         : " + typeDetail);
            System.out.println("Date Acquired  : " + asset.getDateAcquired());
            System.out.printf ("Original Cost  : $%,.2f%n", asset.getOriginalCost());
            System.out.printf ("Current Value  : $%,.2f%n", asset.getValue());
            System.out.println("-----------------------------------------------------");
        }
    }
}
