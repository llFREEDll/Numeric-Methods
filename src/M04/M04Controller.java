/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M04;

import M01.Dates;
import M01.M01Controller;
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
public class M04Controller implements Initializable {
    
    @FXML TextField tfx=new TextField();
    @FXML TextField tfy=new TextField();
    
    @FXML private TableView<Dates04> table =new TableView();
    @FXML TableColumn<Dates04,String> x;
    @FXML TableColumn<Dates04,String> y;
    @FXML TableColumn<Dates04,String> xy;
    @FXML TableColumn<Dates04,String> xx;
    @FXML TableColumn<Dates04,String> xxx;
    @FXML TableColumn<Dates04,String> xxxx;
    @FXML TableColumn<Dates04,String> x2y;
    ObservableList<Dates04> date;
    @FXML Label show=new Label();
    Boolean flag;
    Double [][]matrix;
    Double [][]matrixGauss;
    List<Double> lx=new ArrayList();
    List<Double> ly=new ArrayList();
    List<Double> lxy=new ArrayList();
    List<Double> lxx=new ArrayList();
    List<Double> lxxx=new ArrayList();
    List<Double> lxxxx=new ArrayList();
    List<Double> lx2y=new ArrayList();
    Double m,b;
    @FXML Button add;
    DecimalFormat format = new DecimalFormat("#.0000");//cut decimals
    
