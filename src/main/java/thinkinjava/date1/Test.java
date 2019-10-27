package thinkinjava.date1;

public class Test {
    public static void main(String[] args) {
        Bmw car = new Bmw();
        Bmw2 car2 = new Bmw2();
        Test.driveCar(car);
        Test.driveCar(car2);
    }

    public static void driveCar(Bmw bmw){
        bmw.start();
        System.out.println("Tire size is:"+bmw.size+",j=");
    }
}
