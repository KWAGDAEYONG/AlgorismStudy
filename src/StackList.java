/**
 * Created by user on 2017-03-14.
 */
public class StackList<T> {
    private Node topIndex;

    public class Node{
        private T data;
        private Node nextNode;

        public Node(T input){
            this.data = input;
            this.nextNode = null;
        }
    }

    public StackList(){
        this.topIndex = null;
    }

    public boolean isEmpty(){
        return topIndex==null;
    }

    public void push(T object){
        Node node = new Node(object);
        //이 시점에서, 마지막 노드의 next노드는 직전 노드를 바라보게 된다.
        node.nextNode = topIndex;
        topIndex = node;
    }

    public T pop(){
        if(isEmpty()){
            System.out.println("스택이 없습니다.");
        }
        T temp = topIndex.data;
        topIndex = topIndex.nextNode;
        return temp;

    }

    public T peek(){
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return topIndex.data;
    }

}
