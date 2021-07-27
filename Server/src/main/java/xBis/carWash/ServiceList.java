package xBis.carWash;

public class ServiceList {
    
    private String service;
    private int sedanPrice;
    private int suvPrice;
    private int motorPrice;

    public ServiceList(String service, int sedanPrice, int suvPrice, int motorPrice){
        this.service = service;
        this.sedanPrice = sedanPrice;
        this.suvPrice = suvPrice;
        this.motorPrice = motorPrice;
    }

    public String getService(){
        return service;
    }

    public int getSedanPrice(){
        return sedanPrice;
    }

    public int getSuvPrice(){
        return suvPrice;
    }

    public int getMotorPrice(){
        return motorPrice;
    }
}
