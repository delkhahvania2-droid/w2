package main;

public class GravelCar extends RallyCar {
    private int downforce;
    
    public GravelCar(String make, String model, int horsepower, int downforce) {
        //using super because the constructor of the parent class is being called to 
        // initialize the common attributes of the RallyCar class.
        super(make, model, horsepower);
        this.downforce = downforce;
    }
    
    public int getDownforce() {
        return downforce;
    }
    
    @Override
    public double calculatePerformance() {
    
         return getHorsepower() + (downforce * 0.29);
    }
    
}
