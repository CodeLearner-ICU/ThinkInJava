package algorithm.sort;

//插入排序
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {4,3,8,5,6,9,2,1};
        InsertSort.sort(arr);
        for (int a : arr) {
            System.out.print(a+" ");
        }
    }
    public static void sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {//取无序中的元素  错误 for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < i; j++) {//取有序中的元素  错误：for (int j = 0; j <= i; j++)
                if(arr[i]<arr[j]){//无序中的元素依次和有序中的元素比较，当无序中元素小于有序中元素时插入到当前有序元素前一个位置
                    int t = arr[i];
                    for (int k = i; k > j; k--) {//有序元素由后向前移动，腾出当前元素的位置，并插入无序中的元素
                        arr[k] = arr[k-1];
                    }
                    arr[j] = t;
                    break;
                }
            }
        }
    }
}
