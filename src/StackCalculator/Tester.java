package StackCalculator;

/**
 * Created by user on 2017-03-15.
 */
public class Tester {
    public static void main(String[]args){
        Converter con = new Converter();
        System.out.println("타겟 : ((4+2)/4)-(3+2/(7*5))");
        System.out.println("결과 : "+con.converter("((4+2)/4)-(3+2/(7*5))"));
    }
}
