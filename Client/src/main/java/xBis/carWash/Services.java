package xBis.carWash;

import javafx.event.EventHandler;
import javafx.scene.input.TouchEvent;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class Services{

    public static void servicesWindow(Stage stage, String plate){   

        Stage serWin = new Stage();
        StackPane p = new StackPane();
        Scene scene = new Scene(p, 1080, 820);
        
        serWin.setMinHeight(768);             
        serWin.setMinWidth(1024);

        serWin.setMaxHeight(1080);
        serWin.setMaxWidth(1920);

        Label serviceLabel = new Label("Choose one of our services");

        ToggleButton extWash = new ToggleButton("Exterior Washing");

        ToggleButton intClean = new ToggleButton("Interior Cleaning");

        ToggleButton intExt = new ToggleButton("Interior + Exterior");

        ToggleButton extSpecial = new ToggleButton("Exterior Special");

        ToggleButton intSpecial = new ToggleButton("Interior Special");

        ToggleButton intExtSpecial = new ToggleButton("Interior + Exterior Special");

        ToggleButton intBio = new ToggleButton("Biological Interior Cleaning");

        ToggleButton waxShine = new ToggleButton("Waxing + Shining");

        ToggleButton engineClean = new ToggleButton("Engine Cleaning");
        
        ToggleButton carBody = new ToggleButton("Under Car Body Washing"); 

        Text extCar = new Text("7");
        Text extSuv = new Text("8");
        Text extMotor = new Text("6");

        Text intCar = new Text("6");
        Text intSuv = new Text("7");
        Text intMotor = new Text("-");

        Text intExtCar = new Text("12");
        Text intExtSuv = new Text("14");
        Text intExtMotor = new Text("-");

        Text extSpCar = new Text("9");
        Text extSpSuv = new Text("10");
        Text extSpMotor = new Text("8");

        Text intSpCar = new Text("8");
        Text intSpSuv = new Text("9");
        Text intSpMotor = new Text("-");

        Text intExtSpCar = new Text("15");
        Text intExtSpSuv = new Text("17");
        Text intExtSpMotor = new Text("-");

        Text bioCar = new Text("80");
        Text bioSuv = new Text("80");
        Text bioMotor = new Text("-");

        Text waxCar = new Text("80");
        Text waxSuv = new Text("90");
        Text waxMotor = new Text("40");

        Text engineCar = new Text("20");
        Text engineSuv = new Text("20");
        Text engineMotor = new Text("10");

        Text bodyCar = new Text("3");
        Text bodySuv = new Text("3");
        Text bodyMotor = new Text("-");

        HBox hbox = new HBox();

        Button submitButton = new Button("Submit");
        Button prevButton = new Button("Previous");
        Button exitButton = new Button("Exit");

        ToggleButton sedanButton = new ToggleButton("Sedan");
        ToggleButton suvButton = new ToggleButton("SUV");
        ToggleButton motorButton = new ToggleButton("Motorcycle");

        GridPane gPane = new GridPane(); 

        GridPane mainGPane = new GridPane(); 

        ToggleGroup servGroup = new ToggleGroup();

        ToggleGroup vehicleGroup = new ToggleGroup();

        //stackpane root node
        p.getChildren().addAll(mainGPane);

        hbox.getChildren().addAll(submitButton, prevButton, exitButton);

        //Toggle Groups
        servGroup.getToggles().addAll(extWash, intClean, intExt, extSpecial, intSpecial,
        intExtSpecial, intBio, waxShine, engineClean, carBody);

        vehicleGroup.getToggles().addAll(sedanButton, suvButton, motorButton);

        //add nodes to mainGPane
        mainGPane.add(serviceLabel, 0, 0);
        mainGPane.add(gPane, 0, 1);
        mainGPane.add(hbox, 0, 2);

        //add nodes to gPane
        gPane.add(sedanButton, 1, 0, 1, 1);
        gPane.add(suvButton, 2, 0, 1, 1);
        gPane.add(motorButton, 3, 0, 1, 1);

        gPane.add(extWash, 0, 1, 1, 1);
        gPane.add(extCar, 1, 1, 1, 1);
        gPane.add(extSuv, 2, 1, 1, 1);
        gPane.add(extMotor, 3, 1, 1, 1);

        gPane.add(intClean, 0, 2, 1, 1);
        gPane.add(intCar, 1, 2, 1, 1);
        gPane.add(intSuv, 2, 2, 1, 1);
        gPane.add(intMotor, 3, 2, 1, 1);

        gPane.add(intExt, 0, 3, 1, 1);
        gPane.add(intExtCar, 1, 3, 1, 1);
        gPane.add(intExtSuv, 2, 3, 1, 1);
        gPane.add(intExtMotor, 3, 3, 1, 1);

        gPane.add(extSpecial, 0, 4, 1, 1);
        gPane.add(extSpCar, 1, 4, 1, 1);
        gPane.add(extSpSuv, 2, 4, 1, 1);
        gPane.add(extSpMotor, 3, 4, 1, 1);

        gPane.add(intSpecial, 0, 5, 1, 1);
        gPane.add(intSpCar, 1, 5, 1, 1);
        gPane.add(intSpSuv, 2, 5, 1, 1);
        gPane.add(intSpMotor, 3, 5, 1, 1);

        gPane.add(intExtSpecial, 0, 6, 1, 1);
        gPane.add(intExtSpCar, 1, 6, 1, 1);
        gPane.add(intExtSpSuv, 2, 6, 1, 1);
        gPane.add(intExtSpMotor, 3, 6, 1, 1);

        gPane.add(intBio, 0, 7, 1, 1);
        gPane.add(bioCar, 1, 7, 1, 1);
        gPane.add(bioSuv, 2, 7, 1, 1);
        gPane.add(bioMotor, 3, 7, 1, 1);

        gPane.add(waxShine, 0, 8, 1, 1);
        gPane.add(waxCar, 1, 8, 1, 1);
        gPane.add(waxSuv, 2, 8, 1, 1);
        gPane.add(waxMotor, 3, 8, 1, 1);

        gPane.add(engineClean, 0, 9, 1, 1);
        gPane.add(engineCar, 1, 9, 1, 1);
        gPane.add(engineSuv, 2, 9, 1, 1);
        gPane.add(engineMotor, 3, 9, 1, 1);

        gPane.add(carBody, 0, 10, 1, 1);
        gPane.add(bodyCar, 1, 10, 1, 1);
        gPane.add(bodySuv, 2, 10, 1, 1);
        gPane.add(bodyMotor, 3, 10, 1, 1);

        //loop through gPane nodes
        for(Node node : gPane.getChildren()){
            if(GridPane.getColumnIndex(node) == 0 && GridPane.getRowIndex(node) >= 1 && GridPane.getRowIndex(node) < 11){
                ((ToggleButton)node).setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                ((ToggleButton)node).setPadding(new Insets(5,5,5,5));

                ((ToggleButton)node).setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        Toggle selectedToggle = servGroup.getSelectedToggle();
                        if(selectedToggle == intClean || selectedToggle == intExt || selectedToggle == intSpecial || 
                        selectedToggle == intExtSpecial || selectedToggle == intBio ||selectedToggle == carBody){
                            motorButton.setDisable(true);
                        }
                        else{
                            motorButton.setDisable(false);
                        }
                    }
                });

                ((ToggleButton)node).setOnTouchPressed(new EventHandler<TouchEvent>(){
                    @Override
                    public void handle(TouchEvent event) {
                        Toggle selectedToggle = servGroup.getSelectedToggle();
                        if(selectedToggle == intClean || selectedToggle == intExt || selectedToggle == intSpecial || 
                        selectedToggle == intExtSpecial || selectedToggle == intBio ||selectedToggle == carBody){
                            motorButton.setDisable(true);
                        }
                        else{
                            motorButton.setDisable(false);
                        }  
                    }
                });
            }
            if(GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) >= 1 && GridPane.getColumnIndex(node) < 4){
                ((ToggleButton)node).setMinSize(100.0 , 50.0);
                ((ToggleButton)node).setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                ((ToggleButton)node).setPadding(new Insets(5,5,5,5));
            }
            if((GridPane.getRowIndex(node) >= 1 && GridPane.getRowIndex(node) < 11) && (GridPane.getColumnIndex(node) >= 1 && GridPane.getColumnIndex(node) < 4)){
                ((Text)node).setFont(Font.font("New Times Roman", FontWeight.LIGHT, FontPosture.REGULAR, 30));
            }
        }

        serviceLabel.setFont(Font.font("New Times Roman", FontWeight.BOLD, FontPosture.REGULAR, 45));

        submitButton.setMinSize(150.0, 75.0);
        prevButton.setMinSize(150.0, 75.0);
        exitButton.setMinSize(150.0, 75.0);

        //gPane column constraints
        ColumnConstraints columnConstraint0 = new ColumnConstraints();
        columnConstraint0.setHgrow(Priority.ALWAYS);
        columnConstraint0.setHalignment(HPos.CENTER);
        gPane.getColumnConstraints().add(0, columnConstraint0);

        ColumnConstraints columnConstraint1 = new ColumnConstraints();
        columnConstraint1.setHgrow(Priority.ALWAYS);
        columnConstraint1.setHalignment(HPos.CENTER);
        gPane.getColumnConstraints().add(1, columnConstraint1);

        ColumnConstraints columnConstraint2 = new ColumnConstraints();
        columnConstraint2.setHgrow(Priority.ALWAYS);
        columnConstraint2.setHalignment(HPos.CENTER);
        gPane.getColumnConstraints().add(2, columnConstraint2);
        
        ColumnConstraints columnConstraint3 = new ColumnConstraints();
        columnConstraint3.setHgrow(Priority.ALWAYS);
        columnConstraint3.setHalignment(HPos.CENTER);
        gPane.getColumnConstraints().add(3, columnConstraint3);

        //gPane row constraints
        RowConstraints rowConstraint0 = new RowConstraints();
        rowConstraint0.setVgrow(Priority.ALWAYS);
        gPane.getRowConstraints().add(0, rowConstraint0);

        RowConstraints rowConstraint1 = new RowConstraints();
        rowConstraint1.setVgrow(Priority.ALWAYS);
        gPane.getRowConstraints().add(1, rowConstraint1);

        RowConstraints rowConstraint2 = new RowConstraints();
        rowConstraint2.setVgrow(Priority.ALWAYS);
        gPane.getRowConstraints().add(2, rowConstraint2);

        RowConstraints rowConstraint3 = new RowConstraints();
        rowConstraint3.setVgrow(Priority.ALWAYS);
        gPane.getRowConstraints().add(3, rowConstraint3);

        RowConstraints rowConstraint4 = new RowConstraints();
        rowConstraint4.setVgrow(Priority.ALWAYS);
        gPane.getRowConstraints().add(4, rowConstraint4);

        RowConstraints rowConstraint5 = new RowConstraints();
        rowConstraint5.setVgrow(Priority.ALWAYS);
        gPane.getRowConstraints().add(5, rowConstraint5);

        RowConstraints rowConstraint6 = new RowConstraints();
        rowConstraint6.setVgrow(Priority.ALWAYS);
        gPane.getRowConstraints().add(6, rowConstraint6);

        RowConstraints rowConstraint7 = new RowConstraints();
        rowConstraint7.setVgrow(Priority.ALWAYS);
        gPane.getRowConstraints().add(7, rowConstraint7);

        RowConstraints rowConstraint8 = new RowConstraints();
        rowConstraint8.setVgrow(Priority.ALWAYS);
        gPane.getRowConstraints().add(8, rowConstraint8);

        RowConstraints rowConstraint9 = new RowConstraints();
        rowConstraint9.setVgrow(Priority.ALWAYS);
        gPane.getRowConstraints().add(9, rowConstraint9);

        RowConstraints rowConstraint10 = new RowConstraints();
        rowConstraint10.setVgrow(Priority.ALWAYS);
        gPane.getRowConstraints().add(10, rowConstraint10);

        //mainGPane column constraints
        ColumnConstraints mainColumnConstraint0 = new ColumnConstraints();
        mainColumnConstraint0.setHgrow(Priority.ALWAYS);
        mainColumnConstraint0.setHalignment(HPos.CENTER);
        mainGPane.getColumnConstraints().add(0, mainColumnConstraint0);

        //mainGPane row constraints
        RowConstraints mainRowConstraint0 = new RowConstraints();
        mainRowConstraint0.setVgrow(Priority.ALWAYS);
        mainGPane.getRowConstraints().add(0, mainRowConstraint0);

        RowConstraints mainRowConstraint1 = new RowConstraints();
        mainRowConstraint1.setVgrow(Priority.ALWAYS);
        mainGPane.getRowConstraints().add(1, mainRowConstraint1);

        RowConstraints mainRowConstraint2 = new RowConstraints();
        mainRowConstraint2.setVgrow(Priority.ALWAYS);
        mainGPane.getRowConstraints().add(2, mainRowConstraint2);

        //alignment, spacing, margin
        mainGPane.setAlignment(Pos.CENTER);

        mainGPane.setVgap(15.0);

        hbox.setSpacing(20);

        gPane.setAlignment(Pos.CENTER);

        gPane.setHgap(10.0);

        gPane.setVgap(10.0);

        hbox.setAlignment(Pos.CENTER);

        StackPane.setMargin(mainGPane, new Insets(20, 20, 20, 20));

        p.setStyle("-fx-background-color: AliceBlue ");

        //submit, previous, exit button events
        submitButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                if(servGroup.getSelectedToggle() != null){
                    int i=0;
                    for(Toggle toggle: servGroup.getToggles()){
                        if(toggle == servGroup.getSelectedToggle()){
                            String vehicle;
                            if(vehicleGroup.getSelectedToggle() != null){
                                ToggleButton tButton = (ToggleButton)vehicleGroup.getSelectedToggle(); 
                                vehicle = tButton.getText();
                                ClientData clientData = new ClientData(plate, vehicle, i);
                                clientData.sentInfo();

                                ToggleButton tButton1 = (ToggleButton)servGroup.getSelectedToggle();
                                String serviceInfo = tButton1.getText();                                
                                    
                                Alert submitInfo = new Alert(AlertType.INFORMATION);
                                submitInfo.initModality(Modality.APPLICATION_MODAL);
                                submitInfo.initOwner(stage);
                                submitInfo.setTitle("Submit Confirmation");
                                submitInfo.setHeaderText("Your info has been submitted");
                                submitInfo.setContentText("Plate: " + plate + "\nService: " + serviceInfo + "\nVehicle: " + vehicle);
                                submitInfo.showAndWait();
                                
                                Client clientWin = new Client(); 
                                clientWin.plateField.setText("");
                                clientWin.start(stage);
                                serWin.close();
                            }
                            else{
                                Alert alert = new Alert(AlertType.ERROR);
                                alert.initModality(Modality.APPLICATION_MODAL);
                                alert.initOwner(stage);
                                alert.setTitle("Vehicle Error");
                                alert.setHeaderText("Vehicle type not selected");
                                alert.setContentText("You need to select a vehicle type before you submit your info");
                                alert.showAndWait();
                            } 
                        }
                        i++;
                    }
                }
                else{
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.initOwner(stage);
                    alert.setTitle("Service Error");
                    alert.setHeaderText("Service not selected");
                    alert.setContentText("You need to select a service before you submit your info");
                    alert.showAndWait();
                }   
            }
        });

        submitButton.setOnTouchPressed(new EventHandler<TouchEvent>(){
            @Override
            public void handle(TouchEvent event) {
                if(servGroup.getSelectedToggle() != null){
                    int i=0;
                    for(Toggle toggle: servGroup.getToggles()){
                        if(toggle == servGroup.getSelectedToggle()){
                            String vehicle;
                            if(vehicleGroup.getSelectedToggle() != null){
                                ToggleButton tButton = (ToggleButton)vehicleGroup.getSelectedToggle(); 
                                vehicle = tButton.getText();
                                
                                ClientData clientData = new ClientData(plate, vehicle, i);
                                clientData.sentInfo();

                                ToggleButton tButton1 = (ToggleButton)servGroup.getSelectedToggle();
                                String serviceInfo = tButton1.getText();                                
                                    
                                Alert submitInfo = new Alert(AlertType.INFORMATION);
                                submitInfo.initModality(Modality.APPLICATION_MODAL);
                                submitInfo.initOwner(stage);
                                submitInfo.setTitle("Submit Confirmation");
                                submitInfo.setHeaderText("Your info has been submitted");
                                submitInfo.setContentText("Plate: " + plate + "\nService: " + serviceInfo + "\nVehicle: " + vehicle);
                                submitInfo.showAndWait();
                               
                                Client clientWin = new Client(); 
                                clientWin.plateField.setText("");
                                clientWin.start(stage);
                                serWin.close();
                            }
                            else{
                                Alert alert = new Alert(AlertType.ERROR);
                                alert.initModality(Modality.APPLICATION_MODAL);
                                alert.initOwner(stage);
                                alert.setTitle("Vehicle Error");
                                alert.setHeaderText("Vehicle type not selected");
                                alert.setContentText("You need to select a vehicle type before you submit your info");
                                alert.showAndWait();
                            } 
                        }
                        i++;
                    }
                }
                else{
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.initOwner(stage);
                    alert.setTitle("Service Error");
                    alert.setHeaderText("Service not selected");
                    alert.setContentText("You need to select a service before you submit your info");
                    alert.showAndWait();
                } 
            }   
        });

        prevButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                Client clientWin = new Client(); 
                clientWin.plateField.setText(plate);
                clientWin.start(stage);
                serWin.close();
            }
        });

        prevButton.setOnTouchPressed(new EventHandler<TouchEvent>(){
            @Override
            public void handle(TouchEvent event) {
                Client clientWin = new Client(); 
                clientWin.plateField.setText(plate);
                clientWin.start(stage);
                serWin.close(); 
            }   
        });

        exitButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                System.exit(0);                
            }
        });

        exitButton.setOnTouchPressed(new EventHandler<TouchEvent>(){
            @Override
            public void handle(TouchEvent event) {
                System.exit(0);
            }   
        });

        serWin.setTitle("Car Wash Services");
        serWin.setScene(scene);
        serWin.show();
    }
    
}
