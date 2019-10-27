package thinkinjava.date3;

public class Soup {
    private Soup(){}
    public static Soup makeSoup(){
        return new Soup();
    }
    private static Soup psl = new Soup();
    public static Soup access(){
        return psl;
    }
    public void f(){}
}
class SandWich{
    void f(){new Lunch();}
}

