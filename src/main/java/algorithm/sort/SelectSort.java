package algorithm.sort;

/**
 * 注意下标边界，内层循环查找到最小元素下标后才执行交换操作
 */
//选择排序
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {4,3,8,5,6,9,2,1};
        SelectSort.sort(arr);
        for (int a : arr) {
            System.out.println(a);
        }
    }

    public static void sort(int[] arr){
        /*for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j]<arr[i]){
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }*/
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
