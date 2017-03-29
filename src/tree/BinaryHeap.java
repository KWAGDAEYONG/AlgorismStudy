package tree;

/**
 * Created by user on 2017-03-23.
 */
public class BinaryHeap {
    private int[] data;
    private int size = 0;
    private int maxSize;

    public BinaryHeap(int arraySize) {

        data = new int[arraySize];

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public void insert(int dt) {
        int index;
        if (isFull()) {
            System.out.println("꽉 찼습니다");
            return;
        } else {
            size++;
            data[size] = dt;
            index = size;

            while (index > 1 && data[index] > data[index / 2]) {
                int temp = data[index];
                data[index] = data[index / 2];
                data[index / 2] = temp;
                index = index / 2;
            }
        }
    }

    public int remove() {
        int forReturn;
        int index = 1;
        if (isEmpty()) {
            throw new NumberFormatException("비어있습니다");
        } else {
            forReturn = data[index];
            data[index] = data[size];
            size--;

            while (data[index / 2] < data[index]) {
                if (data[index * 2] > data[index * 2 + 1]) {
                    int temp = data[index];
                    data[index] = data[index * 2];
                    data[index * 2] = temp;
                    index = index * 2;
                } else {
                    int temp = data[index];
                    data[index] = data[index * 2 + 1];
                    data[index * 2 + 1] = temp;
                    index = index * 2 + 1;
                }

            }
        }
        return forReturn;
    }

    public static void main(String[]args){
        BinaryHeap heap = new BinaryHeap(100);

        heap.insert(5);
        heap.insert(3);
        heap.insert(7);
        heap.insert(4);

        for(int i = 0; i<4; i++){
            System.out.println(heap.remove());
        }
    }
}
