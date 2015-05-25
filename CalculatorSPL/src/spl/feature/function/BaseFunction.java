package spl.feature.function;

public class BaseFunction {
    public CalcData add(CalcData op1, CalcData op2) throws ArithmeticException{
        return new CalcData(op1.getData() + op2.getData());
    }
    public CalcData sub(CalcData op1, CalcData op2) throws ArithmeticException{
        return new CalcData(op1.getData() - op2.getData());
    }
    public CalcData mul(CalcData op1, CalcData op2) throws ArithmeticException{
        return new CalcData(op1.getData() * op2.getData());
    }
    public CalcData div(CalcData op1, CalcData op2) throws ArithmeticException{
        return new CalcData((double)op1.getData() / op2.getData());
    }
    public CalcData mod(CalcData op1, CalcData op2) throws ArithmeticException{
        return new CalcData(op1.getData() % op2.getData());
    }
    public CalcData quot(CalcData op1, CalcData op2) throws ArithmeticException{
        return new CalcData((long)op1.getData() / op2.getData());
    }
    
    public double add(double op1, double op2){
        return op1 + op2;
    }
    public double sub(double op1, double op2){
        return op1 - op2;
    }
    public double mul(double op1, double op2){
        return op1 * op2;
    }
    public double div(double op1, double op2){
        return op1 / op2;
    }
    public double mod(double op1, double op2){
        return op1 % op2;
    }
    public double quot(double op1, double op2){
        long sub_result = (long)(op1 / op2);
        return (double)sub_result;
    }
    
}
