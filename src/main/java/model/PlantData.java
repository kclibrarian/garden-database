package model;

import java.util.ArrayList;

public class PlantData {


    /**
     * Returns the results of searching the Jobs data by field and search term.
     *
     * For example, searching for employer "Enterprise" will include results
     * with "Enterprise Holdings, Inc".
     *
     * @param column Plant field that should be searched.
     * @param value Value of the field to search for.
     * @param allPlants The list of plants to search.
     * @return List of all plants matching the criteria.
     */
    public static ArrayList<Plant> findByColumnAndValue(String column, String value, Iterable<Plant> allPlants) {

        ArrayList<Plant> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<Plant>) allPlants;
        }

        if (column.equals("all")){
            results = findByValue(value, allPlants);
            return results;
        }
        for (Plant plant : allPlants) {

            String aValue = getFieldValue(plant, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(plant);
            }
        }

        return results;
    }

    public static String getFieldValue(Plant plant, String fieldName){
        String theValue;
        if (fieldName.equals("plant")){
            theValue = plant.getName();
        } else if (fieldName.equals("Color")){
            theValue = plant.getColor().toString();
        } else if (fieldName.equals("Height")){
            theValue = plant.getHeight().toString();
        } else {
            theValue = plant.getMonth().toString();
        }

        return theValue;
    }

    /**
     * Search all Job fields for the given term.
     *
     * @param value The search term to look for.
     * @param allPlants The list of jobs to search.
     * @return      List of all jobs with at least one field containing the value.
     */
    public static ArrayList<Plant> findByValue(String value, Iterable<Plant> allPlants) {
        String lower_val = value.toLowerCase();

        ArrayList<Plant> results = new ArrayList<>();

        for (Plant plant : allPlants) {

            if (plant.getName().toLowerCase().contains(lower_val)) {
                results.add(plant);
            } else if (plant.getColor().toString().toLowerCase().contains(lower_val)) {
                results.add(plant);
            } else if (plant.getMonth().toString().toLowerCase().contains(lower_val)) {
                results.add(plant);
            } else if (plant.getHeight().toString().toLowerCase().contains(lower_val)) {
                results.add(plant);
            } else if (plant.toString().toLowerCase().contains(lower_val)) {
                results.add(plant);
            }

        }

        return results;
    }


}

