package complexSort;

import tree.BinaryHeap;

/**
 * Created by user on 2017-03-29.
 */
public class HeapSort{
    public static void main(String[]args){
        int[]arr = {6,3,2,4};

        BinaryHeap heap = new BinaryHeap(7);

        for(int i = 0; i<4; i++){
            heap.insert(arr[i]);
        }

        for(int i = arr.length-1; i>=0; i--){
            arr[i] = heap.remove();
            System.out.println(arr[i]);
        }
    }
}
