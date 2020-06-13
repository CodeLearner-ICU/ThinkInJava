/*
package exam;

import java.util.HashSet;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Caculator caculator = new Caculator(in.next());
        System.out.println(caculator.run());
    }
}
class Caculator{
    private HashSet<Character> numbers = new HashSet<Character>();
    private HashSet<Character> operators = new HashSet<Character>();
    private String[] nums;
    private Character[] operator = new Character[10000];
    private String input;
    public Caculator(String input){

        numbers.add('1');
        numbers.add('2');
        numbers.add('3');
        numbers.add('4');
        numbers.add('5');
        numbers.add('6');
        numbers.add('7');
        numbers.add('8');
        numbers.add('9');
        numbers.add('0');
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');
        this.input = input;
        initParams();
    }

    private void initParams(){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if(c == '-' && i==0){
                sb.append(c);
            }else if(numbers.contains(c)){
                sb.append(c);
            }else if(operators.contains(c)){
                sb.append(',');
                //operator.a;
            }else{

            }
        }
        nums = sb.toString().split(",");
    }

    public String run(){
        if(nums[0] == null || nums[1] == null || operator==null){
            return null;
        }
        long result=0;
        switch (operator){
            case '+': result=nums[0]+nums[1];break;
            case '-': result=nums[0]-nums[1];break;
            case '*': result=nums[0]*nums[1];break;
            case '/': result=nums[0]/nums[1];break;
            default: return null;
        }
        return String.valueOf(result);
    }


}
*/
