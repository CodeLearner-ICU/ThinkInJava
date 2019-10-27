package thinkinjava.date1;

public class Bmw2 extends Bmw {
    /**
     * 定义数据成员，车牌号
     */
    private int number;

    /**
     * 定义数据成员
     */
    private Bmw bmw;

    @Override
    public void start() {
        System.out.println("BMW2 IS STARTING");
    }

    public void stop(){
        System.out.println("BMW2 is stopping");
    }

    public void speed(int v){
        System.out.println("v="+v);
    }
}
