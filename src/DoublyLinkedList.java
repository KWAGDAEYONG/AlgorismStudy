/**
 * Created by user on 2017-03-13.
 */
public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    private class Node{
        //노드 내의 데이터 필드
        private Object data;
        //다음 노드의 레퍼런스
        private Node nextNode;
        //이전 노드의 레퍼런스
        private Node prevNode;

        public Node(Object input){
            this.data = input;
            this.nextNode = null;
            this.prevNode = null;
        }
        public String toString(){
            return String.valueOf(this.data);
        }

        public void addFirst(Object input){
            Node newNode = new Node(input);
            //새로 생성한 노드의 다음노드레퍼런스로 head저장
            newNode.nextNode = head;
            //null처리 prev노드 값 셋
            if(head!=null) {
                head.prevNode = newNode;
            }
            //head가 지금 생성한 노드를 바라보도록 저장
            head = newNode;

            size++;
            //노드가하나일 경우
            if(head.nextNode==null){
                tail = head;
            }
        }
        public void addLast(Object input){
            if(size==0){
                addFirst(input);
            }else{
                Node newNode = new Node(input);
                //마지막 노드의 다음노드로 새로 생성한 노드를 참조하도록
                tail.nextNode = newNode;
                //방금 추가한 마지막 노드의 이전노드레퍼런스값 셋
                newNode.prevNode = tail;
                //tail 필드 갱신
                tail = newNode;
                //노드개수추가
                size++;
            }
        }
        public void add(int index, Object input){
            if(index==0){
                addFirst(input);
            }else{
                Node newNode = new Node(input);
                //타겟인덱스 노드의 이전노드
                Node temp1 = targetNode(index-1);
                //temp1과 temp2사이에 타겟노드가 들어갈것.
                Node temp2 = temp1.nextNode;
                temp1.nextNode = newNode;
                newNode.nextNode = temp2;
                //null처리 및 temp2 prev노드 셋
                if(temp2!=null){
                    temp2.prevNode = newNode;
                }
                //새로추가된 노드의 prev노드 셋
                newNode.prevNode = temp1;
                size++;
                if(newNode.nextNode==null){
                    tail = newNode;
                }
            }

        }
        //해당 인덱스의 노드 객체를 리턴하기위한 *추가 -> index가 head에서 가까운지 tail에서 가까운지 비교하여 탐색
        private Node targetNode(int index){
            Node target;
            if(size()/2<index) {
                target = head;
                for (int i = 0; i < index; i++) {
                    target = target.nextNode;
                }
                return target;
            }else{
                target = tail;
                for (int i = size()-1; i>index; i--){
                    target = target.prevNode;
                }
                return target;
            }
        }

        private Object removeFirst(){
            //첫번쨰 노드를 잡고
            Node temp = head;
            //첫번째 노드를 한칸 뒤로 뺀후
            head = temp.nextNode;
            //리턴해줄 데이터를 미리 잡아둔다음(remove되는 노드의 데이터필드)
            Object returnData = temp.data;
            //첫번째노드 제거
            temp = null;
            //레퍼런스값 제거
            if(head!=null){
                head.prevNode = null;
            }
            size--;
            return returnData;
        }

        private Object remove(int index){

            if(index==0){
                return removeFirst();
            }
            //제거하려는 타겟노드를 바라보든 노드를 잡고
            Node temp = targetNode(index-1);
            //그러므로 제거될 노드는 임시로 잡은노드의 다음노드
            Node removed = temp.nextNode;
            //타겟이 제거되면 임시노드가 바라볼 노드는 제거될노드의 다음노드
            temp.nextNode = temp.nextNode.nextNode;
            //가운데 노드가 빠지면서 이전노드레퍼런스 연결
            temp.nextNode.prevNode = temp;

            Object returnData = removed.data;
            if(removed==tail){
                tail = temp;
            }
            removed = null;
            size --;
            return returnData;
        }

        private int size(){
            return size;
        }

        private Object get(int index){
            return targetNode(index);
        }

        private int indexOf(Object nodeData){
            Node temp = head;
            int index = 0;
            //인자값과 일치하는 노드데이터 탐색
            while(temp.data!=nodeData){
                temp = temp.nextNode;
                index++;
            }
            if(temp==null){
                return -1;
            }
            return index;
        }

    }
}
