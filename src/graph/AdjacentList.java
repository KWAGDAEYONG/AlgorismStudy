package graph;

import linkedList.LinkedList;

/**
 * Created by user on 2017-04-06.
 */
public class AdjacentList {

    int v;

    LinkedList linkedList[];

    public AdjacentList(int v){
        this.v = v;
        linkedList= new LinkedList[v];

        for(int i = 0; i<v; i++){
            linkedList[i] = new LinkedList();
        }
    }

    public void addEdge(char v1, char v2){
        linkedList[v1-65].addLast(v2);
        System.out.println(v1+"에 "+v2+" 연결");
    }

    public void graphInfo(){
        for(int i = 0; i<v; i++){
            char temp = (char)(i+65);
            LinkedList.Iterator li = linkedList[i].iterator();
            int k = 0;
            while (li.hasNext()){
                li.next();
                System.out.println(temp+"와 연결된 정점은 "+linkedList[i].getData(k));
                k++;
            }
        }
    }

    public static void main(String[]args){
        AdjacentList adjacentList = new AdjacentList(4);

        adjacentList.addEdge('A', 'B');
        adjacentList.addEdge('A','C');
        adjacentList.addEdge('A','D');
        adjacentList.addEdge('B','C');

        adjacentList.graphInfo();
    }


}
