package com.E.section04.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Practice2 {

    public int solution(int w, int l, Integer[] ts, int expected) {
        Queue<Integer> trucks = new LinkedList<>();
        int count = 0;
        //트럭 채우기
        for(int t : ts){
            trucks.offer(t);
        }
        int bw = 0;
        int tob = 0;

        while(!trucks.isEmpty()){
            if(bw < w && bw+trucks.peek()< w){
                bw += trucks.poll();
                tob++;
                count++;
            }
        }

        return count;
    }
}
