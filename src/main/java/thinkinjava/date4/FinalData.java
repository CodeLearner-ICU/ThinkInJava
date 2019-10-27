package thinkinjava.date4;

/**
 * final关键字的用法
 */
class Value{
    int i = 1;
}
public class FinalData {
    final int i1 = 9;
    static final int I2 =99;
    public static final int I3 = 49;
    final int i4 = (int)(Math.random()*20);
    static final int i5 = (int)(Math.random()*20);

    Value v1 = new Value();
    final Value v2= new Value();
    static final Value v3 = new Value();

    final int[] a = {1,2,3,4,5,6};

    public void print(String id){
        System.out.println(id + ": i4="+i4+", : i5="+i5);
    }

    public static void main(String[] args) {
        FinalData finalData = new FinalData();
        finalData.v2.i++;
        finalData.v1 = new Value();
        for(int i=0;i<finalData.a.length;i++){
            finalData.a[i]++;
        }
        finalData.print("fdl");
        System.out.println("Creating new FinalData");

        FinalData fd2 = new FinalData();
        finalData.print("fd1");
        fd2.print("fd2");
    }
}
