package thinkinjava.date4;

/**
 * 甲虫
 */
public class Beetle extends Insect{
    int k = prt("Beetle.k is initialized");
    Beetle(){
        prt("k= "+k);
        prt("j = "+j);
    }
    static int x2 = prt("static Beetle.x2 is initialized");
    static int prt(String s){
        System.out.println(s);
        return 63;
    }

    public static void main(String[] args) {
        prt("Beetle Constructor");
        Beetle b = new Beetle();
    }
}

/**
 * 昆虫
 */
class Insect{
    int i =9;
    int j;
    Insect(){
        prt("i="+i+", j="+j);
        j=39;
    }

    static int x1= prt("static int Insect.x1 initialized");

    static int prt(String s) {
        System.out.println(s);
        return 47;
    }
}
