package com.ohgiraffers.section07.heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Practice1 {

    public String solution(Integer[] array) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int absCompare = Integer.compare(Math.abs(a), Math.abs(b));  // 절대값이 가장 작은수가 가장 우선순위가 높다
            if(absCompare == 0) {
                return Integer.compare(a, b);
            }
            return absCompare;
        });

        StringBuilder sb = new StringBuilder();

        for (int x : array) {
            if(x == 0){
                if(pq.isEmpty()){
                    sb.append("0 ");
                } else {
                    sb.append(pq.poll()).append(" ");
                }
            } else {
                pq.offer(x);
            }
        }

        return sb.toString().trim();
    }
}
