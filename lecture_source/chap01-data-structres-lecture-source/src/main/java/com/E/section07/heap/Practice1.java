package com.E.section07.heap;

import java.util.PriorityQueue;

public class Practice1 {

    public String solution(Integer[] input) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder result = new StringBuilder();
        for(int i : input){
            if(i == 0){
                if(pq.isEmpty()){
                    result.append("0 ");
                }
            }

        }
        return result.toString();
    }
}
