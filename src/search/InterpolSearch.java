package search;

/**
 * Created by user on 2017-04-03.
 */
public class InterpolSearch {
    static int bSearch(int ar[], int len, int target){
        int first = 0 ;
        int last = len-1;
        int mid;

        while(first<=last){
            mid = (int)((double)(target-ar[first]) / (ar[last] - ar[first]) * (last-first))+first;//(first+last)/2;

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

        idx = bSearch(arr,arr.length,3);
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
