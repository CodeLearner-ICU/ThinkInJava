package exam;

import java.util.Scanner;

/**
 * 计算器（表达式求值，递归实现）
 */
public class CalculateProblem {
    String input ;//输入连续的算术表达式
    int index = 0;//输入的字符下标
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalculateProblem cal = new CalculateProblem();
        while ((cal.input =sc.next()) !="exit"){
            cal.index = 0;
            System.out.println(cal.expressionValue());
        }

    }
    //表达式（包含项、+、-）=项+项-项....，返回结果即为所求的值
    int expressionValue(){
        int result = termValue();//取出项的值
        boolean more = true;//判断是否有多项
        while (more){
            if (index>=input.length())break;//如果上一项已经取到结尾则跳出
            char c = input.charAt(index);//查看当前字符，未取出
            if(c == '+' || c == '-'){
                index++;//取走当前字符
                int value = termValue();//取出下一项的值
                if(c=='+'){
                    result +=value;
                }else {
                    result -= value;
                }
            }else {
                more = false;
            }
        }
        return result;
    }

    //项（包含因子、*、/）=因子*因子/因子.....，返回项的值
    private int termValue() {
        int result = factorValue();//取第一个因子的值
        boolean more = true;
        while (more){
            if (index>=input.length())break;
            char c = input.charAt(index);
            if(c == '*' || c =='/'){
                index ++;//取走当前字符
                int value = factorValue();//取下一个因子的值
                if(c=='*'){
                    result *= value;
                }else {
                    result /= value;
                }
            }else {
                more = false;
            }
        }
        return result;
    }

    //因子（分为 数、表达式）=数或者因子=(表达式的值)，返回因子的值
    private int factorValue() {
        int result = 0;
        boolean more = true;
        while (more){
            if (index>=input.length())break;
            char c = input.charAt(index);
            if(c == '('){
                index++;//取走左括号
                result = expressionValue();//取表达式的值
                index++;//取走右括号
            }else if(isNum(c)){
                index++;//取走当前数字
                result = 10*result + c - '0';
            }else {
                more=false;
            }
        }
        return result;
    }

    //判断字符是否是数字
    private boolean isNum(char c) {
        if(c-'0'>=0 && c-'0'<10){
            return true;
        }
        return false;
    }
}
