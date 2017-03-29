package complexSort;

/**
 * Created by user on 2017-03-29.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {27, 15, 10, 68, 45, 12, 7, 30};
        int[] sorted = new int[30];

        mergeSort(arr,0,arr.length-1);

    }

    public static void mergeSort(int[] arr, int left, int right) {
        int middle;
        if (right > left) {
            System.out.println("left는"+left+", right는"+right);
            middle = (right + left) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    public static void merge(int[] arr, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = left; //sorted배열의 첫인덱스
        int sorted[] = new int[arr.length];

        while (i <= middle && j <= right) {
            if (arr[i] <= arr[j]) {
                sorted[k] = arr[i++];
            } else {
                sorted[k] = arr[j++];
            }
            k++;
        }

        if (i > middle) {
            for (int t = j; t <= right; t++, k++) {
                sorted[k] = arr[t];
            }
        } else {
            for (int t = i; t <= middle; t++, k++) {
                sorted[k] = arr[t];
            }
        }

        for (int t = left; t <= right; t++) {
            arr[t] = sorted[t];
        }

        for (int m = 0; m < arr.length; m++) {
            System.out.print("합병중");
            System.out.println(arr[m] + " ");
        }
        System.out.println("============");
    }


}
