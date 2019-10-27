package thinkinjava.date8;

class Meal{
    Meal(){
        System.out.println("Meal()");
    }
}
class Bread{
    Bread(){
        System.out.println("Bread()");
    }
}
class Cheese{
    Cheese(){
        System.out.println("Cheese()");
    }
}
class Lettuce{
    Lettuce(){
        System.out.println("Lettuce()");
    }
}
class Lunch extends Meal{
    Lunch(Bread bread){
        System.out.println("Lunch()");
    }
}
class PortableLunch extends Lunch{
    PortableLunch(Bread b){
        super(b);
        System.out.println("PortableLunch()");
    }
}

public class Sandwich extends PortableLunch{
    Bread b = new Bread();
    Cheese c = new Cheese();
    Sandwich(){
        super(new Bread());
        System.out.println("Sandwich()");
    }

    public static void main(String[] args) {
        new Sandwich();
    }
}
