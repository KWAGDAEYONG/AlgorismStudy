package StackCalculator;

import java.util.ArrayList;

/**
 * Created by user on 2017-03-15.
 */
public class Converter {
    String result="";
    ArrayList<String> converted = new ArrayList<String>();
    StackArray sa;

    //targetConvert
    public String converter(String target){

        //변환할 수식을 잘라서 배열에 넣는다.
        String [] before = target.split("");

        //배열기반스택을 무난하게 위 배열 크기로 생성
        sa = new StackArray(before.length);

        //반복문 start
        for(int i = 0; i<before.length; i++){

            //값이 숫자일 경우 그냥 리스트에 추가
            if(stLevel(before[i])==-1&&!before[i].equals(")")){
                converted.add(before[i]);
                System.out.println("리스트추가 : "+before[i]);

            //연산자일 경우
            }else{

                //닫는 괄호일 경우
                if(before[i].equals(")")){

                    //여는 괄호가 나올때까지 스택에서 꺼내서 리스트에 추가
                    while(!sa.peek().toString().equals("(")) {
                        converted.add(sa.pop().toString());
                    }

                //스택 최상위 연산자보다 먼저 연산해야 하는 연산자일 경우, 스택에 그대로 추가
                }else if(isPushToStack(stLevel(before[i]))){
                    sa.push(before[i]);
                //스택 최상위 연산자다음 여는 괄호가 온 경우, 일단 연산자는 냅두고 괄호를 스택 상위로 추가
                }else if(stLevel(sa.peek().toString())==3||stLevel(sa.peek().toString())==5&&stLevel(before[i])==1){
                    sa.push(before[i]);
                }

                //스택 최상위 연산자보다 늦게 연산해야 하는 연산자 경우, 최상위 스택의 연산자를 리스트에 추가하고 그자리
                // 에 현재 연산자를 추가
                else{
                    converted.add(sa.pop().toString());
                    sa.push(before[i]);
                }
            }
        }

        // ( 를 제외한스택에 남아있는 모든 연산자를 리스트에 추가
        while(!sa.isEmpty()){
            if(!sa.peek().equals("(")) {
                converted.add(sa.pop().toString());
            }else{
                sa.pop();
            }
        }

        //리스트의 값들을 꺼내어 리턴값 생성
        for(int j = 0; j<converted.size(); j++){
            result += converted.get(j);
        }
        return result;
    }

    //연산자의 레벨. 먼저 계산해야 하는 연산자일수록 높은 레벨. 숫자는 -1. 기본적으로 여는괄호는 연산자보다 먼저 쌓이게
    // 설정하고, 닫는 괄호가 나왔을때 여는괄호까지의 연산식을 만들어 낼것!
    public int stLevel(String st){
        switch (st){
            case"*":case"/":return 5;
            case"+":case"-":return 3;
            case"(":return 1;
            default: return -1;
        }
    }

    //레벨이 높으면 스택상위로 추가
    public boolean isPushToStack(int level){
        if(sa.isEmpty()){
            return true;
        }
        if(stLevel(sa.peek().toString())<=level){
            return true;
        }
        return false;
    }
}
