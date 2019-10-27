package thinkinjava.date6;

/**
 * 怪兽
 */
interface Monster{
    //威胁
    void menace();
}
interface DangerousMonster extends Monster{
    void destroy();
}
//致命的
interface Lethal{
    void kill();
}

/**
 * 特斯拉
 */
class DragonZilla implements DangerousMonster{

    public void menace() {

    }

    public void destroy() {

    }
}

/**
 * 吸血鬼
 */
interface Vampire extends DangerousMonster,Lethal{
    void drinkBlood();
}

/**
 * 惊悚
 */
public class HorrorShow {
    static void u (Monster m){m.menace();}
    static void v(DangerousMonster d){
        d.menace();
        d.destroy();
    }

    public static void main(String[] args) {
        DragonZilla d = new DragonZilla();
        u(d);
        v(d);
    }
}
