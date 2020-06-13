package exam;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Count24 {
    List<StringBuilder> result = new ArrayList<>(100);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Count24 count24 = new Count24();
        while (true){
            double[] test = new double[4];
            for (int i = 0; i < 4; i++) {
                test[i] = sc.nextInt();
            }
            count24.isTwentyFour(test,4,new StringBuilder());
            System.out.println(count24.result);
            count24.result.clear();
        }
    }

    void isTwentyFour(double[] a,double n,StringBuilder sb){
        if(n == 1){
            if(isZero(a[0],24)){
                result.add(sb);
            }
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            if(n == 4){
                sb.append(a[i]);
            }
            for (int j = i+1; j < n; j++) {
                double[] b = new double[5];
                int m =1;
                for (int k = 0; k < n; k++) {
                    if (k!=i && k!=j){
                        b[m] = a[k];
                        m++;
                    }
                }
                b[0] = a[i] + a[j];
                isTwentyFour(b,n-1,new StringBuilder().append(sb).append('+').append(a[j]));
                b[0] = a[i] - a[j];
                isTwentyFour(b,n-1,new StringBuilder().append(sb).append('-').append(a[j]));
                b[0] = a[i] * a[j];
                isTwentyFour(b,n-1,new StringBuilder().append(sb).append('*').append(a[j]));
                b[0] = a[i] / a[j];
                isTwentyFour(b,n-1,new StringBuilder().append(sb).append('÷').append(a[j]));
                b[0] = a[j] - a[i];
                isTwentyFour(b,n-1,new StringBuilder().append(a[j]).append('-').append(sb));
                b[0] = a[j] / a[i];
                isTwentyFour(b,n-1,new StringBuilder().append(a[j]).append('÷').append(sb));
            }
        }
    }

    boolean isZero(double a,double b){
        if (Math.abs(a-b)<0.001){
            return true;
        }
        return false;
    }
}
