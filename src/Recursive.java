/**
 * Created by user on 2017-03-07.
 */

//재귀의 활용
public class Recursive {

    //하노이의 타워 메서드 호출 횟수 계산 필드
    public static int i=0;

    //팩토리얼해ㅑㅅ
    public static int factorial(int n) {

        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    //피보나치
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    //이진탐색의 재귀적구현
    public static int binarySearchRecursive(int ar[], int first, int last, int target) {
        int mid = (first + last) / 2;
        if (first > last) {
            return -1;
        }
        if (ar[mid] == target) {
            return mid;
        }

        if (ar[mid] > target) {
            return binarySearchRecursive(ar, first, mid - 1, target);

        } else {
            return binarySearchRecursive(ar, mid + 1, last, target);
        }

    }

    //하노이의 타워
    public static int hanoiTower(int n, char from, char by, char to) {
        i++;
        if (n == 1)  {
            return i;
        } else
            System.out.println(i+"번 ..a에서 b로 이동중");
            hanoiTower(n - 1, from, to, by);
        System.out.println(i+"번 ..b에서 c로 이동중");
        hanoiTower(n - 1, by, from, to);

        return i;
    }



    public static void main(String[]args){
        System.out.println("팩토리얼");
        System.out.println("5!: "+factorial(5));
        System.out.println();
        System.out.println("피보나치");
        for(int i =0; i<10; i++){
            System.out.print(" "+fibonacci(i));
        }
        System.out.println();
        System.out.println();
        System.out.println("이진탐색");
        int arr[] = {1,2,3,4,5,6,7,8};
        if(binarySearchRecursive(arr,0,arr.length,7)==-1){
            System.out.println("탐색실패");
        }
        System.out.println("타겟:7, 타겟인덱스 :"+binarySearchRecursive(arr,0,arr.length,7));
        System.out.println();
        System.out.println("하노이의 타워");
        System.out.println("4개를 A에서 C로 이동");
        System.out.println(hanoiTower(3,'A','B','C')+"번 옮깁니다.");
    }
}
