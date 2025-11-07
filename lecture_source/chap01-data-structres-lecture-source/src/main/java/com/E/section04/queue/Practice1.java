package com.E.section04.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Practice1 {

    public String solution(int n, int k){
        Queue <Integer> q = new LinkedList<>();
        StringBuilder result = new StringBuilder ("<");

//        //큐 채우기
        for(int i = 1; i < n+1; i++){
            q.add(i);
        }
//        // 모든 값이 빠질때까지
//        while(!q.isEmpty()){
//
//            for(int j = 0; j < k-1; j++){
//                q.offer(q.poll());
//            }
//            result.append(q.poll());
//            if(!q.isEmpty()){
//                result.append(", ");
//            }
//        }
//        result.append(">");
//        return result.toString();

                while(!q.isEmpty()){
            for(int i = 1; i < k; i++){
                if(q.peek() != null){
                    int temp = q.peek();
                    q.poll();
                    q.offer(temp);
                }
            } result.append(q.poll());
            if(!q.isEmpty()){
                result.append(", ");
            }
        }
result.append(">");
                return result.toString();
    }


}




