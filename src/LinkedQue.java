/**
 * Created by user on 2017-03-20.
 */
//링크드리스트 기반 큐
public class LinkedQue {
    private Node front;
    private Node rear;

    public class Node{
        private Node nextNode;
        private Object data;

        public Node(Object input){
            this.data = input;
            nextNode = null;
        }

    }


    public boolean isEmpty(){
        return front == null;
    }

    public void enQueue(Object data){
        Node newNode = new Node(data);

        if(isEmpty()){
            front = newNode;
            rear = newNode;
        }else{
            rear.nextNode = newNode;
            rear = newNode;
        }
    }

    public Object deQueue(){
        if(isEmpty()){
            return "큐가 비어있음";
        }
        Node nodeTemp = front;
        Object returnTemp = front.data;
        front = front.nextNode;
        nodeTemp = null;
        return returnTemp;
    }

}
