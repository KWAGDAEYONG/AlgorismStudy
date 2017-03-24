package simpleSort;

/**
 * Created by user on 2017-03-24.
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] ar = {5, 2, 3, 1, 4};
        int insert;

        for (int i = 1; i < ar.length; i++) {
            insert = ar[i];
            for (int j = i - 1; j >= 0; j--) {
                if (insert < ar[j]) {
                    ar[j + 1] = ar[j];
                    ar[j] = insert;
                }
            }
        }
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }
    }

}
