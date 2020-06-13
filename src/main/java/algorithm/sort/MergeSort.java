package algorithm.sort;

public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort= new MergeSort();
        int[] arr = {4,3,8,5,6,9,2,1};
        int[] tmp =new int[arr.length];
        mergeSort.sort(arr,0,arr.length-1,tmp);
        for (int a : arr) {
            System.out.print(a+" ");
        }
    }

    /* 错误：
    int[] sort(int[] arr,int n){
        if(n==1){
            return arr;
        }
        int[] left = sort(arr,n-n/2);
        int[] right = sort(arr,n/2);
        int[] result = new int[n];
        int k = 0;
        int m = 0;
        for (int j = 0; j < n / 2; j++) {//右边
            for (int i = m; i <n-n/2; i++) {//左边
                if (right[j]<left[i]){
                    result[k] = right[j];
                    k++;
                    m = i;
                    break;
                }  else {
                    result[k] = left[i];
                    k++;
                    m = i;
                }
            }
        }
        for (int i = m; i < n-n/2; i++) {//左边
            result[k] = left[i];
            k++;
        }
        return result;
    }*/

    void sort(int[] result,int s,int e,int[] temp){
        if(s<e){
            int m = s+(e-s)/2;
            sort(result,s,m,temp);
            sort(result,m+1,e,temp);
            merge(result,s,m,e,temp);
        }
    }

    private void merge(int[] result, int s, int m, int e, int[] tmp) {
        int i =s;
        int j =m+1;
        int k =0;
        while (i<=m && j<=e){
            if(result[i]<result[j]){
                tmp[k++] = result[i++];
            }else {
                tmp[k++] = result[j++];
            }
        }
        while (i<= m){
            tmp[k++] = result[i++];
        }
        while (j<=e){
            tmp[k++] = result[j++];
        }
        for (int l = s; l <= e; l++) {
            result[l] = tmp[l-s];
        }
    }
}
