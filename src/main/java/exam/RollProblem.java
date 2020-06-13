package exam;

import java.util.Scanner;

public class RollProblem {
    String input ;
    int[] result = new int[]{1,2,3,4,5,6};

    public static void main(String[] args) {
        RollProblem roll = new RollProblem();
        Scanner sc = new Scanner(System.in);
        roll.input = sc.next();
        roll.run();
    }

    private void run() {
       /* if(input.length() == 0){
            printf();
            return;
        }*/
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c){
                case 'L':
                    int l = result[0];
                    result[0] = result[2];
                    result[1] = result[3];
                    result[2] = result[1];
                    result[3] = l;
                    break;
                case 'R':
                    int r = result[0];
                    result[0]= result[3];
                    result[3]=result[1];
                    result[1]=result[2];
                    result[2]=r;
                    break;
                case 'F':
                    int f = result[2];
                    result[2]= result[4];
                    result[4]=result[3];
                    result[3]=result[5];
                    result[5]=f;
                    break;
                case 'B':
                    int b = result[2];
                    result[2]= result[5];
                    result[5]=result[3];
                    result[3]=result[4];
                    result[4]=b;
                    break;
                case 'A':
                    int a = result[5];
                    result[5]= result[0];
                    result[0]=result[4];
                    result[4]=result[1];
                    result[1]=a;
                    break;
                case 'C':
                    int cc = result[5];
                    result[5]= result[1];
                    result[1]=result[4];
                    result[4]=result[0];
                    result[0]=cc;
                    break;

            }
        }
        printf();
    }

    private void printf() {
        for (int i : result){
            System.out.print(i);
        }
    }


}
