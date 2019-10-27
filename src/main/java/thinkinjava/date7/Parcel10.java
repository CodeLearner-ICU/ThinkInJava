package thinkinjava.date7;

abstract class Contents{
    abstract public int value();
}
interface Destination{
    String readLabel();
}

public class Parcel10 {
    private String name;
    public Parcel10(){
        System.out.println("Parcel10 Construct");
    }
    private static class PContents extends Contents{
        private int i = 11;
        public int value() {
            return i;
        }
    }
    protected static class PDestination implements Destination{
        public static int test = 10;
        private String label;
        private PDestination(String whereTo){
            label = whereTo;
        }
        public static void f(){
            System.out.println("static f()");
        }
        public String readLabel() {
            return label;
        }
    }
    public static Destination dest(String s){
        return new PDestination(s);
    }
    public static Contents cont(){
        return new PContents();
    }

    public static void main(String[] args) {
        Contents c = cont();
        Destination d = dest("Tanzania");
        PDestination.f();
        System.out.println("test:"+PDestination.test);
    }
}
