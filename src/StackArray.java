/**
 * Created by user on 2017-03-14.
 */
public class StackArray {
    private int topIndex;
    private int size;
    private Object[] stack;

    public StackArray(int size){
        stack = new Object[size];
        this.size = size;
        topIndex = -1;
    }

    public boolean isEmpty(){
        return topIndex==-1;
    }

    public boolean isFull(){
        return topIndex==size-1;
    }

    public void push(Object object){
        if(isFull()){
            throw new ArrayIndexOutOfBoundsException();
        }
        stack[++topIndex] = object;
    }

    public Object pop(){
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        Object temp = stack[topIndex];
        stack[topIndex] = null;
        topIndex--;
        return temp;
    }

    public Object peek(){
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return stack[topIndex];
    }

}
