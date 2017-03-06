/**
 * Created by user on 2017-03-06.
 */
public class LenearSearch {
    public static int LSearch(int ar[], int len, int target){
        int i ;
        for(i = 0; i<len; i++){
            if(ar[i]==target){
                return i;
            }

        }
        return -1;
    }

    public static void main(String[]args){
        int [] arr = {3, 5, 2, 4, 9};

        int idx;

        idx = LSearch(arr, arr.length, 4);

        if(idx == -1){
            System.out.println("탐색실패");
        }
        else{
            System.out.println("타겟저장인덱스:"+idx);
        }

        idx = LSearch(arr, arr.length, 7);

        if(idx == -1){
            System.out.println("탐색실패");
        }
        else{
            System.out.println("타겟저장인덱스:"+idx);
        }

    }
}
