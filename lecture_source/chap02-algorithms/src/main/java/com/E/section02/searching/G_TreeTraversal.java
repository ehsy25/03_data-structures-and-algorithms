package com.E.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_TreeTraversal {

    // 각 노드(알파벳 A-Z)의 왼쪽, 오른쪽 자식을 저장하는 배열(-1이면 자식없음)
    static int[] left;
    static int[] right;
    static StringBuilder sb;

    public static String solution(String input) throws IOException {
        BufferedReader br=new BufferedReader(new StringReader(input));
        int n = Integer.parseInt(br.readLine());

        left=new int[26];
        right=new int[26];
        Arrays.fill(left,-1);
        Arrays.fill(right,-1);

        for(int i=0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char p = st.nextToken().charAt(0);
            char lc = st.nextToken().charAt(0);
            char rc = st.nextToken().charAt(0);

            int idx = p - 'A';
            if(lc != '.'){
                left[idx] = lc - 'A';
            }
            if(rc != '.'){
                right[idx] = rc - 'A';
            }

            System.out.println("노드 " + p + "(인덱스 " + i + ")" + "왼쪽 자식 " + lc + " 오른쪽 자식" + rc);

        }

        System.out.println("===================");
        //전위 순회 :루트 왼쪽 오른족
        sb = new StringBuilder();
        preorder(0);
        sb.append("\n");
        //중위 순회 :왼쪽 루트 오른쪽
        inorder(0);
        sb.append("\n");
        //후위 손회 :왼쪽 오른쪽 루트
        postorder(0);
        sb.append("\n");
        return sb.toString();
    }

    private static void preorder(int node) {
        if(node == -1) return;
        sb.append((char)(node + 'A'));
        preorder(left[node]);
        preorder(right[node]);
    }

    private static void inorder(int node) {
        if(node == -1) return;
        inorder(left[node]);
        sb.append((char)(node + 'A'));
        inorder(right[node]);
    }

    private static void postorder(int node) {
        if(node == -1) return;
        postorder(left[node]);
        postorder(right[node]);
        sb.append((char)(node + 'A'));
    }
}