package com.ohgiraffers.section04.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

public class F_StairClimbing {

    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        int n = Integer.parseInt(br.readLine());        // 계단의 개수

        int[] a = new int [n+1];

        StringTokenizer st = new StringTokenizer(input);
        for(int i = 0; i < n; i++){
        a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                a[i] = Math.max(a[i], a[i+1] + a[i+2]);
            }
        }

        return 0;
    }
}
