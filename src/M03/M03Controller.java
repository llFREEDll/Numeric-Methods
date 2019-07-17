/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M03;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alfre
 */
public class M03Controller implements Initializable {

    @FXML TextField tfx0=new TextField();
    @FXML TextField tfx1=new TextField();
    @FXML TextField tfy0=new TextField();
    @FXML TextField tfy1=new TextField();
    @FXML TextField tfx=new TextField();
    @FXML Label show=new Label();
    @FXML Pane root;
    DecimalFormat format = new DecimalFormat("#.00");
    
    @FXML public void Evaluate(){
        Double x=0.0,x0=0.0,x1=0.0,y0=0.0,y1=0.0;
        Boolean flag=true;
        try{
        x=Double.parseDouble(tfx.getText());
        x0=Double.parseDouble(tfx0.getText());
        x1=Double.parseDouble(tfx1.getText());
        y0=Double.parseDouble(tfy0.getText());
        y1=Double.parseDouble(tfy1.getText());
        }catch(Exception ae){
         flag = false;
        }
        if(flag){
        Double aux,aux2,aux3;
        
        aux2=1-x0;
        aux=((y1-y0)/(x1-x0))*aux2;
        //aux3=y0+(aux*x);
        aux3=y0+(y1-y0)*((x-x0)/(x1-x0));
        
            show.setText("f(x)= "+format.format(y0));
        if(aux<0)
            show.setText(show.getText()+format.format(aux)+"x");
        else
            show.setText(show.getText()+"+"+format.format(aux)+"x");
        show.setText(show.getText()+"\n"+"("+format.format(x)+","+format.format(aux3)+")");

        root.getChildren().clear();
    
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        //xAxis.setLabel("");
        //creating the chart
        final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
        XYChart.Series series = new XYChart.Series();
        XYChart.Series serie = new XYChart.Series();
        
        series.setName("CHART");
        
        series.getData().add(new XYChart.Data(x0,y0));
        series.getData().add(new XYChart.Data(x1,y1));
        serie.getData().add(new XYChart.Data(x,aux3));
        
        lineChart.getData().add(series);
        lineChart.getData().add(serie);
        
        lineChart.setMaxWidth(300);//300
        lineChart.setMaxHeight(400);//400
        root.setLayoutX(300);
        root.setLayoutY(100);
       root.getChildren().add(lineChart);
        }else show.setText("INPUT ERROR");
        
    }
        
     @FXML public void GoBack(ActionEvent ae){
          
         try {
             
                Stage primaryStage=new Stage();
               Parent r=FXMLLoader.load(getClass().getResource("/MethodsU4/MethodsU4.fxml"));
                Scene scene=new Scene(r);
                primaryStage.setScene(scene);
                primaryStage.setTitle("numeric methods!");
                primaryStage.show();   
               ((Node)(ae.getSource())).getScene().getWindow().hide();
               
            } catch (IOException ex) {
                
                Logger.getLogger(M03Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
