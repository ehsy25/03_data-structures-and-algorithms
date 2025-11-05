package come.E.section03.stack;

import java.util.Stack;

public class Practice2 {

    public int solution(String input) {

        Stack s = new Stack();

int razer = 0;
boolean stick = false;
        for(char c : input.toCharArray()) {
            if (c == '('){
                s.push(c);
            }
            else {
                if(s.peek().equals('(') && stick){
                    s.pop();
                    razer++;
                } s.pop();
                stick = true;
                return razer+1;
            }
        }
        return 1;
    }
}
