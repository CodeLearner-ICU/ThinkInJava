package algorithm;

import java.util.*;
import java.util.List;

public class Main {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNode (ListNode head, int n) {
        int size =0;
        ListNode cur = head;
        while (cur != null){
            size++;
            cur = cur.next;
        }
        if (size == n) return head.next;
        ListNode pre = new ListNode(0);
        pre.next = head;
        for (int i = 0; i < size - n ; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }
        public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] arr= str.split(",");
        int min = minimumLengthEncoding(arr);
        System.out.println(min);
        solution(arr);
    }

    public String reverseWords(String s) {
        char[] words = s.toCharArray();

        //翻转字符串
        reverse(words,0,s.length()-1);

        //翻转每个单词
        int start=0;
        int end =0;
        while (end < s.length()){
            while (start < s.length() && words[start] == ' '){
                start++;
            }
            end = start;
            while (end < s.length() && words[end] != ' '){
                end ++;
            }
            reverse(words,start,end-1);
            start = end;
        }

        //去除空格
        int i=0,j=0;
        while (j < s.length()) {
            while (j < s.length() && words[j] == ' '){
                j++;
            }
            while (j < s.length() && words[j] != ' '){
                words[i++] = words[j++];
            }
            while (j < s.length() && words[j] == ' '){
                j++;
            }
            if (j < s.length()){
                words[i++] = ' ';
            }
        }
        return new String(words).substring(0,i);
    }

    private void reverse(char[] words, int i, int j) {
        while (i<j){
            char tmp = words[i];
            words[i] = words[j];
            words[j] = tmp;
            i++;
            j--;
        }
    }

    private static void solution(String[] arr){
        //Scanner sc = new Scanner(System.in);
        Set<String> input = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2.length()-o1.length()==0?o2.compareTo(o1) :o2.length()-o1.length());
            }
        });
        //String str = sc.next();
        //String[] arr= str.split(",");
        for (String s : arr){
            input.add(s);
        }
        String[] result = new String[input.size()];
        int i = 0;
        for (String s : input){
            result[i++] = s;
        }

        int min = 0;
        StringBuilder sb7 = new StringBuilder(1000);
        for (int j = 0; j < result.length; j++) {
            //if (result[j].length()==4){sb7.append(result[j]).append(',');}
            boolean flag = true;
            for (int k = j-1; k >= 0; k--) {
                if(result[j].length()<result[k].length() && result[k].contains(result[j])){
                    System.out.println("k:"+result[k]+"  j:"+result[j]);
                    flag = false;
                    break;
                }
            }
            if(flag){
                min = min + result[j].length()+1;
            }
        }
        System.out.println(sb7.toString());
        System.out.println(min);
    }

    public static int minimumLengthEncoding(String[] words) {
        Set<String> good = new HashSet(Arrays.asList(words));
        for (String word: words) {
            for (int k = 1; k < word.length(); ++k)
                good.remove(word.substring(k));
        }

        int ans = 0;
        for (String word: good)
            ans += word.length() + 1;
        return ans;
    }

    //求解数独
    private static void solution2() {
        Scanner sc = new Scanner(System.in);
        int[][] input = new int[9][9];
        System.out.println("请输入：");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                input[i][j] = sc.nextInt();
            }
        }

        //Sudoku

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(input[i][j]+" ");
            }
            System.out.println();
        }
    }

    //字符串分割
    private static void solution1(){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            String s = sc.nextLine();
            List<String> result = new ArrayList<>();
            for (int i = 0; i <= (s.length()-1)/8; i++) {
                StringBuilder sb = new StringBuilder(8);
                for (int j = i*8; j < i*8+8 && j<s.length(); j++) {
                    char c = s.charAt(j);
                    sb.append(c);
                }
                int rest = 8-sb.length();
                for (int j = 0; j < rest; j++) {
                    sb.append('0');
                }
                result.add(sb.toString());
            }

            for (String str : result){
                System.out.println(str);
            }
        }
    }

}
