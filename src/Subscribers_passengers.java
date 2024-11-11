import javax.naming.LimitExceededException;

public class Subscribers_passengers extends Passenger{
    final static double discount = .5;

    public Subscribers_passengers(String name, String id) {
        super(name, id);
    }

    @Override
    void reserveCar(Car myCar) throws LimitExceededException {
        if (myCar.getMaxCapacity()==0)
            throw new LimitExceededException("Sorry "+getName()+", but this trip is fully booked");

        setReservedCar(myCar);

        getReservedCar().setMaxCapacity(getReservedCar().getMaxCapacity()-1);


        setTripCost(getReservedCar().getRoute().getTripPrice()-(getReservedCar().getRoute().getTripPrice()*discount));
    }

    @Override
    String displayInformation() {
        if (getReservedCar()==null){
            return super.displayInformation();
        }

        return super.displayInformation() +"\nTrip cost: $"+getTripCost()+ "\nReserved car code: "+getReservedCar().getCode()+"\nRoute price: $"+getReservedCar().getRoute().getTripPrice()+"\nFrom: "+getReservedCar().getRoute().getPickUpAddress()+"\nTo: "+getReservedCar().getRoute().getDestinationAddress();
    }
}
