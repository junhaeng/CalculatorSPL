package spl.feature.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import spl.feature.function.ControlI;
import spl.feature.function.Controller;
import spl.feature.function.SciFunction;

public class GraphicUI extends JFrame implements ActionListener{

    private JTextArea process_area, result_area;
    private ControlI controller;
    
    private String input_buffer;
    private boolean compute_end;
    private ArrayList<String> last_input; //0 is initial state, -1: result, 1:add 2:sub 3:mul 100:number 1000: -(signiture)
    
    public GraphicUI(){
        
        Container cntPane = this.getContentPane();
        JPanel result, parentPad, numPad, opPad, extPad;
        
        input_buffer = "";
        compute_end = false;
        last_input = new ArrayList<String>();
        last_input.add("init");
        
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
        dotBtn.addActionListener(this);
        dotBtn.setActionCommand(".");
        
        numPad.add(dotBtn);
        numPad.add(numbers[0]);
        numPad.add(backsBtn);
        
        JButton clear,add,sub,mul,div,mod,quot,rest;
        clear = new JButton("Clear");
        rest = new JButton("=");
        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        mod = new JButton("mod");
        quot = new JButton("quot");
        
        
        rest.addActionListener(this);
        rest.setActionCommand("result");
        add.addActionListener(this);
        add.setActionCommand("add");
        sub.addActionListener(this);
        sub.setActionCommand("sub");
        mul.addActionListener(this);
        mul.setActionCommand("mul");
        div.addActionListener(this);
        div.setActionCommand("div");
        clear.addActionListener(this);
        clear.setActionCommand("clear");
        mod.addActionListener(this);
        mod.setActionCommand("mod");
        quot.addActionListener(this);
        quot.setActionCommand("quot");
        
        opPad.add(clear);
        opPad.add(rest);
        opPad.add(add);
        opPad.add(sub);
        opPad.add(mul);
        opPad.add(div);
        opPad.add(mod);
        opPad.add(quot);
        
        
        
        JButton pow,log,inv,sqrt;
        pow = new JButton("power");
        log = new JButton("log");
        inv = new JButton("inverse");
        sqrt = new JButton("quot");
        extPad.add(pow);
        extPad.add(log);
        extPad.add(inv);
        extPad.add(sqrt);
        
        pow.addActionListener(this);
        pow.setActionCommand("pow");
        log.addActionListener(this);
        log.setActionCommand("log");
        inv.addActionListener(this);
        inv.setActionCommand("inv");
        sqrt.addActionListener(this);
        sqrt.setActionCommand("sqrt");
        
        
        
        parentPad.add(numPad);  parentPad.add(opPad);
        /**
         * variability
         */
        parentPad.add(extPad);

        
        result = new JPanel(new BorderLayout());
        process_area = new JTextArea("");
        result_area = new JTextArea("");
        result.add(process_area, BorderLayout.NORTH);
        result.add(result_area, BorderLayout.CENTER);
        
        
        cntPane.setLayout(new BoxLayout(cntPane, BoxLayout.Y_AXIS));
        cntPane.add(result);
        cntPane.add(parentPad);
        
    }
    public static void main(String[] args){
       GraphicUI mainUI =  new GraphicUI();
       mainUI.addWindowListener(new WindowAdapter(){
           public void windowClosing(WindowEvent windowEvent){
               System.exit(0);
           }
       });
       //ControlI controller = new Controller(new BaseFunction());
       ControlI controller = new Controller(new SciFunction());
       mainUI.setController(controller);
       try {
        mainUI.UIstart();
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
    

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(arg0.getActionCommand() =="0"){
            if(compute_end){
                controller.flush();
                result_area.setText("");
                process_area.setText("");
                compute_end = false;
            }
            process_area.append("0");
            input_buffer += "0";
            last_input.add("0");
        }else if(arg0.getActionCommand() == "1"){
            if(compute_end){
                controller.flush();
                result_area.setText("");
                process_area.setText("");
                compute_end = false;
            }
            process_area.append("1");
            input_buffer += "1";
            last_input.add("1");
        }else if(arg0.getActionCommand() == "2"){
            if(compute_end){
                controller.flush();
                result_area.setText("");
                process_area.setText("");
                compute_end = false;
            }
            process_area.append("2");
            input_buffer += "2";
            last_input.add("2");
        }else if(arg0.getActionCommand() == "3"){
            if(compute_end){
                controller.flush();
                result_area.setText("");
                process_area.setText("");
                compute_end = false;
            }
            process_area.append("3");
            input_buffer += "3";
            last_input.add("3");
        }else if(arg0.getActionCommand() == "4"){
            if(compute_end){
                controller.flush();
                result_area.setText("");
                process_area.setText("");
                compute_end = false;
            }
            process_area.append("4");
            input_buffer += "4";
            last_input.add("4");
        }else if(arg0.getActionCommand() == "5"){
            if(compute_end){
                controller.flush();
                result_area.setText("");
                process_area.setText("");
                compute_end = false;
            }
            process_area.append("5");
            input_buffer += "5";
            last_input.add("5");
        }else if(arg0.getActionCommand() == "6"){
            if(compute_end){
                controller.flush();
                result_area.setText("");
                process_area.setText("");
                compute_end = false;
            }
            process_area.append("6");
            input_buffer += "6";
            last_input.add("6");
        }else if(arg0.getActionCommand() == "7"){
            if(compute_end){
                controller.flush();
                result_area.setText("");
                process_area.setText("");
                compute_end = false;
            }
            process_area.append("7");
            input_buffer += "7";
            last_input.add("7");
        }else if(arg0.getActionCommand() == "8"){
            if(compute_end){
                controller.flush();
                result_area.setText("");
                process_area.setText("");
                compute_end = false;
            }
            process_area.append("8");
            input_buffer += "8";
            last_input.add("8");
        }else if(arg0.getActionCommand() == "9"){
            if(compute_end){
                controller.flush();
                result_area.setText("");
                process_area.setText("");
                compute_end = false;
            }
            process_area.append("9");
            input_buffer += "9";
            last_input.add("9");
        }else if(arg0.getActionCommand() == "add"){
            String last = last_input.get(last_input.size()-1);
            if(last == "init" || last == "add" ) return;
            if(compute_end){
                process_area.setText(result_area
                        .getText() + "+");
                controller.passOpreation("add");
                last_input.add("add");
                compute_end = false;
            }
            else{
                if(input_buffer != ""){
                    controller.passOperand(Double.parseDouble(input_buffer));
                }
                if(controller.passOpreation("add") == -1){
                    process_area.setText(process_area.getText().substring(0,process_area.getText().length()-1) + "+");
                    last_input.add("add");
                }else{
                    process_area.append("+");
                    last_input.add("add");
                }
                try {
                    result_area.setText("" + controller.getResult());
                } catch (Exception e) {
                }
            }
            input_buffer = "";
        }else if(arg0.getActionCommand() == "result"){
            String last = last_input.get(last_input.size()-1);
            if(last == "init") return;
            if(input_buffer != ""){
                controller.passOperand(Double.parseDouble(input_buffer));
            }
            if(controller.passOpreation("result") == -1){
                process_area.setText(process_area.getText().substring(0,process_area.getText().length()-1) + "=");
            }else{
                process_area.append("=");                
            }
            try {
                result_area.setText("" + controller.getResult());
            } catch (Exception e) {
            }
            input_buffer = "";
            last_input.add("result");
            compute_end = true;

        }else if(arg0.getActionCommand() == "sub"){
            String last = last_input.get(last_input.size()-1);
            if(compute_end){
                process_area.setText(result_area.getText() + "-");
                compute_end = false;
                controller.passOpreation("sub");
                last_input.add("sub");
                input_buffer = "";

            }else if(last == "init" || last == "mul" || last == "div"){
                input_buffer = "-";
                process_area.append("-");
                last_input.add("-");
            }else if(last == "-"){
                // remove - from input buffer
                input_buffer = "";
//                process_area.setText(process_area.getText().substring(0,process_area.getText().length()-1));
                process_area.setText(process_area.getText().substring(0,process_area.getText().length()-1));
                last_input.remove(last_input.size()-1);
            }else{
                if(input_buffer != ""){
                    controller.passOperand(Double.parseDouble(input_buffer));
                }
                if(controller.passOpreation("sub") == -1){
                    process_area.setText(process_area.getText().substring(0,process_area.getText().length()-1) + "-");
                }else{
                    process_area.append("-");                                        
                }
                last_input.add("sub");
                input_buffer = "";
            }
        }
        else if(arg0.getActionCommand() == "mul"){
            String last = last_input.get(last_input.size()-1);
            if(last == "mul" || last =="init") return;
            if(compute_end){
                process_area.setText(result_area
                        .getText() + "*");
                controller.passOpreation("mul");
                compute_end = false;
                last_input.add("mul");
            }
            else{
                if(input_buffer != ""){
                    controller.passOperand(Double.parseDouble(input_buffer));
                }
                if(controller.passOpreation("mul") == -1){
                    process_area.setText(process_area.getText().substring(0,process_area.getText().length()-1) + "*");
                }else{
                    process_area.append("*");                    
                }
                try {
                    result_area.setText("" + controller.getResult());
                } catch (Exception e) {
                }
                last_input.add("mul");
            }
            input_buffer = "";
            
        }else if(arg0.getActionCommand() == "div"){
            String last = last_input.get(last_input.size()-1);
            if(last == "div" || last =="init") return;
            if(compute_end){
                process_area.setText(result_area
                        .getText() + "/");
                controller.passOpreation("div");
                compute_end = false;
                last_input.add("div");
            }
            else{
                if(input_buffer != ""){
                    controller.passOperand(Double.parseDouble(input_buffer));
                }
                if(controller.passOpreation("div") == -1){
                    process_area.setText(process_area.getText().substring(0,process_area.getText().length()-1) + "/");
                }else{
                    process_area.append("/");                    
                }
                try {
                    result_area.setText("" + controller.getResult());
                } catch (Exception e) {
                }
                last_input.add("div");
            }
            input_buffer = "";
            
        }else if(arg0.getActionCommand() == "mod"){
            String last = last_input.get(last_input.size()-1);
            if(last == "mod" || last =="init") return;
            if(compute_end){
                process_area.setText(result_area
                        .getText() + "%");
                controller.passOpreation("mod");
                compute_end = false;
                last_input.add("mod");
            }
            else{
                if(input_buffer != ""){
                    controller.passOperand(Double.parseDouble(input_buffer));
                }
                if(controller.passOpreation("mod") == -1){
                    process_area.setText(process_area.getText().substring(0,process_area.getText().length()-1) + "%");
                }else{
                    process_area.append("%");                    
                }
                try {
                    result_area.setText("" + controller.getResult());
                } catch (Exception e) {
                }
                last_input.add("mod");
            }
            input_buffer = "";
            
        }else if(arg0.getActionCommand() == "quot"){
            String last = last_input.get(last_input.size()-1);
            if(last == "quot" || last =="init") return;
            if(compute_end){
                process_area.setText(result_area
                        .getText() + "q");
                controller.passOpreation("quot");
                compute_end = false;
                last_input.add("quot");
            }
            else{
                if(input_buffer != ""){
                    controller.passOperand(Double.parseDouble(input_buffer));
                }
                if(controller.passOpreation("quot") == -1){
                    process_area.setText(process_area.getText().substring(0,process_area.getText().length()-1) + "q");
                }else{
                    process_area.append("q");                    
                }
                try {
                    result_area.setText("" + controller.getResult());
                } catch (Exception e) {
                }
                last_input.add("quot");
            }
            input_buffer = "";
            
        }else if(arg0.getActionCommand() == "pow"){
            String last = last_input.get(last_input.size()-1);
            if(last == "pow" || last =="init") return;
            if(compute_end){
                process_area.setText(result_area
                        .getText() + "^");
                controller.passOpreation("pow");
                compute_end = false;
                last_input.add("pow");
            }
            else{
                if(input_buffer != ""){
                    controller.passOperand(Double.parseDouble(input_buffer));
                }
                if(controller.passOpreation("pow") == -1){
                    process_area.setText(process_area.getText().substring(0,process_area.getText().length()-1) + "^");
                }else{
                    process_area.append("^");                    
                }
                try {
                    result_area.setText("" + controller.getResult());
                } catch (Exception e) {
                }
                last_input.add("pow");
            }
            input_buffer = "";
            
        }else if(arg0.getActionCommand() == "log"){
            String last = last_input.get(last_input.size()-1);
            if(last == "log" || last =="init") return;
            if(compute_end){
                process_area.setText(result_area
                        .getText() + " log based ");
                controller.passOpreation("log");
                compute_end = false;
                last_input.add("log");
            }
            else{
                if(input_buffer != ""){
                    controller.passOperand(Double.parseDouble(input_buffer));
                }
                if(controller.passOpreation("log") == -1){
                    process_area.setText(process_area.getText().substring(0,process_area.getText().length()-1) + " log based ");
                }else{
                    process_area.append(" log based ");                    
                }
                try {
                    result_area.setText("" + controller.getResult());
                } catch (Exception e) {
                }
                last_input.add("log");
            }
            input_buffer = "";
            
        }else if(arg0.getActionCommand() == "inv"){
            String last = last_input.get(last_input.size()-1);
            if(last =="init") return;
            if(compute_end){
                process_area.setText(result_area
                        .getText() + "^-1");
                controller.passOpreation("inv");
                compute_end = false;
                last_input.add("inv");
                try {
                    result_area.setText("" + controller.getResult());
                } catch (Exception e) {
                }
            }
            else{
                if(input_buffer != ""){
                    controller.passOperand(Double.parseDouble(input_buffer));
                }
                if(controller.passOpreation("inv") == -1){
                    process_area.setText(process_area.getText().substring(0,process_area.getText().length()-1) + "^-1");
                }else{
                    process_area.append("^-1");                    
                }
                try {
                    result_area.setText("" + controller.getResult());
                } catch (Exception e) {
                }
                last_input.add("inv");
            }
            input_buffer = "";
            
        }else if(arg0.getActionCommand() == "sqrt"){
            String last = last_input.get(last_input.size()-1);
            if(last =="init") return;
            if(compute_end){
                process_area.setText(result_area
                        .getText() + "SQRT");
                controller.passOpreation("sqrt");
                compute_end = false;
                last_input.add("sqrt");
                try {
                    result_area.setText("" + controller.getResult());
                } catch (Exception e) {
                }
            }
            else{
                if(input_buffer != ""){
                    controller.passOperand(Double.parseDouble(input_buffer));
                }
                if(controller.passOpreation("sqrt") == -1){
                    process_area.setText(process_area.getText().substring(0,process_area.getText().length()-1) + "SQRT");
                }else{
                    process_area.append("SQRT");                    
                }
                try {
                    result_area.setText("" + controller.getResult());
                } catch (Exception e) {
                }
                last_input.add("sqrt");
            }
            input_buffer = "";
            
            
        }else if(arg0.getActionCommand() == "clear"){
            process_area.setText("");
            result_area.setText("");
            controller.flush();
            input_buffer = "";
            compute_end = false;
            last_input.clear();
            
        }
        result_area.updateUI();
    }
    
    JTextArea getResultView(){
        return this.result_area;
    }
    
    JTextArea getProessView(){
        return this.process_area;
    }
    
    public void setController(ControlI c){
        this.controller = c;
    }
    
    public void UIstart() throws Exception{
        if(controller == null){
            throw new Exception("No connect to controller");
        }else{
            setTitle("Calulator");
            setSize(500,200);
            setVisible(true);
        }
    }
    

}

