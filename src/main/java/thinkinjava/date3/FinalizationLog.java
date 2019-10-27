package thinkinjava.date3;

public class FinalizationLog {
    public void finalize(){
        System.out.println("running finalize");
    }
}
