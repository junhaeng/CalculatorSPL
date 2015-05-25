package spl.feature.function;

import java.util.ArrayList;

import javax.swing.JTextArea;

public class CalcController implements ControlI{
    private ArrayList list;
    private double prev_result, operand1, operand2;
    private String input;
    private int currentOp;
    private BaseFunction function;
    private JTextArea result_area, process_area;
    
    public CalcController(BaseFunction f, JTextArea r, JTextArea p){
        list = new ArrayList();
        input = "";
        currentOp = 0;
        this.function = f;
        this.result_area = r;
        this.process_area = p;
    }

    public double input(char c){
        switch(c){
        case '0':
            input += "0";
            break;
        case '1':
            input += "1";
            break;
        case '2':
            input += "2";
            break;
        case '3':
            input += "3";
            break;
        case '4':
            input += "4";
            break;
        case '5':
            input += "5";
            break;
        case '6':
            input += "6";
            break;
        case '7':
            input += "7";
            break;
        case '8':
            input += "8";
            break;
        case '9':
            input += "9";
            break;
        case '+':
            if(input!=""){
                operand1 = Double.parseDouble(input);
                currentOp = 1;
                input = "";
            }
            
            break;
        case '*':
            break;
        case '=':
            if(input != ""){
                switch(currentOp){
                case 1:
                    prev_result = function.add(operand1, Double.parseDouble(input));
                    result_area.setText(""+ input + "+" + Double.parseDouble(input) + "=" + prev_result);
                    result_area.updateUI();
                    input = "";
                }
            }
            break;
        }
        return 0;
    }

    @Override
    public int passOperand(double opd) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int passOpreation(String ops) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getResult() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void flush() {
        // TODO Auto-generated method stub
        
    }
    
}
