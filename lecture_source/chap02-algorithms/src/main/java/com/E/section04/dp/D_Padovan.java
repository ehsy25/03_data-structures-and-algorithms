package com.E.section04.dp;

public class D_Padovan {

    /*파도반 수열
     * 점화식 : f(n) = f(n-2) + f(n-3)
     * */

    static Integer[] dp = new Integer[101];

    public static int solution(int n) {
        dp[1] = dp[2] = dp[3]=1;

        /*탑 다운 방식 (재귀 호출)*/
        padovan(n);

        /* 바탐 업 방식 (반복문)*/
        for(int i = 4; i <= n; i++){
            dp[i] = dp[i-2] + dp[i-3];
        }
        return dp[n];
    }

    private static int padovan(int n){
        if(dp[n]==null){
            dp[n] = padovan(n-2)+padovan(n-3);
        }
        return dp[n];
    }

}
