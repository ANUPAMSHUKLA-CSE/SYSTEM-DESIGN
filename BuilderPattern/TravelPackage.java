package org.example;

import java.util.List;

public class TravelPackage {
    private final String destination;
    private final int duration;
    private final int basePrice;
    //OPTIONAL fields
    private final String travelMode;
    private final String mealPlan;
    private final List<String> adventureActivities;
    private final boolean isTravelInsuranceIncluded;

    private TravelPackage(TravelPackageBuilder builder) {
        this.destination = builder.destination;
        this.duration = builder.duration;
        this.basePrice = builder.basePrice;
        this.adventureActivities = builder.adventureActivities;
        this.travelMode = builder.travelMode;
        this.mealPlan = builder.mealPlan;
        this.isTravelInsuranceIncluded = builder.isTravelInsuranceIncluded;
    }

    public String getDestination() { return destination; }
    public int getDuration() { return duration; }
    public int getBasePrice() { return basePrice; }
    public String getTravelMode() { return travelMode; }
    public String getMealPlan() { return mealPlan; }
    public List<String> getAdventureActivities() { return adventureActivities; }
    public boolean isTravelInsuranceIncluded() { return isTravelInsuranceIncluded; }

    @Override
    public String toString() {
        return "TravelPackage{destination='" + destination + "', duration=" + duration +
                ", basePrice=" + basePrice + ", travelMode='" + travelMode +
                "', mealPlan='" + mealPlan + "', activities=" + adventureActivities +
                ", insurance=" + isTravelInsuranceIncluded + "}";
    }

    public static class TravelPackageBuilder {
        private final String destination;
        private final int duration;
        private final int basePrice;
        private String travelMode;
        private String mealPlan;
        private List<String> adventureActivities;
        private boolean isTravelInsuranceIncluded;

        public TravelPackageBuilder(String destination, int duration, int basePrice) {
            this.destination = destination;
            this.duration = duration;
            this.basePrice = basePrice;
        }

        public TravelPackageBuilder travelMode(String travelMode) {
            this.travelMode = travelMode;
            return this;
        }

        public TravelPackageBuilder mealPlan(String mealPlan) {
            this.mealPlan = mealPlan;
            return this;
        }

        public TravelPackageBuilder adventureActivities(List<String> adventureActivities) {
            this.adventureActivities = adventureActivities;
            return this;
        }

        public TravelPackageBuilder isTravelInsuranceIncluded(boolean isTravelInsuranceIncluded) {
            this.isTravelInsuranceIncluded = isTravelInsuranceIncluded;
            return this;
        }

        public TravelPackage build() {
            return new TravelPackage(this);
        }
    }
}
