package spl.feature.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GraphicGUI extends JFrame{

    public GraphicGUI(){
        
        Container cntPane = this.getContentPane();
        
        JPanel result, parentPad, numPad, opPad, extPad;
        
        
        parentPad = new JPanel();
        parentPad.setLayout(new BoxLayout(parentPad, BoxLayout.X_AXIS));
        numPad = new JPanel(new GridLayout(4,3));
        opPad = new JPanel(new GridLayout(4,2));
        extPad = new JPanel(new GridLayout(4,1));

        
        JButton[] numbers = new JButton[10];
        JButton dotBtn = new JButton(".");
        JButton backsBtn = new JButton("<-");
        numbers[0] = new JButton("0");
        for(int i=1;i<10;i++){
            numbers[i] = new JButton("" + i);
            numPad.add(numbers[i]);
        }
        numPad.add(dotBtn);
        numPad.add(numbers[0]);
        numPad.add(backsBtn);
        
        JButton clear,add,sub,mul,div,mod,qout;
        clear = new JButton("Clear");
        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        mod = new JButton("mod");
        qout = new JButton("qout");
        opPad.add(clear);
        opPad.add(add);
        opPad.add(sub);
        opPad.add(mul);
        opPad.add(div);
        opPad.add(mod);
        opPad.add(qout);
        
        JButton pow,log,inv,sqrt;
        pow = new JButton("power");
        log = new JButton("log");
        inv = new JButton("inverse");
        sqrt = new JButton("quot");
        extPad.add(pow);
        extPad.add(log);
        extPad.add(inv);
        extPad.add(sqrt);
        
        
        parentPad.add(numPad);  parentPad.add(opPad);
        /**
         * variability
         */
        parentPad.add(extPad);

        
        result = new JPanel(new BorderLayout());
        JTextArea process_area = new JTextArea("process text area");
        JTextArea result_area = new JTextArea("result text area");
        result.add(process_area, BorderLayout.NORTH);
        result.add(result_area, BorderLayout.CENTER);
        
        
        cntPane.setLayout(new BoxLayout(cntPane, BoxLayout.Y_AXIS));
        cntPane.add(result);
        cntPane.add(parentPad);
        
        
        setTitle("Calulator");
        setSize(500,200);
        setVisible(true);
    }
    public static void main(String[] args){
        new GraphicGUI();
    }
    
     class CalcData{
         
     }
    
}

