package com.E.section04.dp;

public class C_Tiling {

    public static int solution(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        //0, 1은 무조건 1이니까 2부터 시작
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

}
