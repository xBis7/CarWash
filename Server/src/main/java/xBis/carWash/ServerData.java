package xBis.carWash;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import javafx.application.Platform;

public class ServerData {
    
    private String plate;
    private String vehicle;
    private String serviceType;
    private int serviceVal;
    private int price;

    public HashMap <Integer, ServiceList> services = new HashMap<>();

    /**
     * ServerData class constructor with no parameters
     * creates a hashmap containing all the services and their prices
     */
    public ServerData(){
        ServiceList listItem0 = new ServiceList("Exterior Washing", 7, 8, 6);
        ServiceList listItem1 = new ServiceList("Interior Cleaning", 6, 7, 0);
        ServiceList listItem2 = new ServiceList("Interior + Exterior", 12, 14, 0);
        ServiceList listItem3 = new ServiceList("Exterior Special", 9, 10, 8);
        ServiceList listItem4 = new ServiceList("Interior Special", 8, 9, 0);
        ServiceList listItem5 = new ServiceList("Interior + Exterior Special", 15, 17, 0);
        ServiceList listItem6 = new ServiceList("Biological Interior Cleaning", 80, 80, 0);
        ServiceList listItem7 = new ServiceList("Waxing + Shining", 80, 90, 40);
        ServiceList listItem8 = new ServiceList("Engine Cleaning", 20, 20, 10);
        ServiceList listItem9 = new ServiceList("Under Car Body Washing", 3, 3, 0);
        
        services.put(0, listItem0);
        services.put(1, listItem1);
        services.put(2, listItem2);
        services.put(3, listItem3);
        services.put(4, listItem4);
        services.put(5, listItem5);
        services.put(6, listItem6);
        services.put(7, listItem7);
        services.put(8, listItem8);
        services.put(9, listItem9);
 
    }

    public String getPlate(){
        return plate;
    }

    public void setPlate(String plate){
        this.plate = plate;
    }

    public String getVehicle(){
        return vehicle;
    }

    public void setVehicle(String vehicle){
        this.vehicle = vehicle;
    }

    public String getServiceType(){
        return serviceType;
    }

    public void setServiceType(String serviceType){
        this.serviceType = serviceType;
    }

    public void setServiceVal(int serviceVal){
        this.serviceVal = serviceVal;
    }

    public int getPrice(){
        ServiceList serList = services.get(serviceVal);
        if(vehicle.equals("Sedan")){
            price = serList.getSedanPrice();
        }
        else if(vehicle.equals("SUV")){
            price = serList.getSuvPrice();
        }
        else{
            price = serList.getMotorPrice();
        }
        return price;
    }

    /**
     * receiveInfo method to connect the client to the same port as the clients
     * and an endless while loop to keep accepting client connections
     * calling ClientHandler class
     */
    public void receiveInfo(){       
        ServerSocket sSocket = null;
    
        try{
            sSocket=new ServerSocket(8000);
            //establish connection to client socket
            sSocket.setReuseAddress(true);
                
            while(true){        
                Socket cSocket = sSocket.accept();
                ClientHandler clientSocket = new ClientHandler(cSocket);
                Thread acceptClient = new Thread(clientSocket);
                acceptClient.setDaemon(true);
                acceptClient.start();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            if(sSocket != null){
                try {
                    sSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
