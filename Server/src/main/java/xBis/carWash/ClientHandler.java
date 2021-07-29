package xBis.carWash;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Platform;

public class ClientHandler implements Runnable {

    private Socket clientSocket;

    public ClientHandler(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    /**
     * getting values sent from client and passing those values to the ServerData class variables
     */
    public void run() {
    
        try (DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream())) {
            
            String plate=(String)inputStream.readUTF(); 
            String serviceType=(String)inputStream.readUTF(); 
            String vehicle=(String)inputStream.readUTF();
            int serviceVal=(Integer)inputStream.readInt(); 
            
            ServerData serData = new ServerData();
            serData.setPlate(plate);
            serData.setServiceType(serviceType);
            serData.setVehicle(vehicle);
            serData.setServiceVal(serviceVal);

            /**
             * using ServerData class variables to add all the data in the Server class ObservableList data
             */
            Platform.runLater(new Runnable(){

                @Override
                public void run() {
                    //getting the date and time client sent the data 
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
                    Date date = new Date();  
                    String dateTime = formatter.format(date);
                    Server.data.add(new CustomerInfo(serData.getPlate(), serData.getServiceType(), serData.getVehicle(), serData.getPrice(), dateTime));
                    
                }
                
            });

            //putting the thread on hold for small amount of millisecs to avoid too much traffic
            Thread.sleep(1000);

            clientSocket.close();
        
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();  
        }
    }
    
}
