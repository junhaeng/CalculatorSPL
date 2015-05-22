package spl.feature.function;

public interface Scientific {
    public CalcData pow(CalcData op1, CalcData op2);
    public CalcData log(CalcData op1, CalcData op2);
    public CalcData inv(CalcData op1);
    public CalcData sqrt(CalcData op1);
}
