import javax.naming.LimitExceededException;

public class Non_Subscribers_passengers extends Passenger{
    private boolean discountCoupon;

    public Non_Subscribers_passengers(String name, String id, boolean discountCoupon) {
        super(name, id);
        this.discountCoupon = discountCoupon;
    }

    public boolean isDiscountCoupon() {
        return discountCoupon;
    }

    public void setDiscountCoupon(boolean discountCoupon) {
        this.discountCoupon = discountCoupon;
        if (getReservedCar()!=null){
            if (isDiscountCoupon())
                setTripCost(getReservedCar().getRoute().getTripPrice()-(getReservedCar().getRoute().getTripPrice()*.1));
            else
                setTripCost(getReservedCar().getRoute().getTripPrice());
        }
    }

    @Override
    void reserveCar(Car myCar) throws LimitExceededException {
        if (myCar.getMaxCapacity()==0)
            throw new LimitExceededException("Sorry "+getName()+", but this trip is fully booked");

        setReservedCar(myCar);
        if (isDiscountCoupon())
            setTripCost(getReservedCar().getRoute().getTripPrice()-(getReservedCar().getRoute().getTripPrice()*.1));
        else
            setTripCost(getReservedCar().getRoute().getTripPrice());
    }

    @Override
    String displayInformation() {
        if (getReservedCar()==null){
            return super.displayInformation();
        }

        return super.displayInformation()+"\nTrip cost: $"+getTripCost() + " our subscribers enjoy a 50% discount on all their trips (Click here) to see our subscription plans.\nReserved car code: "+getReservedCar().getCode()+"\nRoute price: $"+getReservedCar().getRoute().getTripPrice()+"\nFrom: "+getReservedCar().getRoute().getPickUpAddress()+"\nTo: "+getReservedCar().getRoute().getDestinationAddress();
    }
}
