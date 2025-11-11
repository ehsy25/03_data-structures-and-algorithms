package com.E.section03.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C_MeetingRoom {

    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        int n = Integer.parseInt(br.readLine());
        int [][] time = new int[n][2]; // 회의 갯수 * (시작/종료)
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            time[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        Arrays.sort(time, (int[] t1, int[] t2) -> {
            //종료 시간이 같은 회의가 있다면 시작 시간이 빠른 순서로 정렬
            //경계 시간에 있는 회의가 올바르게 처리 되도록 주는 기준
            if(t1[1] == t2[1]) return t1[0] - t2[0];

            return t1[1] - t2[1];
        });

        int endTime = 0; //직전 회의가 끝난 시간을 담아줄 변수
        int count = 0; //회의가 배정된 개수

        /*time 배열 안에 있는 회의를 반복하며 회의 시간에 넣을지 확인 */
        for(int i = 0; i < n; i++){
            if(time[i][0] >= endTime){
                endTime = time[i][1]; //다음 회의 시간을 확인하기 위해 종료 시간 수정
                count++;
            }
        }

        return count;
    }


}
