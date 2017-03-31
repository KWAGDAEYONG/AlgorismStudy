package complexSort;

import queue.LinkedQue;

/**
 * Created by user on 2017-03-31.
 */
public class RadixSort {

    final static int BUCKET_NUM = 10;

    public static void radixSort(int arr[], int num, int length){
        LinkedQue bucket [];
        bucket = new LinkedQue[10];

        for(int i = 0; i<bucket.length; i++){
            bucket[i] = new LinkedQue();
        }

        int di;
        int pos;
        int divfac = 1;
        int radix;

        for(pos = 0; pos<length; pos++){
            for(di=0; di<num; di++){
                radix = (arr[di]/divfac)%10;
                bucket[radix].enQueue(arr[di]);
                System.out.println("arr["+di+"]는"+arr[di]+"이므로 bucket["+radix+"] 에 옮긴다");
            }
            int i = 0;
            for(int bi = 0; bi<BUCKET_NUM; bi++){
                while (!bucket[bi].isEmpty()){
                    int temp = (int)bucket[bi].deQueue();
                    arr[i] = temp;
                    System.out.println("bucket["+bi+"]에서"+temp+ "를 꺼내 arr["+i+"]에 다시 옮긴다.");
                    i++;
                }
            }
            divfac *= 10;
        }
    }

    public static void main(String[]args){

        int arr[] = {134,224,232,122};

        radixSort(arr,4,3);

        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
