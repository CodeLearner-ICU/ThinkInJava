package exam;

import java.util.Scanner;

public class Solution {
    int[] input = new int[60];
    int size =0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        String x = "";
        for(int i = 0; i < 2; i++){
            x += sc.nextLine();
            x += ',';
        }
        Solution s = new Solution();
        String[] arr = x.split(",");
        s.size = arr.length;
        for (int i = 0; i < arr.length; i++) {
            s.input[i] = Integer.valueOf(arr[i]);
        }
        System.out.println(s.run());
    }

    int run(){
        int sum = 0;
        for (int i : input){
            sum += i;
        }
        int sum1 = sum/2;
        int sum2 = sum - sum1;
        while (!find(sum1,0,size/2)){
            sum1++;
            sum2--;
        }
        return Math.abs(sum1-sum2);
    }

    private boolean find(int sum,int x,int n) {
        if(n == 0){
            if (sum ==0){
                return true;
            }else {
                return false;
            }
        }
        for (int i = x; i < size; i++) {
            int total = sum;
            total -= input[i];
            if(find(total,i+1,n-1)){
                return true;
            }
        }
        return false;
    }

}
