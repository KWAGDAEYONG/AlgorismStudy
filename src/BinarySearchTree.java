/**
 * Created by user on 2017-03-21.
 */
public class BinarySearchTree {
    Node root;

    class Node {
        int key;
        Object data;
        Node leftChild;
        Node rightChild;

        Node(int key, Object data) {
            this.key = key;
            this.data = data;
        }

        public String toString() {
            return "key : "+key+"||data : "+data.toString();
        }
    }

    public void addNode(int key, Object data) {
        Node newNode = new Node(key, data);
        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;

            Node parent;

            while (true) {
                parent = focusNode;
                if (key < focusNode.key) {
                    focusNode = focusNode.leftChild;

                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;

                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node findNode(int key) {
        Node focusNode = root;
        while (focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null) {
                return null;
            }
        }
        return focusNode;
    }

    //remove 구현에 실패.. 나중에 다시해보겠다..
    /*public Object removeNode(int key) {

        if (findNode(key) == null) {
            return null;//new NullPointerException("해당 데이터가 트리에 없습니다");
        } else {
            Object tempForReturn = findNode(key).data;
            Node focusNode = root;

            while(focusNode.key!=key){
                if (key < focusNode.key) {
                    focusNode = focusNode.leftChild;
                } else {
                    focusNode = focusNode.rightChild;
                }
            }

           //자식이 없는 경우
           if(focusNode.leftChild == null && focusNode.rightChild == null){
               System.out.println("삭제:"+focusNode);
               focusNode = null;
               System.out.println("삭제:"+focusNode);
           }
           //양쪽 자식이 있는경우
           else if(focusNode.leftChild != null && focusNode.rightChild != null){
               Node extender = focusNode.rightChild;
               while(true){
                   if(extender.leftChild==null){
                       focusNode = extender;
                       break;
                   }
                   extender = extender.leftChild;
               }
           }else{//한쪽 자식이 있는경우
               if(focusNode.leftChild==null){
                   focusNode = focusNode.rightChild;
               }else {
                   focusNode = focusNode.leftChild;
               }

           }
           return  tempForReturn;
        }

    }*/
/*

    public void inOrderTraverseTree(Node focusNode){
        if(focusNode!=null){

            inOrderTraverseTree(focusNode.leftChild);

            System.out.println(focusNode);

            inOrderTraverseTree(focusNode.rightChild);
        }
    }
*/

    public void preinOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            preinOrderTraverseTree(focusNode.leftChild);

            preinOrderTraverseTree(focusNode.rightChild);
        }
    }

 /*   public void postinOrderTraverseTree(Node focusNode){
        if(focusNode!=null){

            postinOrderTraverseTree(focusNode.leftChild);

            postinOrderTraverseTree(focusNode.rightChild);

            System.out.println(focusNode);
        }
    }*/


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.addNode(50, "Boss");
        tree.addNode(25, "Vice Pres");
        tree.addNode(15, "Office Manager");
        tree.addNode(30, "Secretary");
        tree.addNode(75, "Sales Manager");
        tree.addNode(85, "Salesman 1");

        tree.preinOrderTraverseTree(tree.root);

        System.out.println("search");
        System.out.println(tree.findNode(15));




    }
}
