package thinkinjava.date5;

public abstract class AbstractClass {
    int i = 1;
    protected abstract void f();
    public static void main(String[] args) {
        ExtendClass extendClass = new ExtendClass() {
            public void f() {
                System.out.println("doSomething:"+i);
            }
        };
        extendClass.f();
    }

}
abstract class ExtendClass extends AbstractClass{
    //abstract void f();

}

