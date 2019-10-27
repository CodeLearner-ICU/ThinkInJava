package thinkinjava.date3;

/**
 * 定义一张桌子
 */
public class Table {
    /**
     * 静态数据（所有桌子都共用标记为1的碗）
     */
    static Bowl b1 = new Bowl(1);

    Table(){
        System.out.println("Table()");
        b2.f(1);
    }

    void f2(int marker){
        System.out.println("Table::f2("+marker+")");
    }
    /**
     * 静态数据（所有桌子都共用标记为2的碗）
     */
    static Bowl b2 = new Bowl(2);
}
