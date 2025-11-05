package com.E.section03.stack;

import java.util.Stack;

public class Practice2 {

    public int solution(String input) {

        //char 받을 스택
        Stack s = new Stack();
        //막대 갯수용 변수
        int count = 0;

        //String끝까지 받기
        for(int i = 0; i < input.length(); i++) {
            //왼쪽 괄호일 경우에 스택에 추가
            if(input.charAt(i) == '(') {
                s.push('(');
                //왼쪽 괄호가 아니면 무조건 오른쪽 괄호
            }else {
                //레이저가 아니더라도 막대 하나의 끝이니 pop() 한 번
                s.pop();
                /* 1. 직전 문자가 (여서 레이저가 완성되는 경우
                 * 레이저가 완성되서 막대가 절단되고 여태까지 있었던 ( char 하나 당 막대 하나가 절단되서 스택에 있는 ( 갯수만큼 막대가 생김
                 * */
                if(input.charAt(i-1) == '(') {
                    count += s.size();
                    /*2. 직전 문자가 ( 가 아닌 경우
                    * 직전 문자가 ) 인 경우에는 막대의 끝을 의미함
                    * 레이저가 그 전에 있었으면 자르고 남은 왼쪽 하나의 막대를 의미하고
                    * 레이저가 없었으면 막대 하나를 의미해서 +1 */
                }else count++;
            }
        }
        return count;
    }
}
