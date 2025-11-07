package com.ohgiraffers.section02.searching;

/*
 * 깊이 우선 탐색(Depth-First Search)
 * 후입 선출 구조의 stack을 활용하거나 재귀호출을 이용한다.
 * 시작 노드에서 출발해 한 방향으로 갈 수 있는 만큼 깊이 탐색한 후,
 * 더 이상 진행할 수 없을 때 이전 분기점으로 돌아가 다른 경로를 탐색하는 알고리즘이다.
 * */
public class A_DFS {

    /* 웜 바이러스에 걸리게 되는 컴퓨터의 수 구하기 문제 */
    static int node, edge;                      // 노드수, 간선수
    static int[][] map;
    static boolean[] visit;
    static int count = 0;

    public static Integer solution(String input) {
        return count;
    }
}
