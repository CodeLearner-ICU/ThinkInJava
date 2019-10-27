package thinkinjava.date5;

interface Instrument5{
    void play();
    int i =5;
}
class Wind5 implements Instrument5{

    public void play() {
        System.out.println("Wind5.play()");
    }
}
public class Music5 {
    static void tune(Instrument5 i){
        i.play();
    }

    public static void main(String[] args) {
        int i = Instrument5.i;
    }
}
