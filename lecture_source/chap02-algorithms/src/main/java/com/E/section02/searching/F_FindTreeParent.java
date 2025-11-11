package com.E.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class F_FindTreeParent {


    static int n; //노드의 갯수
    static List<Integer>[] list; //연결 노드 저장 배열(최소 그래프니까 배열 사용)
    static int[] parent; //최종 결과 저장 배열
    static boolean[] visit; //방문 결과 저장 배열

    public static String solution(String input) throws IOException {

        BufferedReader br = new BufferedReader(new StringReader(input));
        n = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        visit = new boolean[n+1];
        list = new ArrayList[n+1];

        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        /*N -1개 줄의 입력 처리*/
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        list[a].add(b);
        list[b].add(a);

        //dfs(1);

        bfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= parent.length; i++){
            sb.append(parent[i]).append(" ");
        }
        return sb.toString();
    }

    private static void bfs(int root) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        visit[root] = true;

        while(!q.isEmpty()){
            int p = q.poll();
            /*연결된 노드를 반복*/
            for(int children : list[p]){
                if(!visit[children]){
                    visit[children] = true;
                    parent[children] = p;//부모를 관리하는 배열의 해당 자식 노드를 담는다
                    q.offer(children);
                }
            }
        }

    }

    private static void dfs(int parentNode) {
        visit[parentNode] = true;

        /*연결 된 노드를 반복*/
        for(int children : list[parentNode]){
            if(!visit[children]){
                //부모를 관리하는 배열에 해당 자식 노드의 부모 노드를 담는다
                parent[children] = parentNode;

                //그 자식 노드를 부모로 하는 자식 노드를 탐색한다
                dfs(children);

            }
        }

    }


}
