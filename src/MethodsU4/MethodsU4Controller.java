/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MethodsU4;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alfre
 */
public class MethodsU4Controller implements Initializable {

 public void OnPush1(ActionEvent ae){
        try {
            Stage primaryStage=new Stage();
            Parent r=FXMLLoader.load(getClass().getResource("/M01/M01.fxml"));
            Scene scene=new Scene(r);
            primaryStage.setScene(scene);  
            primaryStage.setTitle("Linear regression");
            primaryStage.show();
            ((Node)(ae.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(MethodsU4Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void OnPush2(ActionEvent ae){
        try {
            Stage primaryStage=new Stage();
            Parent r=FXMLLoader.load(getClass().getResource("/M02/M02.fxml"));
            Scene scene=new Scene(r);
            primaryStage.setScene(scene);  
            primaryStage.setTitle("Quadratic interpolation");
            primaryStage.show();
            ((Node)(ae.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(MethodsU4Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void OnPush3(ActionEvent ae){
        try {
            Stage primaryStage=new Stage();
            Parent r=FXMLLoader.load(getClass().getResource("/M03/M03.fxml"));
            Scene scene=new Scene(r);
            primaryStage.setScene(scene);  
            primaryStage.setTitle("Linear interpolation");
            primaryStage.show();
            ((Node)(ae.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(MethodsU4Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void OnPush4(ActionEvent ae){
        try {
            Stage primaryStage=new Stage();
            Parent r=FXMLLoader.load(getClass().getResource("/M04/M04.fxml"));
            Scene scene=new Scene(r);
            primaryStage.setScene(scene);  
            primaryStage.setTitle("Quadratic regression");
            primaryStage.show();
            ((Node)(ae.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(MethodsU4Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
