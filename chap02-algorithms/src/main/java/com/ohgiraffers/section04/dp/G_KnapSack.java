package com.ohgiraffers.section04.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_KnapSack {

    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int [] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] bag = new int[n+1][k+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){
                if(i == 0 || j == 0){
                    bag [i][j] = 0;
                } else {
                    int pick = 0;
                    if( pick > k){1
                    }
                }
            }
        }

    return 0;
    }

}
