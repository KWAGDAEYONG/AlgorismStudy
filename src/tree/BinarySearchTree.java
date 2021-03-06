package tree;

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
        System.out.println("**노드추가**:"+newNode);
        if (root == null) {
            System.out.println("루트당첨!:"+newNode);
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
                        rebalance(parent);
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;

                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        rebalance(parent);
                        return;
                    }
                }
            }
        }
    }


    public Node rotateLL(Node node){
        System.out.println("LLRotate");
        Node child;

        child = node.leftChild;
        child.rightChild = node;

        return  child;
    }

    public Node rotateRR(Node node){
        System.out.println("RRRotate");
        Node child;

        child = node.rightChild;
        child.leftChild = node;

        return child;
    }

    public Node rotateLR(Node node){
        System.out.println("LRRotate");
        Node child;

        child =  node.leftChild;
        node.leftChild = rotateRR(child);
        return rotateLL(node);
    }

    public Node rotateRL(Node node){
        System.out.println("RLRotate");
        Node child;

        child = node.rightChild;
        node.rightChild = rotateLL(child);
        return rotateRR(node);
    }


    //높이구하기
    public int getHeight(Node node){
        int leftHeight;
        int rightHeight;
        if(node==null){
            return 0;
        }

        leftHeight = getHeight(node.leftChild);
        rightHeight = getHeight(node.rightChild);
        if(leftHeight>rightHeight){
            return leftHeight+1;
        }else{
            return rightHeight+1;
        }
    }

    //인수구하기
    public int getHeightDiff(Node node){
        int re = getHeight(node.leftChild) - getHeight(node.rightChild);
        return re;
    }


    private void rebalance(Node node){
        System.out.println("리벨탄놈:"+node);
        int hDiff = getHeightDiff(node);
        if(hDiff>1){
            if(getHeightDiff(node.leftChild)>0){
                node = rotateLL(node);
            }else{
                node = rotateLR(node);
            }
        }else if(hDiff <- 1){
            if(getHeightDiff(node.rightChild)<0){
                node = rotateRR(node);
            }else{
                node = rotateRL(node);
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

           /자식이 없는 경우
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

    //AVL트리 구현 실패.. 슈발.. ㅠㅠ
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

      /* tree.addNode(50, "음식");
        tree.addNode(25, "육류");
        tree.addNode(15, "돼지고기");
        tree.addNode(30, "소고기");
        tree.addNode(75, "야채류");
        tree.addNode(85, "토마토");*/

        tree.addNode(5,"5");
        tree.addNode(3,"3");
       tree.addNode(1,"1");
        System.out.println("===========================================");
        System.out.println("루트:"+tree.root);
        System.out.println("ll"+tree.root.leftChild);
        System.out.println("lll"+tree.root.leftChild.leftChild);


        //tree.preinOrderTraverseTree(tree.root);


      /*  System.out.println("                                                                           "+tree.root);
        System.out.print("                                              "+tree.root.leftChild);
        System.out.println("                                          "+tree.root.rightChild);
        System.out.print("                           "+tree.root.leftChild.leftChild);
        System.out.print("           "+tree.root.leftChild.rightChild);
        System.out.println("                                       "+tree.root.rightChild.rightChild);*/

   /*    System.out.println(tree.root);
        System.out.println(tree.root.leftChild);
        System.out.print(tree.root.leftChild.leftChild);
        System.out.println("  "+tree.root.leftChild.rightChild);
        System.out.println(tree.root.leftChild.leftChild.leftChild);
        System.out.println(tree.root.leftChild.leftChild.leftChild.leftChild);*/

        //System.out.println("diff:"+tree.getHeightDiff(tree.root));

      /*  System.out.println("search");
        System.out.println(tree.findNode(15));*/

    }
}
