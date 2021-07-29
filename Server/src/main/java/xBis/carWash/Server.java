package xBis.carWash;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableCell;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;  
import java.util.Date; 

/**
 * JavaFX App
 */
        public class Server extends Application  {

            public static ObservableList<CustomerInfo> data = FXCollections.observableArrayList();

            @Override
            public void start(Stage primaryStage) {

                GridPane gPane = new GridPane();

                Scene scene = new Scene(gPane, 1080, 820);

                primaryStage.setMinHeight(768);             
                primaryStage.setMinWidth(1024);

                primaryStage.setMaxHeight(1080);
                primaryStage.setMaxWidth(1920);

                //enter button
                Button enterButton = new Button("Enter");
                enterButton.setPrefSize(100.0, 50.0);

                //delete Button
                Button deleteButton = new Button("Delete");
                deleteButton.setPrefSize(100.0, 50.0);

                //exit button
                Button exitButton = new Button("Exit");
                exitButton.setPrefSize(100.0, 50.0);

                HBox hBox = new HBox();
                
                ServerData serData = new ServerData();
                
                TableView<CustomerInfo> tableView = new TableView<CustomerInfo>();

                //tableview column creation
                TableColumn<CustomerInfo, String> column1 = new TableColumn<>("Licence Plate");
                column1.setCellValueFactory(new PropertyValueFactory<>("plate"));

                TableColumn<CustomerInfo, String> column2 = new TableColumn<>("Service");
                column2.setCellValueFactory(new PropertyValueFactory<>("serviceType"));

                TableColumn<CustomerInfo, String> column3 = new TableColumn<>("Vehicle Type");
                column3.setCellValueFactory(new PropertyValueFactory<>("vehicle"));

                TableColumn<CustomerInfo, String> column4 = new TableColumn<>("Cost");
                column4.setCellValueFactory(new PropertyValueFactory<>("price"));

                TableColumn<CustomerInfo, String> column5 = new TableColumn<>("Registration Time");
                column5.setCellValueFactory(new PropertyValueFactory<>("dateTime"));

                //add columns to tableview
                tableView.getColumns().add(column1);
                tableView.getColumns().add(column2);
                tableView.getColumns().add(column3);
                tableView.getColumns().add(column4);
                tableView.getColumns().add(column5);

                //column text alignment
                column1.setStyle( "-fx-alignment: CENTER;");
                column2.setStyle( "-fx-alignment: CENTER;");
                column3.setStyle( "-fx-alignment: CENTER;");
                column4.setStyle( "-fx-alignment: CENTER;");
                column5.setStyle( "-fx-alignment: CENTER;");

                //make columns occupy all table space
                tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
 
                //create a new thread to receive data from client while the GUI is running
                new Thread(){
                    public void run(){
                        serData.receiveInfo();
                    }
                }.start();
                
                //insert data to list
                tableView.setItems(data);

                gPane.add(tableView, 0, 0);
                gPane.add(hBox, 0, 1);

                gPane.setHgap(20.0);

                gPane.setVgap(20.0);
                
                hBox.getChildren().addAll(enterButton, deleteButton, exitButton);

                hBox.setSpacing(20.0);

                gPane.setAlignment(Pos.CENTER);

                hBox.setAlignment(Pos.CENTER);

                GridPane.setMargin(tableView, new Insets(20, 20, 20, 20));

                GridPane.setMargin(hBox, new Insets(0, 20, 20, 20));

                //gridpane row constraints
                RowConstraints rowCon0 = new RowConstraints();
                rowCon0.setVgrow(Priority.ALWAYS);
                gPane.getRowConstraints().add(0, rowCon0);

                RowConstraints rowCon1 = new RowConstraints();
                rowCon1.setVgrow(Priority.NEVER);
                gPane.getRowConstraints().add(1, rowCon1);

                //gridpane col constraint
                ColumnConstraints colCon0 = new ColumnConstraints();
                colCon0.setHgrow(Priority.ALWAYS);
                gPane.getColumnConstraints().add(0, colCon0);

                enterButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        CustomerInfo customer = tableView.getSelectionModel().getSelectedItem();     //select the item
                        if(customer != null){
                            try{
                                //getting current check out time and date
                                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
                                Date date = new Date();
                                String dateTime = formatter.format(date);

                                FileWriter fw = new FileWriter("ReceiptBook.txt", true);
                                BufferedWriter output = new BufferedWriter(fw);
                                
                                String str = "\nplate: " + customer.getPlate() + "\nService: " + customer.getServiceType() + "\nVehicle: " + customer.getVehicle() + "\nPrice: " + customer.getPrice() + "\nCheck In Date Time: " + customer.getDateTime() + "\nCheck Out Date Time: " + dateTime + "\n";
                                output.write(str);
                                output.close();
                            }
                            catch(Exception e){
                                e.getStackTrace();
                            }
                            String plate=customer.getPlate();
                            String serviceInfo=customer.getServiceType();
                            String vehicle=customer.getVehicle();
                            Integer price=customer.getPrice();
                            String datetime=customer.getDateTime();
                            Alert submitInfo = new Alert(AlertType.INFORMATION);
                            submitInfo.initModality(Modality.APPLICATION_MODAL);
                            submitInfo.initOwner(primaryStage);
                            submitInfo.setTitle("Receipt");
                            submitInfo.setHeaderText("Customers info ");
                            submitInfo.setContentText("Plate: " + plate + "\nService: " + serviceInfo + "\nVehicle: " + vehicle + "\nPrice: " + price+ "\nEntry Date Time: " + datetime);
                            submitInfo.showAndWait();
                            data.remove(customer);  
                        }   
                        else{
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.initModality(Modality.APPLICATION_MODAL);
                            alert.initOwner(primaryStage);
                            alert.setTitle("Selection Error");
                            alert.setHeaderText("No data has been selected");
                            alert.setContentText("Data has to be selected");
                            alert.showAndWait();
                        }
                    }    
                });

                scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
                    @Override
                    public void handle(KeyEvent event) {
                        if(event.getCode() == KeyCode.ENTER){
                            CustomerInfo customer = tableView.getSelectionModel().getSelectedItem();     //select the item
                            if(customer != null){
                                try{
                                    //getting current check out time and date
                                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
                                    Date date = new Date();
                                    String dateTime = formatter.format(date);

                                    FileWriter fw = new FileWriter("ReceiptBook.txt", true);
                                    BufferedWriter output = new BufferedWriter(fw);
                                    
                                    String str = "\nplate: " + customer.getPlate() + "\nService: " + customer.getServiceType() + "\nVehicle: " + customer.getVehicle() + "\nPrice: " + customer.getPrice() + "\nCheck In Date Time: " + customer.getDateTime() + "\nCheck Out Date Time: " + dateTime + "\n";
                                    output.write(str);
                                    output.close();  
                                }
                                catch(Exception e){
                                    e.getStackTrace();
                                }
                                String plate=customer.getPlate();
                                String serviceInfo=customer.getServiceType();
                                String vehicle=customer.getVehicle();
                                Integer price=customer.getPrice();
                                String datetime=customer.getDateTime();
                                Alert submitInfo = new Alert(AlertType.INFORMATION);
                                submitInfo.initModality(Modality.APPLICATION_MODAL);
                                submitInfo.initOwner(primaryStage);
                                submitInfo.setTitle("Receipt");
                                submitInfo.setHeaderText("Customers info ");
                                submitInfo.setContentText("Plate: " + plate + "\nService: " + serviceInfo + "\nVehicle: " + vehicle + "\nPrice: " + price+ "\nEntry Date Time: " + datetime);
                                submitInfo.showAndWait();
                                data.remove(customer);
                            }   
                            else{
                                Alert alert = new Alert(AlertType.ERROR);
                                alert.initModality(Modality.APPLICATION_MODAL);
                                alert.initOwner(primaryStage);
                                alert.setTitle("Selection Error");
                                alert.setHeaderText("No data has been selected");
                                alert.setContentText("Data has to be selected");
                                alert.showAndWait();
                            }
                        }
                    }
                });

                deleteButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        CustomerInfo customer = tableView.getSelectionModel().getSelectedItem();     //select the item
                        if(customer != null){
                            data.remove(customer);
                        }
                        else{
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.initModality(Modality.APPLICATION_MODAL);
                            alert.initOwner(primaryStage);
                            alert.setTitle("Selection Error");
                            alert.setHeaderText("No data has been selected");
                            alert.setContentText("Select data to proceed");
                            alert.showAndWait();
                        }
                    }   
                });

                //delete selected item on pressing DELETE
                scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
                    @Override
                    public void handle(KeyEvent event) {
                        if(event.getCode() == KeyCode.DELETE){
                            CustomerInfo customer = tableView.getSelectionModel().getSelectedItem();     //select the item
                            if(customer != null){
                                data.remove(customer);
                            }
                            else{
                                Alert alert = new Alert(AlertType.ERROR);
                                alert.initModality(Modality.APPLICATION_MODAL);
                                alert.initOwner(primaryStage);
                                alert.setTitle("Selection Error");
                                alert.setHeaderText("No data has been selected");
                                alert.setContentText("Select data to proceed");
                                alert.showAndWait();
                            }
                        }
                    }
                });
                
                exitButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        //check if the list is empty
                        if(data.isEmpty()){
                            System.exit(0);
                        }
                        else{
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.initModality(Modality.APPLICATION_MODAL);
                            alert.initOwner(primaryStage);
                            alert.setTitle("Exit Error");
                            alert.setHeaderText("Customers list is not empty");
                            alert.setContentText("All customers must be serviced");
                            alert.showAndWait();
                        }
                    }   
                });

                //to terminate all background proccesses on window close
                primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        if(data.isEmpty()){
                            System.exit(0);
                        }
                        else{
                            //saving everything to file in case of closing server unexpectingly
                            for(int i=0; i<data.size(); i++){
                                CustomerInfo customer = data.get(i);
                                try{
                                    //getting current check out time and date
                                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
                                    Date date = new Date();
                                    String dateTime = formatter.format(date);

                                    FileWriter fw = new FileWriter("ReceiptBook.txt", true);
                                    BufferedWriter output = new BufferedWriter(fw);
                                    
                                    String str = "\nplate: " + customer.getPlate() + "\nService: " + customer.getServiceType() + "\nVehicle: " + customer.getVehicle() + "\nPrice: " + customer.getPrice() + "\nCheck In Date Time: " + customer.getDateTime() + "\nCheck Out Date Time: " + dateTime + "\n";
                                    output.write(str);
                                    output.close();  
                                }
                                catch(Exception e){
                                    e.getStackTrace();
                                }
                            }    
                        }  
                    }
                  });

                //closing window on pressing ESC
                scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
                    @Override
                    public void handle(KeyEvent event) {
                        if(event.getCode() == KeyCode.ESCAPE){
                            //check if the list is empty
                            if(data.isEmpty()){
                                System.exit(0);
                            }
                            else{
                                Alert alert = new Alert(AlertType.ERROR);
                                alert.initModality(Modality.APPLICATION_MODAL);
                                alert.initOwner(primaryStage);
                                alert.setTitle("Exit Error");
                                alert.setHeaderText("Customers list is not empty");
                                alert.setContentText("All customers must be serviced");
                                alert.showAndWait();
                            }
                        }
                    }
                });
            
                gPane.setStyle("-fx-background-color: #ffedec ");

                primaryStage.setScene(scene);
                primaryStage.setTitle("Car Wash Server");
                primaryStage.show();

            }

            public static void main(String[] args) {
                launch(args);
            }

        }

        
