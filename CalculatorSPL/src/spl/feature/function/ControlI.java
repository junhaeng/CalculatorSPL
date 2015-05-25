package spl.feature.function;

public interface ControlI {
    public int passOperand(double opd);
    public int passOpreation(String ops);
    public double getResult() throws Exception;
    public void flush();
}
