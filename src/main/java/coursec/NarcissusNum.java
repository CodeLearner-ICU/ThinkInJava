package coursec;

import java.util.ArrayList;
import java.util.List;

public class NarcissusNum {
    public static void main(String[] args) {
        //int a,b,c;
        List nums = new ArrayList<Integer>();
        for (int a = 1; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                for (int c = 0; c < 10; c++) {
                    if (a*a*a+b*b*b+c*c*c == a*100+b*10+c){
                        nums.add(a*100+b*10+c);
                    }
                }
            }
        }
        System.out.println(nums);
    }
}
