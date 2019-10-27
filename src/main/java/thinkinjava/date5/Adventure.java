package thinkinjava.date5;

interface CanEveryThing{
    void fight();
    void swim();
    void fly();
    void run();
}
interface CanFight{
    void fight();
}
interface CanSwim{
    void swim();
}
interface CanFly{
    void fly();
}
class ActionCharacter{
    public void fight(){
        System.out.println("ActionCharacter.fight()");
    }
}
class Hero extends ActionCharacter implements CanFight,CanFly,CanSwim,CanEveryThing{

    public void swim() {
        System.out.println("Hero.swim()");
    }

    public void fly() {
        System.out.println("Hero.fly()");
    }

    public void run() {
        System.out.println("Hero.run()");
    }
}
public class Adventure {
    static void t(CanFight x){x.fight();}
    static void u(CanSwim x){x.swim();}
    static void v(CanFly x){x.fly();}
    static void w(ActionCharacter x){x.fight();}

    public static void main(String[] args) {
        Hero i = new Hero();
        i.fly();
        t(i);
        u(i);
        v(i);
        w(i);
    }
}
