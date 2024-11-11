import javax.naming.LimitExceededException;

public class Main {
    public static void main(String[] args) {
        Route firstRoute = new Route("Medina","Riyadh",233);
        Route secondRoute = new Route("Makkah","Medina",102);

        Car bus = new Car("WM-01",firstRoute,49);
        Car miniBus = new Car("WA-01",secondRoute,0);

        Passenger[] passengers = {new Subscribers_passengers("Waleed","1012041285"),new Non_Subscribers_passengers("Mohammed","1002412421",true)};

        try {
            passengers[0].reserveCar(bus);
            passengers[1].reserveCar(miniBus);
        }catch (LimitExceededException e){
            System.out.println(e.getMessage());
        }
        System.out.println();

        for (Passenger p : passengers){
            System.out.println(p.displayInformation());
            System.out.println();
        }


        //let Mohammed reserve in the bus
        try {
            passengers[1].reserveCar(bus);
        }catch (LimitExceededException e){
            System.out.println(e.getMessage());
        }

        System.out.println(passengers[1].displayInformation());
        System.out.println();

        //remove Mohammed's coupon
        ((Non_Subscribers_passengers) passengers[1]).setDiscountCoupon(false);
        System.out.println(passengers[1].displayInformation());
    }
}