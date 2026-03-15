package main;
//RallyCar is abstract because it has an abstract method 
// calculatePerformance() that must be implemented by subclasses.
public abstract class RallyCar {
    private String make;
    private String model;
    private int horsepower;

    public RallyCar(String make, String model, int horsepower){
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }
    public String getMake(){
        return make;
    }
    public String getModel(){
        return model;
    }
    public int getHorsepower(){
        return horsepower;
    }
    public abstract double calculatePerformance();
}