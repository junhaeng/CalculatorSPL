package spl.feature.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import spl.feature.function.CalcBuffer;

public class GraphicUI extends JFrame implements ActionListener{

    private JTextArea process_area, result_area;
    private CalcBuffer buffer;
    
    public GraphicUI(){
        
        Container cntPane = this.getContentPane();
        buffer = new CalcBuffer();
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
        numbers[0].addActionListener(this);
        numbers[0].setActionCommand("0");
        
        for(int i=1;i<10;i++){
            numbers[i] = new JButton("" + i);
            numPad.add(numbers[i]);
        }
        numbers[1].addActionListener(this);
        numbers[1].setActionCommand("1");
        numbers[2].addActionListener(this);
        numbers[2].setActionCommand("2");
        numbers[3].addActionListener(this);
        numbers[3].setActionCommand("3");
        numbers[4].addActionListener(this);
        numbers[4].setActionCommand("4");
        numbers[5].addActionListener(this);
        numbers[5].setActionCommand("5");
        numbers[6].addActionListener(this);
        numbers[6].setActionCommand("6");
        numbers[7].addActionListener(this);
        numbers[7].setActionCommand("7");
        numbers[8].addActionListener(this);
        numbers[8].setActionCommand("8");
        numbers[9].addActionListener(this);
        numbers[9].setActionCommand("9");
        
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
        process_area = new JTextArea("process text area");
        result_area = new JTextArea("result text area\n");
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
       GraphicUI mainUI =  new GraphicUI();
       mainUI.addWindowListener(new WindowAdapter(){
           public void windowClosing(WindowEvent windowEvent){
               System.exit(0);
           }
       });
    }
    

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        if(arg0.getActionCommand() =="0"){
            result_area.append("0");
        }else if(arg0.getActionCommand() == "1"){
            result_area.append("1");
        }else if(arg0.getActionCommand() == "2"){
            result_area.append("2");
        }else if(arg0.getActionCommand() == "3"){
            result_area.append("3");
        }else if(arg0.getActionCommand() == "4"){
            result_area.append("4");
        }else if(arg0.getActionCommand() == "5"){
            result_area.append("5");
        }else if(arg0.getActionCommand() == "6"){
            result_area.append("6");
        }else if(arg0.getActionCommand() == "7"){
            result_area.append("7");
        }else if(arg0.getActionCommand() == "8"){
            result_area.append("8");
        }else if(arg0.getActionCommand() == "9"){
            result_area.append("9");
        }else if(arg0.getActionCommand() == "add"){
            
        }else if(arg0.getActionCommand() == "sub"){
            
        }else if(arg0.getActionCommand() == "mul"){
            
        }else if(arg0.getActionCommand() == "div"){
            
        }else if(arg0.getActionCommand() == "mod"){
            
        }else if(arg0.getActionCommand() == "qout"){
            
        }else if(arg0.getActionCommand() == "pow"){
            
        }else if(arg0.getActionCommand() == "log"){
            
        }else if(arg0.getActionCommand() == "inv"){
            
        }else if(arg0.getActionCommand() == "sqrt"){
            
        }
        result_area.updateUI();
    }
}

