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
                case "+":
                    temp1 = Double.parseDouble(sa.pop().toString());
                    temp2 = Double.parseDouble(sa.pop().toString());
                    result = temp2 + temp1;
                    sa.push(result);
                    break;
                case "-":
                    temp1 =Double.parseDouble(sa.pop().toString());
                    temp2 =Double.parseDouble(sa.pop().toString());
                    result = temp2 - temp1;
                    sa.push(result);
                    break;
                case "*":
                    temp1 =Double.parseDouble(sa.pop().toString());
                    temp2 = Double.parseDouble(sa.pop().toString());
                    result = temp2 * temp1;
                    sa.push(result);
                    break;
                case "/":
                    temp1 = Double.parseDouble(sa.pop().toString());;
                    temp2 = Double.parseDouble(sa.pop().toString());
                    result = temp2 / temp1;
                    sa.push(result);
                    break;
                default:
                    sa.push(st[i]);
            }
        }
        return result;
    }
}
