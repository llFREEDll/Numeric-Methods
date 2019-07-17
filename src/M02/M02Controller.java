/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M02;

import M01.M01Controller;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alfre
 */
public class M02Controller implements Initializable {
    
    @FXML Label polinomio;
    @FXML TextField tfx1;
    @FXML TextField tfx2;
    @FXML TextField tfx3;
    @FXML TextField tfy1;
    @FXML TextField tfy2;
    @FXML TextField tfy3;
    DecimalFormat format = new DecimalFormat("#.0000");//cut decimals
    
    @FXML public void Evaluate(){
        Boolean flag=true;
        Double x1=0.0,x2=0.0,x3=0.0,y1=0.0,y2=0.0,y3=0.0,a,b,c;
        try{
        x1=Double.parseDouble(tfx1.getText());
        y1=Double.parseDouble(tfy1.getText());
        x2=Double.parseDouble(tfx2.getText());
        y2=Double.parseDouble(tfy2.getText());
        x3=Double.parseDouble(tfx3.getText());
        y3=Double.parseDouble(tfy3.getText());
        }catch(Exception ae){
        flag=false;
        }
        
        if(flag){
        // get a b c for a+b(x-x1)+c(x-x1)(x-x2)
        
        a=y1;// on the funtion a+b(x-x1)+c(x-x1)(x-x2) this will be "a"
        
        b=(y2-a)/(x2-x1);// this will be "b"
        
        c=(y3-(a+(b*(x3-x1))))/((x3-x1)*(x3-x2)); //"c"
        
        polinomio.setText("a="+format.format(a)+" b="+format.format(b)+" c="+format.format(c));
        
        Double ind,x;
        String save;
        
        ind=a+(b*x1*-1)+(-1*x1*-1*x2*c);//make a unic inde[endent number or "c"
        x=b+(c*x2*-1)+(c*x1*-1);// add and subtract all items whith "x"
        
        
        save="p(x)="+format.format(c)+"x^2";
        if(x>=0)
            save=save+"+"+format.format(x)+"x";
        else
            save=save+format.format(x)+"x";
        if(ind>=0)
            save=save+"+"+format.format(ind);
        else
            save=save+format.format(ind);
        
        polinomio.setText(polinomio.getText()+"\n"+save);
        }
        else
            polinomio.setText("Input error");
        
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
