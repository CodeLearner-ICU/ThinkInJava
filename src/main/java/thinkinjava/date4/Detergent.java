package thinkinjava.date4;

/**
 * 清洁剂
 */
public class Detergent extends Cleanser{
    Detergent(){
        System.out.println("Detergent()");
    }
    public void scrub(){
        append(" Detergent.scrub()");
        super.scrub();
    }
    //泡沫
    public void foam(){
        append(" foam()");
    }

    public static void main(String[] args) {
        System.out.println("Testing Base class:"+Cleanser.name);
        Cleanser.main(args);
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        x.print();

        System.out.println("Testing2 Base class:");
        Cleanser.main(args);
    }
}

/**
 * 清洁用品
 */
class Cleanser{
    public static String name = "feizao";
    Cleanser(){
        System.out.println("Cleanser()");
    }
    private String s = new String("Cleanser");
    public void append(String a){
        s+=a;
    }
    //稀释
    public void dilute(){
        append(" dilute()");
    }
    //涂、应用
    public void apply(){
        append(" apply()");
    }
    //擦洗
    public void scrub(){
        append(" scrub()");
    }
    public void print(){
        System.out.println(s);
    }

    public static void main(String[] args) {
        /*Cleanser c = new Cleanser();
        c.dilute();c.apply();c.scrub();c.print();*/
        System.out.println("main()");
    }
}