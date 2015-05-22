package spl.feature.function;

import java.util.ArrayList;

public class CalcBuffer {
    private ArrayList list;
    private double buffer;
    private String input;
    
    public CalcBuffer(){
        buffer = 0;
        list = new ArrayList();
        
    }

    int input(CalcEvent e){
        return 0;
    }
    
    public double getBuffer() {
        return buffer;
    }

    public void setBuffer(double buffer) {
        this.buffer = buffer;
    }
    
}
