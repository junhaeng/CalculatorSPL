package spl.feature.function;

public class BaseFunction {
    public CalcData add(CalcData op1, CalcData op2){
        return new CalcData(op1.getData() + op2.getData());
    }
    public CalcData sub(CalcData op1, CalcData op2){
        return new CalcData(op1.getData() - op2.getData());
    }
    public CalcData mul(CalcData op1, CalcData op2){
        return new CalcData(op1.getData() * op2.getData());
    }
    public CalcData div(CalcData op1, CalcData op2){
        return new CalcData((double)op1.getData() / op2.getData());
    }
    public CalcData mode(CalcData op1, CalcData op2){
        return new CalcData(op1.getData() % op2.getData());
    }
    public CalcData qout(CalcData op1, CalcData op2){
        return new CalcData((long)op1.getData() / op2.getData());
    }
}
