package thinkinjava.date3;

/**
 * 定义一个碗柜
 */
public class CupBoard {
    /**
     * 非静态数据（定义新的碗柜时，同时定义自己的碗）
     */
    Bowl b3 = new Bowl(3);
    {
        int a = 1;
        if(a==1 ){
            System.out.println(true);
        }
    }

    /**
     * 静态数据（所有的碗柜共用标记为4的碗）
     */
    static Bowl b4 = new Bowl(4);

    CupBoard(){
        System.out.println("CupBoard()");
        b4.f(2);
    }

    static void f3(int marker){
        System.out.println("CupBoard::f3("+marker+")");
    }

    static Bowl b5 = new Bowl(5);
}