    public void add(){
        
        Double aux=0.0,aux2=0.0,aux3=0.0,aux4=0.0,aux5=0.0;
        Boolean flag=true;
        try{
    aux=Double.parseDouble(tfx.getText())*Double.parseDouble(tfy.getText());// to do x * y and send the date to the class
    aux2=Double.parseDouble(tfx.getText())*Double.parseDouble(tfx.getText());// to do x * x and send the date to the class
    aux3= Double.parseDouble(tfx.getText())*Double.parseDouble(tfx.getText())*Double.parseDouble(tfx.getText());
    aux4=Double.parseDouble(tfx.getText())*Double.parseDouble(tfx.getText())*Double.parseDouble(tfx.getText())*Double.parseDouble(tfx.getText());
    aux5=(Double.parseDouble(tfx.getText())*Double.parseDouble(tfx.getText()))*Double.parseDouble(tfy.getText());
    date.add(new Dates04(tfx.getText(),tfy.getText(),aux2.toString(),aux3.toString(),aux4.toString(),aux5.toString(),aux.toString()));
        }catch(Exception ae){
            flag=false;
            show.setText("INPUT ERROR");
        }
        if(flag){
    lx.add(Double.parseDouble(tfx.getText()));
    ly.add(Double.parseDouble(tfy.getText()));
    lxy.add(aux);
    lxx.add(aux2);
    lxxx.add(aux3);
    lxxxx.add(aux4);
    lx2y.add(aux5);
        }
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        x.setCellValueFactory(new PropertyValueFactory<Dates04,String>("x"));
        y.setCellValueFactory(new PropertyValueFactory<Dates04,String>("y"));
        xy.setCellValueFactory(new PropertyValueFactory<Dates04,String>("xy"));
        xx.setCellValueFactory(new PropertyValueFactory<Dates04,String>("xx"));
        xxx.setCellValueFactory(new PropertyValueFactory<Dates04,String>("xxx"));
        xxxx.setCellValueFactory(new PropertyValueFactory<Dates04,String>("xxxx"));
        x2y.setCellValueFactory(new PropertyValueFactory<Dates04,String>("x2y"));
        
        date=FXCollections.observableArrayList();
        
        
        table.setItems(date);
    }
@FXML public void Evaluate(){

    add.setVisible(false);
    matrixGauss=new Double[3][4];
    Integer aux=table.getItems().size();
    matrix=new Double[table.getItems().size()][7]; // declating the matrix size
    for(int i=0;i<table.getItems().size();i++){// add every date on table to the matrix
        matrix[i][0]=lx.get(i);
        matrix[i][1]=ly.get(i);
        matrix[i][2]=lxx.get(i);
        matrix[i][3]=lxxx.get(i);
        matrix[i][4]=lxxxx.get(i);
        matrix[i][5]=lx2y.get(i);
        matrix[i][6]=lxy.get(i);
    }
    
    Double sumX=0.0,sumY=0.0,sumXY=0.0,sumXX=0.0,sumXXX=0.0,sumXXXX=0.0,sumX2Y=0.0; //do the think
    for(int i=0;i<aux;i++){
     sumX=sumX+matrix[i][0];
     sumY=sumY+matrix[i][1];
     sumXX=sumXX+matrix[i][2];
     sumXXX=sumXXX+matrix[i][3];
     sumXXXX=sumXXXX+matrix[i][4];
     sumX2Y=sumX2Y+matrix[i][5];
     sumXY=sumXY+matrix[i][6];
     }
    
    //Do Gauss Jordan
    
    matrixGauss[0][0]=sumXX;
    matrixGauss[0][1]=sumX;
    matrixGauss[0][2]=aux.doubleValue();
    matrixGauss[0][3]=sumY;
    
    matrixGauss[1][0]=sumXXX;
    matrixGauss[1][1]=sumXX;
    matrixGauss[1][2]=sumX;
    matrixGauss[1][3]=sumXY;
    
    matrixGauss[2][0]=sumXXXX;
    matrixGauss[2][1]=sumXXX;
    matrixGauss[2][2]=sumXX;
    matrixGauss[2][3]=sumX2Y;
    
    //Triangulate the matrix
        
            Double []plus=new Double[4];             
            //a31
            if(matrixGauss[2][0]!=0){
            for(int i=0;i<4;i++){
                plus[i]=(-1*matrixGauss[0][0]*matrixGauss[2][i]);
                plus[i]=plus[i]+(matrixGauss[2][0]*matrixGauss[0][i]);
                System.out.println(plus[i]);
            }
            for(int i=0;i<4;i++)
                matrixGauss[2][i]=plus[i];
            }
            //a32
            if(matrixGauss[2][1]!=0){
            for(int i=0;i<4;i++)
                plus[i]=0.0;
            for(int i=0;i<4;i++){
                plus[i]=(-1*matrixGauss[1][0]*matrixGauss[0][i]);
                plus[i]=plus[i]+(matrixGauss[0][0]*matrixGauss[1][i]);
                System.out.println(plus[i]);
            }
            for(int i=0;i<4;i++)
                matrixGauss[1][i]=plus[i];
            }
            //a32
            if(matrixGauss[2][1]!=0){
            for(int i=0;i<4;i++)
                plus[i]=0.0;
            for(int i=0;i<4;i++){
                plus[i]=(-1*matrixGauss[2][1]*matrixGauss[1][i]);
                plus[i]=plus[i]+(matrixGauss[1][1]*matrixGauss[2][i]);
                System.out.println(plus[i]);
            }
            for(int i=0;i<4;i++)
                matrixGauss[2][i]=plus[i];
            }
            //get z
           // if(matrix[2][2]!=0){
            matrixGauss[2][3]=matrixGauss[2][3]/matrixGauss[2][2];
            matrixGauss[2][2]=1.0;
            //}else
            //a13
            if(matrixGauss[0][2]!=0){
            for(int i=0;i<4;i++)
                plus[i]=0.0;
            for(int i=0;i<4;i++){
                plus[i]=(-1*matrixGauss[2][2]*matrixGauss[0][i]);
                plus[i]=plus[i]+(matrixGauss[0][2]*matrixGauss[2][i]);
                System.out.println(plus[i]);
            }
            for(int i=0;i<4;i++)
                matrixGauss[0][i]=plus[i];
            }
            //a23
            if(matrixGauss[1][2]!=0){
            for(int i=0;i<4;i++)
                plus[i]=0.0;
            for(int i=0;i<4;i++){
                plus[i]=(-1*matrixGauss[2][2]*matrixGauss[1][i]);
                plus[i]=plus[i]+(matrixGauss[1][2]*matrixGauss[2][i]);
                System.out.println(plus[i]);
            }          
            for(int i=0;i<4;i++)
                matrixGauss[1][i]=plus[i];
            }
            //gex y
            
            matrixGauss[1][3]=matrixGauss[1][3]/matrixGauss[1][1];
            matrixGauss[1][1]=1.0;
            //a12
            if(matrixGauss[0][1]!=0){
            for(int i=0;i<4;i++)
                plus[i]=0.0;
            for(int i=0;i<4;i++){
                plus[i]=(-1*matrixGauss[1][1]*matrixGauss[0][i]);
                plus[i]=plus[i]+(matrixGauss[0][1]*matrixGauss[1][i]);
                System.out.println(plus[i]);
            }          
            for(int i=0;i<4;i++)
                matrixGauss[0][i]=plus[i];
            }
            //get x
            matrixGauss[0][3]=matrixGauss[0][3]/matrixGauss[0][0];
            matrixGauss[0][0]=1.0;
    
            //show f(x) funtion
            
            String fx;
            Double aux2;
            aux2=matrixGauss[0][3];
            fx=format.format(aux2)+"x^2";
            
            
            aux2=matrixGauss[1][3];
           
            if(matrixGauss[1][3]>=0)
                fx=fx+"+"+format.format(aux2)+"x";
            else
                fx=fx+format.format(aux2)+"x";
            
            
            aux2=matrixGauss[2][3];
            //format.format(aux2);
            if(matrixGauss[2][3]>=0)
                fx=fx+"+"+format.format(aux2);
            else
                fx=fx+format.format(aux2);
            
            show.setText("f(x)="+fx);
    
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
                
                Logger.getLogger(M01Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
