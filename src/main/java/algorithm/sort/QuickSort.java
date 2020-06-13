package algorithm.sort;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort= new QuickSort();
        int[] arr = {4,3,8,5,6,9,2,1};
        quickSort.sort(arr,0,arr.length-1);
        for (int a : arr) {
            System.out.print(a+" ");
        }
    }
    /* 正确：语义不是很明确
    void sort(int[] arr,int s,int e){
        if(s<e) {
            int l = s;
            int r = e;
            int change = 0;
            while (l != r) {
                if (arr[l] < arr[r]) {
                    if (change%2==0){
                        r--;
                    }else {
                        l++;
                    }
                } else {
                    swap(arr, l, r);
                    if (change%2==0){
                        l++;
                    }else {
                        r--;
                    }
                    change ++;//1
                }
            }
            sort(arr, s, l-1);
            sort(arr, l+1, e);
        }
    }*/

    void sort(int[] arr,int s,int e){
        if(s<e){
            int i = s;
            int j = e;
            int k = arr[s];
            while (i != j){
                while (i<j && arr[i]<arr[j]){
                    j--;
                }
                swap(arr,i,j);
                while (i<j && arr[i]<arr[j]){
                    i++;
                }
                swap(arr,i,j);
            }
            sort(arr,s,i-1);
            sort(arr,i+1,e);
        }
    }

    void swap(int[] arr,int x,int y){
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
