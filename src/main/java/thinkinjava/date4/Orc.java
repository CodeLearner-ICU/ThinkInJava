package thinkinjava.date4;

import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * 兽人
 */
public class Orc extends Villain{
    public Orc(int ii) {
        super(ii);
        j = ii;
    }
    public void change(int x){set(x);}
    private int j;

    public static void main(String[] args) {
        Orc orc = new Orc(9);
        System.out.println("orc:"+orc.read());
    }
}

/**
 * 坏人
 */
class Villain {
    private int i;
    protected int read(){return i;}
    protected void set(int ii){i=ii;}
    public Villain(int ii){i=ii;}
    public int value(int m){ return m*i;}
}
