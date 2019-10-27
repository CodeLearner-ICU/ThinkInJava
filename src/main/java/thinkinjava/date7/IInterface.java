package thinkinjava.date7;

public interface IInterface {
    static class Inner{
        int i,j,k;
        public Inner(){
            System.out.println("static inner Construct");
        }
        void f(){
            System.out.println("f()");
        }
    }
}

