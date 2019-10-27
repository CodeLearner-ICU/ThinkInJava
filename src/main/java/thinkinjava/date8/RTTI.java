package thinkinjava.date8;

class Useful{
    public void f(){System.out.println("Useful.f()");}
    public void g(){System.out.println("Useful.g()");}
}
class MoreUseful extends Useful{
    public void f(){
        System.out.println("MoreUseful.f()");
    }
    public void g(){
        System.out.println("MoreUseful.g()");
    }
    public void u(){
        System.out.println("u()");
    }
    public void v(){}
    public void w(){}
}
public class RTTI {
    public static void main(String[] args) {
        Useful[] x = {
                new Useful(),
                new MoreUseful()
        };
        x[0].f();
        x[1].g();

        ((MoreUseful)x[1]).u();//Downcast/RTTI
        ((MoreUseful)x[0]).u();//Exception thrown
    }
}
