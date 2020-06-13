package coursec;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 0 1 1 0 1 0
 * 1 0 0 1 1 1
 * 0 0 1 0 0 1
 * 1 0 0 1 0 1
 * 0 1 1 1 0 0
 */
public class SwitchProblem {
    //
    char[] initLights = new char[5];
    char[] lights = new char[5];
    char[] result = new char[5];

    public static void main(String[] args) {
        SwitchProblem e = new SwitchProblem();
        e.run();
        //e.test();
    }

    void test(){
/*        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 6; j++) {
                int s = sc.nextInt();
                setBit(initLights,i,j,s);
            }
        }*/
        for (int i = 0; i < 6; i++) {
            if(i%2 == 0)
            initLights[0] = flip(initLights[0],i);
        }
        print(initLights);
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int m = 0;m<t;m++) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 6; j++) {
                    int s = sc.nextInt();
                    setBit(initLights, i, j, s);
                }
            }
            for(int i = 0;i<64;i++){
                char firstSwitch = (char) i;
                result[0]= firstSwitch;
                lights = Arrays.copyOf(initLights,initLights.length);
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 6; k++) {
                        if(getBit(result[j],k) == 1){//只考虑开关摁下时
                            lights[j] = flip(lights[j],k);//改变当前行当前灯泡状态
                            if(k>0){
                                lights[j] = flip(lights[j],k-1);//改变当前行左侧灯泡状态
                            }
                            if(k<5){
                                lights[j] = flip(lights[j],k+1);//改变当前行右侧灯泡状态
                            }
                            if(j<4 ){
                                lights[j+1] = flip(lights[j+1],k);//改变下一行灯泡状态
                            }
                        }
                    }
                    if(j<4){
                        result[j+1] = lights[j];//下一行的开关状态等于当前行灯泡状态
                    }
                }
                if(lights[4] == 0){
                    System.out.println("PUZZLE #"+(m+1));
                    print(result);
                    //print(initLights);
                    //print(lights);
                    break;
                }
            }
        }

        //System.out.println("ending.........");
    }

    public void print(char[] arr){
        for (char c : arr){
            for (int i = 0; i < 6; i++) {
                System.out.print(getBit(c,i));
                if(i != 5){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    //获取第i位
    int getBit(char c,int i){
        return c >> i & 1;
    }

    //设置第i位
    void setBit(char[] arr,int index,int i,int v){
        if(v == 1){
            arr[index] |= 1 << i;
        }else {
            arr[index] &= ~(1 << i);
        }
    }

    //将第i为取反
    char flip(char c,int i){
        return c ^= 1 << i;
    }
}
