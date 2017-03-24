package queue;

/**
 * Created by user on 2017-03-17.
 */

//배열기반 원형큐
public class CircularQueue {

    private int front;
    private int rear;
    private int maxSize;
    private Object[] queueArray;

    public CircularQueue(int maxSize){
        this.front = 0;
        this.rear = 0;

        this.maxSize = maxSize;
        this.queueArray = new Object[this.maxSize];
    }

    public boolean isEmpty(){
        return front==rear;
    }

    public boolean isFull(){
        return (rear+1)%this.maxSize==front;
    }

    public void enQueue(Object object){
        if(isFull()){
            System.out.println("큐가 포화상태임");
        }
        rear++;
        rear = rear%maxSize;
        queueArray[rear] = object;
    }

    public Object deQueue(){
        if(isEmpty()){
            System.out.println("큐가 비어있음");
        }
        front++;
        front = front%maxSize;
        Object temp = queueArray[front];
        queueArray[front] = null;
        return temp;
    }

    public Object peek(){
        if(isEmpty()){
            System.out.println("큐가 비어있음");
        }
        return queueArray[(front+1)%maxSize];
    }
}
