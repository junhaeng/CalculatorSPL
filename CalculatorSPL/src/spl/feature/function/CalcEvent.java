package spl.feature.function;

public class CalcEvent {
    enum Type{
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE,
        ADD, SUB, MUL, MOD, QUOT,
        POW,LOG,INV,SQRT
    }
    private Type eventType;
    private String eventName;
    public Type getEventType() {
        return eventType;
    }
    public void setEventType(Type eventType) {
        this.eventType = eventType;
    }
    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    
    
}
