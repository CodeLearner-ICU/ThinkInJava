package thinkinjava.date3;

/**
 * 定义一把椅子
 */
public class Chair {
    /**
     * gc运行状态（静态数据，所有创建的椅子共用）
     */
    static boolean gcrun = false;
    /**
     * 是否进行收尾（静态数据，所有创建的椅子共用）
     */
    static boolean f = false;
    /**
     * 创建的椅子数量（静态数据，所有创建的椅子共用）
     */
    static int created = 0;
    /**
     * 进行收尾处理的次数（静态数据，所有创建的椅子共用）
     */
    static int finalized = 0;
    /**
     * 椅子编号
     */
    int no;
    Chair(){
        no = created++;
        if(created == 47 ){
            System.out.println("created is 47");
        }
    }
   /* protected Chair(int marker){

    }*/

    void f(){
        System.out.println("f()");
    }

    protected void finalize(){
        //首次运行gc时打印消息
        if(!gcrun){
            gcrun = true;
            System.out.println("Beginning finalize,Chair:"+no);
        }
        //创建第47把椅子时打印消息
        if(no == 47){
            System.out.println("Last finalize");
            f=true;
        }
        finalized++;
        if(finalized>=created){
            System.out.println("All " + finalized + " finalized");
        }
    }
}
