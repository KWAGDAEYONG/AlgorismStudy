import StackCalculator.Converter;

/**
 * Created by user on 2017-03-22.
 */
public class CalTree {
    public int calculater(Tree tree) {
        if(!isOp(tree.data)){
            return Integer.parseInt(tree.data);
        }else{
            switch(tree.data){
                case "+" : return calculater(tree.leftChild)+calculater(tree.rightChild);
                case "-" : return calculater(tree.leftChild)-calculater(tree.rightChild);
                case "*" : return calculater(tree.leftChild)*calculater(tree.rightChild);
                case "/" : return calculater(tree.leftChild)/calculater(tree.rightChild);
                default : return 0;
            }
        }
    }

    public Tree pushTree(String target) {
        StackList<Tree> stack = new StackList<Tree>();
        String[] cal = target.split("");

        for (int i = 0; i < cal.length; i++) {
            if (!isOp(cal[i])) {
                stack.push(new Tree(cal[i]));
                System.out.println("들어간 숫자:"+stack.peek().data);
            } else {
                Tree tree = new Tree(cal[i]);
                tree.leftChild = stack.pop();
                tree.rightChild = stack.pop();
                stack.push(tree);
                System.out.println("들어간 연산자:"+stack.peek().data);
            }
        }
        System.out.println("루트:"+stack.peek().data);
      return stack.pop();
    }

    public boolean isOp(String t) {
        return (t.equals("+") || t.equals("*") || t.equals("-") || t.equals("/"));
    }

    public class Tree {
        String data;
        Tree leftChild;
        Tree rightChild;


        Tree(String data) {
            this.data = data;
        }
    }


    public static void main(String[] args) {

        //후위표기법으로 전환
        Converter con = new Converter();
        String target = con.converter("1+2*7");
        CalTree calTree = new CalTree();

        System.out.println(calTree.calculater(calTree.pushTree(target)));

    }
}
