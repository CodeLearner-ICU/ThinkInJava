package thinkinjava.date5;

class Shape{
    void draw(){
        System.out.println("Shape.draw()");
    }
}
public class Circle extends Shape{
    void draw(){
        System.out.println("Circle.draw()");
    }

    public static void main(String[] args) {
        Shape s = new Circle();
        //Circle c = (Circle) new Shape();
        s.draw();
        //c.draw();
    }
}
