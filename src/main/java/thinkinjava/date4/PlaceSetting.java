package thinkinjava.date4;

/**
 * 摆放位置设置
 */
public class PlaceSetting extends Custom{
    Spoon sp;
    Fork frk;
    Knife kn;
    DinnnerPlate pl;

    PlaceSetting(int i) {
        super(i+1);
        sp = new Spoon(i+2);
        frk = new Fork(i+3);
        kn = new Knife(i+4);
        pl = new DinnnerPlate(i+5);
        System.out.println("PlaceSetting Constructor");
    }

    public static void main(String[] args) {
        PlaceSetting x = new PlaceSetting(9);
    }
}

/**
 * 碟子
 */
class Plate{
    Plate(int i){
        System.out.println("Plate Constructor");
    }
}

/**
 * 餐碟
 */
class DinnnerPlate extends Plate{
    DinnnerPlate(int i) {
        super(i);
        System.out.println("DinnerPlate Constructor");
    }
}

/**
 * 器皿
 */
class Utensil{
    Utensil(int i){
        System.out.println("Utensil Constructor");
    }
}

/**
 * 勺子、匙
 */
class Spoon extends Utensil{

    Spoon(int i) {
        super(i);
        System.out.println("Spoon Consructor");
    }
}

/**
 * 叉子
 */
class Fork extends Utensil{

    Fork(int i) {
        super(i);
        System.out.println("Fork Constructor");
    }
}

/**
 * 小刀
 */
class Knife extends Utensil{

    Knife(int i) {
        super(i);
        System.out.println("Knife Constructor");
    }
}
class Custom{
    Custom(int i){
        System.out.println("Custom Constructor");
    }
}

