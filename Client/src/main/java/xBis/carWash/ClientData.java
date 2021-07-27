package xBis.carWash;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

/**
 * ClientData class 
 * takes parameters from user input in GUI and stores it in private variables
 * services hashmap list of type ServiceList
 * variables access methods
 * method to send the variables to server
 */
public class ClientData {

    private String plate;
    private String vehicle;
    private int serviceVal;

    public HashMap <Integer, ServiceList> services;

    /**
     * ClientData class constructor
     * takes parameters from user input in GUI
     * 
     * @param plate         string licence plate     
     * @param vehicle       string vehicle type
     * @param serviceVal    value of service in the hashmap 
     */

    public ClientData(String plate, String vehicle, int serviceVal){
        this.plate = plate;
        this.vehicle = vehicle;
        this.serviceVal = serviceVal;

        services = new HashMap<>();

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

    public String getVehicle(){
        return vehicle;
    }

    public int getServiceVal(){
        return serviceVal;
    }

    /**
     * sentInfo() method
     * connects to port 8000 and sends all customer info to the server
     */

    public void sentInfo(){
        //connecting client to server
        try{
            Socket cSocket = new Socket("localhost", 8000);
            DataOutputStream outputStream=new DataOutputStream(cSocket.getOutputStream()); 
 
            outputStream.writeUTF(getPlate());

            ServiceList serList = services.get(getServiceVal());
            outputStream.writeUTF(serList.getService());

            outputStream.writeUTF(getVehicle());
            
            outputStream.writeInt(getServiceVal());

            outputStream.flush();  
            outputStream.close();  
            cSocket.close();  
        }catch(UnknownHostException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
        
}
