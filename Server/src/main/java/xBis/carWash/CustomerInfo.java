package xBis.carWash;

/**
 * CustomerInfo class 
 * used for defining the data in the list of the TableView items
 */
public class CustomerInfo {
    
    private String plate;
    private String vehicle;
    private String serviceType;
    private int price;
    private String dateTime;

    public CustomerInfo(String plate, String serviceType, String vehicle, int price, String dateTime){
        this.plate = plate;
        this.serviceType = serviceType;
        this.vehicle = vehicle;
        this.price = price;
        this.dateTime = dateTime;
    }

    public String getDateTime() {
        return dateTime;
    }

    public int getPrice() {
        return price;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getVehicle() {
        return vehicle;
    }

    public String getPlate() {
        return plate;
    }

}
