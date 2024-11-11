public class Route {
    private String pickUpAddress;
    private String destinationAddress;
    private double tripPrice;

    public Route(String pickUpAddress, String destinationAddress, double tripPrice) {
        this.pickUpAddress = pickUpAddress;
        this.destinationAddress = destinationAddress;
        this.tripPrice = tripPrice;
    }

    public String getPickUpAddress() {
        return pickUpAddress;
    }

    public void setPickUpAddress(String pickUpAddress) {
        this.pickUpAddress = pickUpAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public double getTripPrice() {
        return tripPrice;
    }

    public void setTripPrice(double tripPrice) {
        this.tripPrice = tripPrice;
    }
}
