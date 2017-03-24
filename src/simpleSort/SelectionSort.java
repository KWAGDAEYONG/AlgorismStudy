package simpleSort;

/**
 * Created by user on 2017-03-24.
 */
public class SelectionSort {
    public static void main(String[]args){
        int[]ar = {5,3,2,7,8,4,6};
        int temp=0;
        int min = 0;
        int target = 0;
        for(int i = 0; i<ar.length; i++){
            min = ar[i];
            target = i;
            for(int j = i; j<ar.length-1; j++){
                if(min>ar[j+1]){
                    min = ar[j+1];
                    target = j+1;
                }
            }
            temp = ar[i];
            ar[i] = ar[target];
            ar[target] = temp;

        }

        for(int i = 0; i<ar.length; i++){
            System.out.println(ar[i]);
        }
    }
}
