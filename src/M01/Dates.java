/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M01;

import javafx.beans.property.SimpleStringProperty;


public class Dates {
    private final SimpleStringProperty x;
    private final SimpleStringProperty y;
    private final SimpleStringProperty xy;
    private final SimpleStringProperty xx;
    
    public Dates(String x,String y, String xy, String xx){
    this.x=new SimpleStringProperty(x);
    this.y=new SimpleStringProperty(y);
    this.xy=new SimpleStringProperty(xy);
    this.xx=new SimpleStringProperty(xx);
    }
    
    public String getX(){
        return x.get();
    }
    
    public String getY(){
        return y.get();
    }
    
    public String getXy(){
        return xy.get();
    }
    
    public String getXx(){
        return xx.get();
    }
    
    
}
