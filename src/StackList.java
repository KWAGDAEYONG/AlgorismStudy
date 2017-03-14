/**
 * Created by user on 2017-03-14.
 */
public class StackList {
    private Node topIndex;

    public class Node{
        private Object data;
        private Node nextNode;

        public Node(Object input){
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

    public void push(Object object){
        Node node = new Node(object);
        topIndex.nextNode = node;
        topIndex = node;
    }

    public Object pop(){
        Object temp = topIndex.data;
        //topIndex.nextNode 필드는 push단계중에 이전노드의 nextnode 레퍼런스를 참조하고 있음을 인식해야함.
        topIndex = topIndex.nextNode;
        return temp;

    }

    public Object peek(){
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return topIndex.data;
    }

}
