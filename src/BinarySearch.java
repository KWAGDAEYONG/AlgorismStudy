/**
 * Created by user on 2017-03-06.
 */
public class BinarySearch {
    static int bSearch(int ar[], int len, int target){
        int first = 0 ;
        int last = len;
        int mid = (first+last)/2;

        while(first<=last){
            mid = (first+last)/2;
            if(ar[mid]==target) {
                return mid;
            }

            if(ar[mid]<target){
                first = mid+1;

            }else {
                last = mid - 1;

            }
        }
        return -1;
    }

    public static void main(String[]args){
        int [] arr = {1,3,5,7,9};
        int idx;

        idx = bSearch(arr,arr.length,1);
        if(idx==-1){
            System.out.println("타겟탐색실패");
        }else{
            System.out.println("타겟저장인덱스:"+idx);
        }

        idx = bSearch(arr,arr.length,4);
        if(idx==-1){
            System.out.println("타겟탐색실패");
        }else{
            System.out.println("타겟저장인덱스:"+idx);
        }

    }
}
