/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MethodsU4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author alfre
 */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
         Parent r=FXMLLoader.load(getClass().getResource("MethodsU4.fxml"));
        Scene scene=new Scene(r);
        primaryStage.setScene(scene);
        primaryStage.setTitle("numeric methods!");
        primaryStage.show(); 
    }
    
}