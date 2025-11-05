package come.E.section03.stack;

import java.util.Scanner;
import java.util.Stack;

public class Practice1 {

    public String solution(String input) {

//        int left = 0;
//        int right = 0;
//
//        for(int i = 0; i < input.length(); i++){
//            if(input.charAt(i) == '('){
//                left++;
//            }else if(input.charAt(i) == ')'){
//                right++;
//            }
//        }
//
//        if(left == right){
//            return "YES";
//        }
//
//        return "NO";

        Stack<Character> s = new Stack<>();
        for(char c : input.toCharArray()) {
            //왼쪽 괄호면 스택에 추가
            if(c == '('){
                s.push(c);
            }
            //오른쪽 괄호면 스택에서 제거
            //스택이 부족하면 합이 안 맞는다
            else{
                if(s.isEmpty()){return "NO";}
                s.pop();
            }
        }
        if(!s.isEmpty()){return "NO";}
        return "YES";
    }
}


