import javax.naming.LimitExceededException;

public abstract class Passenger {
    private String name;
    private String id;
    private double tripCost;
    private Car reservedCar;

    public Passenger(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTripCost() {
        return tripCost;
    }

    public void setTripCost(double tripCost) {
        this.tripCost = tripCost;
    }

    public Car getReservedCar() {
        return reservedCar;
    }

    public void setReservedCar(Car reservedCar) {
        this.reservedCar = reservedCar;
    }

    abstract void reserveCar(Car myCar) throws LimitExceededException;

    String displayInformation(){
        return"Name: "+getName()+"\nid: "+getId();
    }

}
