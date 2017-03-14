/**
 * Created by user on 2017-03-14.
 */
public class StackList {
    private Node topIndex;

    public class Node{
        private Object data;
        private Node nextNode;

        public Node(Object data){
            this.data = data;
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
        node.nextNode = topIndex;
        topIndex = node;
    }

    public Object pop(){
        Node temp = topIndex;
        topIndex = topIndex.nextNode;
        return temp.data;

    }

    public Object peek(){
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return topIndex;
    }

}
