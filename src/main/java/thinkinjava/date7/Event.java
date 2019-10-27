package thinkinjava.date7;

public abstract class Event {
    private long evtTime;
    public Event(long longTime){
        evtTime = longTime;
    }
    public boolean ready(){
        return System.currentTimeMillis() >= evtTime;
    }
    abstract public void action();
    abstract public String description();
}
