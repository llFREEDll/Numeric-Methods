/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M01;

import M04.Dates04;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author alfre
 */
public class M01Controller implements Initializable {

    @FXML TextField tfx=new TextField();
    @FXML TextField tfy=new TextField();
    
    @FXML private TableView<Dates> table =new TableView();
    @FXML TableColumn<Dates,String> x;
    @FXML TableColumn<Dates,String> y;
    @FXML TableColumn<Dates,String> xy;
    @FXML TableColumn<Dates,String> xx;
    ObservableList<Dates> date;
    @FXML Label lm=new Label();
    @FXML Label lb=new Label();
    Boolean flag;
    Integer c;
    Double [][]matrix;
    List<Double> lx=new ArrayList();
    List<Double> ly=new ArrayList();
    List<Double> lxy=new ArrayList();
    List<Double> lxx=new ArrayList();
    @FXML Pane root;
    Double m,b,xMin=0.0,xMax=0.0;
    @FXML Button add;
    @FXML Button graphic;
    DecimalFormat format = new DecimalFormat("#.0000");
    
    
      public void GoBack(ActionEvent ae){
          
         try {
             
                Stage primaryStage=new Stage();
               Parent r=FXMLLoader.load(getClass().getResource("/MethodsU4/MethodsU4.fxml"));
                Scene scene=new Scene(r);
                primaryStage.setScene(scene);
                primaryStage.setTitle("numeric methods!");
                primaryStage.show();   
               ((Node)(ae.getSource())).getScene().getWindow().hide();
               
            } catch (IOException ex) {
                
                Logger.getLogger(M01Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        lb.setVisible(false);
        lm.setVisible(false);
        
        graphic.setVisible(false);
        x.setCellValueFactory(new PropertyValueFactory<Dates,String>("x"));
        y.setCellValueFactory(new PropertyValueFactory<Dates,String>("y"));
        xy.setCellValueFactory(new PropertyValueFactory<Dates,String>("xy"));
        xx.setCellValueFactory(new PropertyValueFactory<Dates,String>("xx"));
        
        date=FXCollections.observableArrayList();
        
        table.setItems(date);
        
        
    }

@FXML public void AddItem(){//add item to the table
    Boolean flag=true;
    if(!(tfx.getText().isEmpty())&&!(tfy.getText().isEmpty())){
        Double aux=0.0,aux2=0.0;
        try{
            aux=Double.parseDouble(tfx.getText())*Double.parseDouble(tfy.getText());// to do x * y and send the date to the class
            aux2=Double.parseDouble(tfx.getText())*Double.parseDouble(tfx.getText());// to do x * x and send the date to the class
        }
        catch(Exception ae){
            lm.setText("Input error");
            flag=false;
        }
        if(flag){
            date.add(new Dates(tfx.getText(),tfy.getText(),aux.toString(),aux2.toString()));
            lx.add(Double.parseDouble(tfx.getText()));
            ly.add(Double.parseDouble(tfy.getText()));
            lxy.add(aux);
            lxx.add(aux2);
            if(table.getItems().size()==1){
            xMax=Double.parseDouble(tfx.getText());
            }
            if(Double.parseDouble(tfx.getText())>xMax)
                xMax=Double.parseDouble(tfx.getText());
                
        }
    }
   }

@FXML public void Evaluate(){
    if(table.getItems().size()>=2){
    graphic.setVisible(true);
    add.setVisible(false);
    
    Integer aux=table.getItems().size();
    matrix=new Double[table.getItems().size()][4]; // declating the matrix size
    for(int i=0;i<table.getItems().size();i++){// add every date on table to the matrix
        matrix[i][0]=lx.get(i);
        matrix[i][1]=ly.get(i);
        matrix[i][2]=lxy.get(i);
        matrix[i][3]=lxx.get(i);
    }
    
        Double sumX=0.0,sumY=0.0,sumXY=0.0,sumXX=0.0; //do the think
     for(int i=0;i<aux;i++){
     sumX=sumX+matrix[i][0];
     sumY=sumY+matrix[i][1];
     sumXY=sumXY+matrix[i][2];
     sumXX=sumXX+matrix[i][3];
     }
     m=(((aux*sumXY)-(sumX*sumY))/((aux*sumXX)-(sumX*sumX)));
     b=(sumY/aux)-(m*(sumX/aux));
     
     lb.setVisible(true);
     lm.setVisible(true);
     lb.setText("b= "+format.format(b));
     lm.setText("m= "+format.format(m));
        
    }
}

@FXML public void Graphic(ActionEvent ae){
    
        root.getChildren().clear();
    
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("X");
        //creating the chart
        final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
                
        //lineChart.setTitle("CHART");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        
        series.setName("Line");
        
        series.getData().add(new XYChart.Data(0,b));
        series.getData().add(new XYChart.Data(xMax,(m*xMax)+b));

        
        lineChart.getData().add(series);
        
        lineChart.setMaxWidth(300);
        lineChart.setMaxHeight(400);
        
       root.getChildren().add(lineChart);
       
}
    
}