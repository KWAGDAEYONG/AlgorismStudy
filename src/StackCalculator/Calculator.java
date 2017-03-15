package StackCalculator;

/**
 * Created by user on 2017-03-16.
 */
public class Calculator {
    public double calculator(String target) {
        String[] st = target.split("");
        StackArray sa = new StackArray(st.length);
        double result = 0;
        double temp1 = 0;
        double temp2 = 0;
        for (int i = 0; i < st.length; i++) {
            switch (st[i]) {
                case "+": //result = Integer.parseInt(sa.pop().toString())+Integer.parseInt(sa.pop().toString()); sa.push(result);
                    temp1 = Double.parseDouble(sa.pop().toString());
                    System.out.println("temp1:" + temp1);
                    temp2 = Double.parseDouble(sa.pop().toString());
                    System.out.println("temp2:" + temp2);
                    result = temp2 + temp1;
                    System.out.println("result:" + result);
                    sa.push(result);
                    break;
                case "-": //result = Integer.parseInt(sa.pop().toString())-Integer.parseInt(sa.pop().toString()); sa.push(result); break;
                    temp1 =Double.parseDouble(sa.pop().toString());
                    System.out.println("temp1:" + temp1);
                    temp2 =Double.parseDouble(sa.pop().toString());
                    System.out.println("temp2:" + temp2);
                    result = temp2 - temp1;
                    System.out.println("result:" + result);
                    sa.push(result);
                    break;
                case "*": //result = Integer.parseInt(sa.pop().toString())*Integer.parseInt(sa.pop().toString()); sa.push(result); break;
                    temp1 =Double.parseDouble(sa.pop().toString());
                    System.out.println("temp1:" + temp1);
                    temp2 = Double.parseDouble(sa.pop().toString());
                    System.out.println("temp2:" + temp2);
                    result = temp2 * temp1;
                    System.out.println("result:" + result);
                    sa.push(result);
                    break;
                case "/": //result = Integer.parseInt(sa.pop().toString())/Integer.parseInt(sa.pop().toString()); sa.push(result); break;
                    temp1 = Double.parseDouble(sa.pop().toString());
                    System.out.println("temp1:" + temp1);
                    temp2 = Double.parseDouble(sa.pop().toString());
                    System.out.println("temp2:" + temp2);
                    result = temp2 / temp1;
                    System.out.println("result:" + result);
                    sa.push(result);
                    break;
                default:
                    sa.push(st[i]);
            }
        }
        return result;
    }


}
