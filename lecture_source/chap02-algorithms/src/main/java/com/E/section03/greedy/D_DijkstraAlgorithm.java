package com.E.section03.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*다익스트라 알고리즘
 * 음의 가중치가 없는 그래프의 한 정점에서 모든 정점까지의 최단 거리를 구하는 알고리즘
 * 간선에 가중치가 없으면 BFS로도 가능하지만 가중치가 있다면 최단 경로 보장이 어렵다*/
public class D_DijkstraAlgorithm {

    static int n, m, start; //정점 개수, 간선 개수, 시작 정점
    static int[] dis;

    static class Edge implements Comparable<Edge>{
        int ver; //해당 간선이 연될 된 정점
        int cost; //가중치
        Edge(int ver, int cost){
            this.ver = ver;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost; //가중치 오름차순 우선수위
        }
    }

    public static String solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //정점의 개수
        m = Integer.parseInt(st.nextToken()); //간선의 개수
        start = Integer.parseInt(st.nextToken());// 시작할 정점


        //make an arraylist of arraylists of edges, so that each arraylist represents the vertex each
        //is connected to.
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        //각 노드의 가중치 기록할 배열
        dis = new int[n+1];
        //아직 거리가 판단되지 않은 경우에는 Integer최대값으로 채워둔다
        Arrays.fill(dis, Integer.MAX_VALUE);

        for(int i = 0; i < m; i++){
            int a = Integer.parseInt(br.readLine()); //시작 정점
            int b = Integer.parseInt(br.readLine()); // 도착 정점
            int c = Integer.parseInt(br.readLine()); // 가중치
            graph.get(a).add(new Edge(b,c));
        }

        /*우선순위 큐에 Edge가 담겼을 때 우선순위는 가중치가 낮은 순서로 정해진다*/
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dis[start] = 0;

        while(!pq.isEmpty()){
            Edge tmp = pq.poll();
            int now = tmp.ver;
            int currCost = tmp.cost;

            if(currCost > dis[now] ) continue;

            /*기준 정점과 연결 된 이웃 정점을 큐에 추가 하는 반복문*/
            for(Edge e : graph.get(now)){
                /*거리를 기록해두는 배열에 저장 된 값이 현재 비용과 간선을 타고 가는 비용보다
                * 더 크다면*/
                if(dis[e.ver] > currCost + e.cost){
                    /*새로운 루트로 업데이트*/
                    dis[e.ver] = currCost + e.cost;
                    pq.offer(new Edge(e.ver, dis[e.ver]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i < dis.length; i++){
            if(dis[i] != Integer.MAX_VALUE){
                sb.append(dis[i]);
            } else {
                sb.append("impossible");
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
