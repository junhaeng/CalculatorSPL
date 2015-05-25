package spl.feature.function;

public class SciFunction extends BaseFunction implements Scientific{

    @Override
    public CalcData pow(CalcData op1, CalcData op2) {
        return new CalcData(Math.pow(op1.getData(), op2.getData()));
    }

    @Override
    public CalcData log(CalcData op1, CalcData op2) {   //op1: x, op2: base
        return new CalcData((long) (Math.log(op1.getData()) / Math.log(op2.getData())));
    }

    @Override
    public CalcData inv(CalcData op1) {
        return new CalcData(1/op1.getData());
    }

    @Override
    public CalcData sqrt(CalcData op1) {
        return new CalcData(Math.sqrt(op1.getData()));
    }

    @Override
    public double pow(double op1, double op2) {
        // TODO Auto-generated method stub
        return Math.pow(op1, op2);
    }

    @Override
    public double log(double op1, double op2) {
        // TODO Auto-generated method stub
        return Math.log(op1)/Math.log(op2);
    }

    @Override
    public double inv(double op1) {
        // TODO Auto-generated method stub
        return 1/op1;
    }

    @Override
    public double sqrt(double op1) {
        // TODO Auto-generated method stub
        return Math.sqrt(op1);
    }

}
