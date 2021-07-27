package xBis.carWash;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.TouchEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Client extends Application {

    public static String plate;
    
    TextField plateField = new TextField();

    @Override
    public void start(Stage stage){

        StackPane p = new StackPane();
        Scene scene = new Scene(p, 1080, 820);
       
        stage.setMinHeight(768);             
        stage.setMinWidth(1024);

        stage.setMaxHeight(1080);
        stage.setMaxWidth(1920);

        Label plateLabel = new Label("Enter licence plate"); 
        
        plate = plateField.getText();

        plateField.setPromptText("Enter licence plate here");

        Button nextButton = new Button("Next");

        Button exitButton = new Button("Exit");

        VBox vbox = new VBox();

        GridPane gPane = new GridPane();

        GridPane gPane1 = new GridPane();

        HBox winHbox = new HBox();

        HBox hBox0 = new HBox();

        HBox hBox1 = new HBox();

        HBox hBox2 = new HBox();

        HBox hBox3 = new HBox();

        //first line
        Button oneButton = new Button("1");
        Button twoButton = new Button("2");
        Button threeButton = new Button("3");
        Button fourButton = new Button("4");
        Button fiveButton = new Button("5");
        Button sixButton = new Button("6");
        Button sevenButton = new Button("7");
        Button eightButton = new Button("8");
        Button nineButton = new Button("9");
        Button zeroButton = new Button("0");

        //second line
        Button qButton = new Button("Q");
        Button wButton = new Button("W");
        Button eButton = new Button("E");
        Button rButton = new Button("R");
        Button tButton = new Button("T");
        Button yButton = new Button("Y");
        Button uButton = new Button("U");
        Button iButton = new Button("I");
        Button oButton = new Button("O");
        Button pButton = new Button("P");
        
        //third line
        Button aButton = new Button("A");
        Button sButton = new Button("S");
        Button dButton = new Button("D");
        Button fButton = new Button("F");
        Button gButton = new Button("G");
        Button hButton = new Button("H");
        Button jButton = new Button("J");
        Button kButton = new Button("K");
        Button lButton = new Button("L");
        
        //fourth line
        Button zButton = new Button("Z");
        Button xButton = new Button("X");
        Button cButton = new Button("C");
        Button vButton = new Button("V");
        Button bButton = new Button("B");
        Button nButton = new Button("N");
        Button mButton = new Button("M");
        Button spaceButton = new Button("SPACE");
        Button deleteButton = new Button("DELETE");

        //first row of keyboard buttons
        hBox0.getChildren().addAll(oneButton, twoButton, threeButton, fourButton, fiveButton, 
        sixButton, sevenButton, eightButton, nineButton, zeroButton);

        for(Node node : hBox0.getChildren()){
            hBox0.setSpacing(10);
            HBox.setHgrow((Button)node, Priority.ALWAYS);
            ((Button)node).setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            ((Button)node).setPadding(new Insets(5,5,5,5));
            ((Button)node).setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    String buttonVal = ((Button)node).getText();
                    plate += buttonVal;
                    plateField.setText(plate); 
                }   
            });

            ((Button)node).setOnTouchPressed(new EventHandler<TouchEvent>(){
                @Override
                public void handle(TouchEvent event) {
                    String buttonVal = ((Button)node).getText();
                    plate += buttonVal;
                    plateField.setText(plate);  
                }     
            });
        }

        //second row of keyboard buttons
        hBox1.getChildren().addAll(qButton, wButton, eButton, rButton, tButton, 
        yButton, uButton, iButton, oButton, pButton);
        
        for(Node node : hBox1.getChildren()){
            hBox1.setSpacing(10);
            HBox.setHgrow((Button)node, Priority.ALWAYS);
            ((Button)node).setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            ((Button)node).setPadding(new Insets(5,5,5,5));
            ((Button)node).setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    String buttonVal = ((Button)node).getText();
                    plate += buttonVal;
                    plateField.setText(plate); 
                }   
            });

            ((Button)node).setOnTouchPressed(new EventHandler<TouchEvent>(){
                @Override
                public void handle(TouchEvent event) {
                    String buttonVal = ((Button)node).getText();
                    plate += buttonVal;
                    plateField.setText(plate); 
                }     
            });
        }

        //third row of keyboard buttons
        hBox2.getChildren().addAll(aButton, sButton, dButton, fButton, gButton, 
        hButton, jButton, kButton, lButton);

        for(Node node : hBox2.getChildren()){
            hBox2.setSpacing(10);
            HBox.setHgrow((Button)node, Priority.ALWAYS);
            ((Button)node).setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            ((Button)node).setPadding(new Insets(5,5,5,5));
            ((Button)node).setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    String buttonVal = ((Button)node).getText();
                    plate += buttonVal;
                    plateField.setText(plate); 
                }   
            });

            ((Button)node).setOnTouchPressed(new EventHandler<TouchEvent>(){
                @Override
                public void handle(TouchEvent event) {
                    String buttonVal = ((Button)node).getText();
                    plate += buttonVal;
                    plateField.setText(plate); 
                }     
            });
        }

        //fourth row of keyboard buttons
        hBox3.getChildren().addAll(zButton, xButton, cButton, vButton, bButton, nButton, mButton, deleteButton);

        for(Node node : hBox3.getChildren()){
            hBox3.setSpacing(10);
            HBox.setHgrow((Button)node, Priority.ALWAYS);
            ((Button)node).setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            ((Button)node).setPadding(new Insets(5,5,5,5));
            ((Button)node).setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    String buttonVal = ((Button)node).getText();
                    if(((Button)node).getText().equals("DELETE")){
                        if(plate.length()>0){
                            StringBuffer strBuf = new StringBuffer(plate);
                            strBuf.deleteCharAt(strBuf.length()-1);
                            plate = strBuf.toString();
                            plateField.setText(plate);
                        }
                    }
                    else{
                        plate += buttonVal;
                        plateField.setText(plate); 
                    } 
                }   
            });

            ((Button)node).setOnTouchPressed(new EventHandler<TouchEvent>(){
                @Override
                public void handle(TouchEvent event) {
                    String buttonVal = ((Button)node).getText();
                    if(((Button)node).getText().equals("DELETE")){
                        if(plate.length()>0){
                            StringBuffer strBuf = new StringBuffer(plate);
                            strBuf.deleteCharAt(strBuf.length()-1);
                            plate = strBuf.toString();
                            plateField.setText(plate);
                        }
                    }
                    else{
                        plate += buttonVal;
                        plateField.setText(plate); 
                    } 
                }     
            });
        }

        //space and cancel button touch events
        spaceButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                plate += " ";
                plateField.setText(plate);
            }
        });

        spaceButton.setOnTouchPressed(new EventHandler<TouchEvent>(){
            @Override
            public void handle(TouchEvent event) {
                plate += " ";
                plateField.setText(plate);
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

        spaceButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        nextButton.setPrefSize(100.0, 50.0);

        exitButton.setPrefSize(100.0, 50.0);
        
        plateField.setPrefHeight(50.0);

        plateLabel.setFont(Font.font("New Times Roman", FontWeight.BOLD, FontPosture.REGULAR, 45));

        //add nodes to keyboard gridpane
        gPane.add(hBox0, 0, 0, 1, 1);
        gPane.add(hBox1, 0, 1, 1, 1);
        gPane.add(hBox2, 0, 2, 1, 1);
        gPane.add(hBox3, 0, 3, 1, 1);
        gPane.add(spaceButton, 0, 4, 1, 1);

        //scene nodes
        p.getChildren().addAll(gPane1);

        vbox.getChildren().addAll(plateLabel, plateField, winHbox);

        winHbox.getChildren().addAll(nextButton, exitButton);

        gPane1.add(vbox, 0, 0);
        gPane1.add(gPane, 0, 1);

        //nodes alignment and spacing
        spaceButton.setAlignment(Pos.CENTER);

        winHbox.setAlignment(Pos.CENTER);

        vbox.setAlignment(Pos.CENTER);

        gPane.setAlignment(Pos.CENTER);

        gPane1.setAlignment(Pos.CENTER);

        gPane.setHgap(10);
        gPane.setVgap(10);

        vbox.setSpacing(20);

        winHbox.setSpacing(20);

        VBox.setVgrow(plateField, Priority.ALWAYS);
        VBox.setVgrow(nextButton, Priority.ALWAYS);
        VBox.setVgrow(exitButton, Priority.ALWAYS);
        
        gPane1.setVgap(20);

        StackPane.setMargin(gPane1, new Insets(20, 20, 20, 20));

        //gPane keyboard col constraints
        ColumnConstraints columnConstraint0 = new ColumnConstraints();
        columnConstraint0.setHgrow(Priority.ALWAYS);
        gPane.getColumnConstraints().add(0, columnConstraint0);
    
        //gPane keyboard row constraints
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


        //gPane1 scene col constraints
        ColumnConstraints columnConstraint10 = new ColumnConstraints();
        columnConstraint10.setHgrow(Priority.ALWAYS);
        gPane1.getColumnConstraints().add(0, columnConstraint10);
    
        
        //gPane1 scene row constraints
        RowConstraints rowConstraint10 = new RowConstraints();
        rowConstraint10.setVgrow(Priority.ALWAYS);
        gPane1.getRowConstraints().add(0, rowConstraint10);

        RowConstraints rowConstraint11 = new RowConstraints();
        rowConstraint11.setVgrow(Priority.ALWAYS);
        gPane1.getRowConstraints().add(1, rowConstraint11);

        p.setStyle("-fx-background-color: AliceBlue ");
        
        stage.setScene(scene);
        stage.setTitle("Car Wash Licence Plate");
        stage.show();

        //next button event
        nextButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                if(!plate.equals(" ") && plate.length()>=2){
                    Services.servicesWindow(stage, plate);
                    stage.close();
                }
                else{
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.initOwner(stage);
                    alert.setTitle("Licence Plate Error");
                    alert.setHeaderText("Invalid licence plate number");
                    alert.setContentText("You need to add a valid licence plate with at least two characters");
                    alert.showAndWait();
                }
            }
        });

        nextButton.setOnTouchPressed(new EventHandler<TouchEvent>(){
            @Override
            public void handle(TouchEvent event) {
                if(!plate.equals(" ") && plate.length()>=2){
                    Services.servicesWindow(stage, plate);
                    stage.close();
                }
                else{
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.initOwner(stage);
                    alert.setTitle("Licence Plate Error");
                    alert.setHeaderText("Invalid licence plate number");
                    alert.setContentText("You need to add a valid licence plate with at least two characters");
                    alert.showAndWait();
                } 
            }     
        });

    }

    public static void main(String[] args) {
        launch(args);
    }

}
