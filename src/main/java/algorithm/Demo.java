package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        String[] input = new String[2];
        for(int i=0;i<2;i++){
            Scanner sc = new Scanner(System.in);
            input[i] = sc.nextLine();
        }
        List<String> result = new ArrayList<String>();
        result = split(input);
        for (String s : result){
            System.out.println(s);
        }
    }

    private static List<String> split(String[] input) {
        List<String> result = new ArrayList<>();
        for (String s : input){
            for (int i = 0; i <= (s.length()-1)/8; i++) {
                StringBuilder sb = new StringBuilder(8);
                for (int j = i*8; j < i*8+8 && j<s.length(); j++) {
                    char c = s.charAt(j);
                    sb.append(c);
                }
                System.out.print("sb:"+sb+",sb.length:"+sb.length());
                int rest = 8-sb.length();
                for (int j = 0; j < rest; j++) {
                    sb.append('0');
                }
                System.out.println(",sb.toString:"+sb);
                result.add(sb.toString());
            }
        }
        return result;
    }
}
