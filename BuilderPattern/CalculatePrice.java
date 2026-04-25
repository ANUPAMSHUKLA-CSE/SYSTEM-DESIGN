package org.example;

public class CalculatePrice {
    private final TravelPackage travel;

    public CalculatePrice(TravelPackage travel) {
        this.travel = travel;
    }

    public int calculate() {
        int sum = travel.getBasePrice();
        int days = travel.getDuration();

        String mode = travel.getTravelMode();
        if (mode != null) {
            if (mode.equalsIgnoreCase("bus")) sum += 1200;
            else if (mode.equalsIgnoreCase("train")) sum += 900;
            else if (mode.equalsIgnoreCase("plane")) sum += 10000;
        }

        String meal = travel.getMealPlan();
        if (meal != null) {
            if (meal.equalsIgnoreCase("all")) sum += 1500 * days;
            else if (meal.equalsIgnoreCase("breakfast")) sum += 800 * days;
            else if (meal.equalsIgnoreCase("lunch")) sum += 1200 * days;
            else if (meal.equalsIgnoreCase("dinner")) sum += 1500 * days;
        }

        if (travel.getAdventureActivities() != null) {
            for (String k : travel.getAdventureActivities()) {
                if (k.equalsIgnoreCase("Scuba Diving")) sum += 1000;
                else if (k.equalsIgnoreCase("Swimming")) sum += 2000;
                else if (k.equalsIgnoreCase("Camping")) sum += 500;
            }
        }

        if (travel.isTravelInsuranceIncluded()) sum += 2000;

        return sum;
    }
}
