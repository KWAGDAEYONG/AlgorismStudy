package complexSort;

/**
 * Created by user on 2017-03-30.
 */
public class QuickSort {
    public static void swap(int arr[], int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
        for(int i:arr){
        }
    }

    public static void quickSort(int arr[], int left, int right){
        if(left<right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    public static int partition(int arr[], int left, int right){
        int pivot = arr[(left+right)/2];

        while(left<right){
            while((pivot>arr[left])&&(left<right)){
                left++;
            }
            while((pivot<arr[right])&&(left<right)){
                right--;
            }

            if(left<right){
                swap(arr,left,right);
            }
        }
        //left와 right가 같아지는 그 시점을 리턴해준다.
        return left;
    }

    public static void main(String[]args){
        int [] arr = {6,3,1,7,2,9,8,4,5};

        quickSort(arr,0,arr.length-1);

        for(int i :arr){
            System.out.print(i+" ");
        }
    }
}
