package main;

public class AsphaltCar extends RallyCar {
    private double suspentionTravel;

    public AsphaltCar(String make, String model, int horsepower, double suspentionTravel) {
        super(make, model, horsepower);
        this.suspentionTravel = suspentionTravel;
    }
    public double getSuspentionTravel() {
        return suspentionTravel;
    }
    //the method calc performance is overriden 
    @Override
    public double calculatePerformance() {
        // Implementation for asphalt car performance calculation
        return getHorsepower() - (suspentionTravel * 2.24);
    }
}
