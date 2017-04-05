package table;

import linkedList.LinkedList;



/**
 * Created by user on 2017-04-05.
 */
public class ArrayTable {
    Object [] map = new Object[10];
    LinkedList[] linkedList = new LinkedList[10];
    Slot slot;

    ArrayTable(){
        for(int i = 0; i<map.length; i++){
            linkedList[i] = new LinkedList();
        }
    }

    private int hashFunction(int key){
        return key%10;
    }

    public void add(int key, Object value)throws Exception{

        if(containKey(key)){
            throw new Exception("키가 중복되었습니다");
        }
        slot = new Slot(key, value);
        linkedList[hashFunction(key)].addLast(slot);
        System.out.println(linkedList[hashFunction(key)]+"에 add : "+slot.toString());
    }

    private boolean containKey(int key){
        LinkedList.Iterator li = linkedList[hashFunction(key)].iterator();
        while(li.hasNext()){
            li.next();
            int i = 0;
            slot = (Slot)linkedList[hashFunction(key)].getData(i);
            if(slot.key == key){;
                return true;
            }
            return false;
        }
        return false;
    }

    public Object get(int key){
        LinkedList.Iterator li = linkedList[hashFunction(key)].iterator();
        int i = 0;
        while(li.hasNext()){
            li.next();
            slot = (Slot)linkedList[hashFunction(key)].getData(i);
            i++;
            if(slot.key==key){
                return slot.value;
            }

        }
        return new Exception("key에대한 value가 없습니다");
    }

    private class Slot{
        int key;
        Object value;
        Slot(int key, Object value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Slot{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[]args)throws Exception{
        ArrayTable arrayTable = new ArrayTable();
        arrayTable.add(11,"11");
        arrayTable.add(21,"21");
        arrayTable.add(12,"12");

        System.out.println(arrayTable.get(11).toString());
        System.out.println(arrayTable.get(21).toString());
        System.out.println(arrayTable.get(12).toString());
    }

}
