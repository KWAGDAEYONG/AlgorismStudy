import java.util.ArrayList;

/**
 * Created by KDY on 2017-03-08.
 * 배열기반 리스트 구현
 */
public class ArrayList1 {

    //임시로 크기 지정
    private Object[] elements = new Object[500];
    //list의 크기. - 데이터가 얼마나 들어있는지.
    private int size = 0;

    public boolean add(Object element){
        elements[size] = element;
        size++;
        return true;
    }

    public void add(int index, Object element){
        //추가하려는 인덱스 부터 뒤로 한칸씩 밀어낸다.
        for(int i = size-1; i>=index; i--){
            elements[size+1] = elements[size];
        }
        //인덱스에 element 삽입
        elements[index] = element;
        //리스트의 크기를 1증가.
        size++;
    }

    public Object remove(int index){

        //리턴해주기 위한 삭제될 오브젝트를 미리 저장
        Object removeElement = elements[index];

        //그냥 덮어쓰는 식으로 해당 인덱스의 값을 제거하고, 뒤의 모든 리스트를 앞으로 한칸씩 당겨온다.
        for(int i = index+1; i<=size-1; i++){
            elements[i-1] = elements[i];
        }
        //마지막 인덱스값 제거
        elements[size]=null;

        return removeElement;
    }

    public Object get(int index){
        return elements[index];
    }

    public int size(){
        return size;
    }

    //리스트의 인덱스를 순차탐색하여 i값 리턴 없으면 -1리턴
    public Object indexOf(Object element){
        for(int i =0; i<size; i++){
            if(element.equals(elements[i])){
                return i;
            }
        }
        return -1;
    }

}
