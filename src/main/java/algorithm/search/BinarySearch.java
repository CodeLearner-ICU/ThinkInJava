package algorithm.search;

public class BinarySearch {
    //Input: A sequence of n numbers A = 〈a1, a2, . . . , an〉 and a value v.
    //
    //Output: An index i such that v = A[i] or the special value NIL if v does not appear in A.

    //write a mergeSort.
    //1、只有一个元素，直接返回。2个以上，对数据进行对半分割，然后分别对左右数据排序，对左右数据进行合并
    //取左右数据最大的一个进行比较，取出比较结果大的数据，并将数组下标后移继续该过程

    //create a function named solution,sort sequence A use mergeSort which Algorithm complex is O(n*lgn).
    //check the midpoint of the sequence against v and eliminate half of the sequence from further consideration.repeat

    //input存放原始数据，tmp存放分割后数据
    public void mergeSort(int[] input,int[] tmp,int s,int e){
        //递归的边界条件
        if(s>=e)
            return ;

        //对左半边数据排序
        mergeSort(input,tmp,s,(s+e)>>1 );
        //对右半边数据排序
        mergeSort(input,tmp,((s+e)>>1) + 1,e);
        //对数据进行合并
        merge(input,tmp,s,e,(s+e)>>1);
    }

    private void merge(int[] input, int[] tmp, int s, int e,int m) {
        int l = m;
        int r = e;
        int lastIndex = e;
        while ( l >= s && r > m){
            if(input[l] > input[r]){
                tmp[lastIndex--] = input[l--];
            }else {
                tmp[lastIndex--] = input[r--];
            }
        }
        while(l >= s){
            tmp[lastIndex--] = input[l--];
        }
        while(r > m){
            tmp[lastIndex--] = input[r--];
        }
        for (int i = s; i <= e; i++) {
            input[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        int[] arr = new int[]{55,99,4,35,29,14,1,26};
        int v = 55;
        int ans = search.solution(arr,v);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i]+" ");
        }
        System.out.println("answer:"+ ans);
    }

    public int solution(int[] input,int v){
        int answer = 0;
        mergeSort(input,new int[input.length],0,input.length-1);
        int l = 0,r=input.length-1;
        while (l<r){
            int m = (l+r) >> 1;
            if(input[m] == v){
                answer = m;
                break;
            }else if(input[m] > v){
                r = m;
            }else if(input[m] < v){
                l = m;
            }
        }
        return answer;
    }
}
