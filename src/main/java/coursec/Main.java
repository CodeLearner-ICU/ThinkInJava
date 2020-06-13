package coursec;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String a = "dcabbabacac";
        String b = "bac";
        //System.out.println(inStr(a,b));
        for (int i = 0; i < 3; ++i) {
            System.out.println(i);
        }

    }

    //判断a中是否包含b
    public static int inStr(String a,String b){
        if(b.length() == 0){
            return 0;
        }
        char[] aStr = a.toCharArray();
        char[] bStr = b.toCharArray();
        for (int i = 0; i < aStr.length; i++) {
            int j = 0;
            for (; j < bStr.length; j++) {
                if (aStr[i+j] != bStr[j]){
                    break;
                }/*else if(j == bStr.length - 1 && aStr[i+j] == bStr[j]){
                    return i;
                }*/
            }
            if (j == bStr.length){
                return i;
            }
        }
        return -1;
    }

    public String toString(){
        return "address: "+ super.toString();
    }

    public static String uppercase(String s){
        return s.toUpperCase();
    }

    public static int[] f(int[] a){
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] > a[j]){
                    int x = a[i];
                    a[i] = a[j];
                    a[j] = x;
                }
            }
        }
        return a;
    }
}
