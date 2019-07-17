/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M04;

import javafx.beans.property.SimpleStringProperty;

public class Dates04 {
    private final SimpleStringProperty x;
    private final SimpleStringProperty y;
    private final SimpleStringProperty xy;
    private final SimpleStringProperty xx;
    private final SimpleStringProperty xxx;
    private final SimpleStringProperty xxxx;
    private final SimpleStringProperty x2y;
    
    
    public Dates04(String x,String y, String xx,String xxx,String xxxx,String x2y, String xy){
        
    this.x=new SimpleStringProperty(x);
    this.y=new SimpleStringProperty(y);
    this.xy=new SimpleStringProperty(xy);
    this.xx=new SimpleStringProperty(xx);
    this.xxx=new SimpleStringProperty(xxx);
    this.xxxx=new SimpleStringProperty(xxxx);
    this.x2y=new SimpleStringProperty(x2y);
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
    
    public String getXxx(){
        return xxx.get();
    }
    
    public String getXxxx(){
        return xxxx.get();
    }
    
    public String getX2y(){
        return x2y.get();
    }
}
