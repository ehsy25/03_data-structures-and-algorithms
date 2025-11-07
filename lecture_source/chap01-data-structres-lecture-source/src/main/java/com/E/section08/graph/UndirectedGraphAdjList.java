package com.E.section08.graph;

/*인접 리스트 기반 무방향 비가중치 그래프 예제
 * - 각 노드의 인접 노드 목록을 리스트로 관리
 * */

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphAdjList {
    private int vertices;
    private List<List<Integer>> adjList;
    private List<Boolean> active;

    /* 초기 정점 수 만큼 인접 리스트와 active 리스트 초기화 */
    public UndirectedGraphAdjList(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        active = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
            active.add(true);
        }
    }
    /* 무방향 간선을 추가 (노드 u와 v가 모두 활성 상태여야 함) */
    public void addEdge(int u, int v) {
        if (u < vertices && v < vertices && active.get(u) && active.get(v)) {
            adjList.get(u).add(v);    // 징점을 관리하는 리스트
            adjList.get(v).add(u);
        }
    }

    /* 그래프의 상태를 출력
     * 각 활성 노드의 인접 목록을 출력 */
    public void printGraph() {
        System.out.println("무방향 그래프 (인접 리스트):");
        for (int i = 0; i < vertices; i++) {
            if (active.get(i)) {
                System.out.print(i + ": ");
                for (int neighbor : adjList.get(i)) {
                    System.out.print(neighbor + " ");
                }
                System.out.println();
            }
        }
    }
    /* 새로운 노드를 추가 */
    public int addNode() {
        adjList.add(new ArrayList<>());
        active.add(true);
        vertices++;
        return vertices - 1;
    }
    /* 무방향 간선을 제거 */
    public void removeEdge(int u, int v) {
        if (u < vertices && v < vertices) {
            if (active.get(u)) {
                adjList.get(u).remove((Integer)v);
            }
            if (active.get(v)) {
                adjList.get(v).remove((Integer)u);
            }
        }


    }

    /* 노드 x를 그래프에서 제거
     * 제거된 노드는 비활성화(active = false) 처리
     * 다른 노드의 인접 행렬에서도 해당 노드와의 간선이 제거
     */
    /* 노드 x를 그래프에서 제거
     * 제거된 노드는 비활성화(active=false) 처리되고, 다른 노드의 인접 목록에서도 삭제 */
    public void removeNode(int x) {
        if (x < vertices && active.get(x)) {
            active.set(x, false);
            // 다른 모든 노드의 인접 목록에서 x 제거
            for (int i = 0; i < vertices; i++) {
                if (active.get(i)) {
                    adjList.get(i).remove((Integer)x);
                }
            }
            // 자신의 인접 리스트도 비움
            adjList.get(x).clear();
        }
    }
    public static void main(String[] args) {
        UndirectedGraphAdjList g = new UndirectedGraphAdjList(4);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(1,3);
        g.addEdge(2,3);

        g.printGraph();
        /*1--2\
         * |  | \
         * |\ |  5
         * 3--4 /   */


        //addNode
        int newNode = g.addNode();
        System.out.println("new note added: " + newNode);

        g.addEdge(newNode,1);
        g.addEdge(newNode,3);
        System.out.println("graph after adding node 5");
        g.printGraph();

        //3. removeEdge teste remove line between node 1 and 4
        System.out.println("remove line 1-4");
        g.removeEdge(0,3);
        g.printGraph();

        //4. removeNode remove node 3
        System.out.println("graph after removing node 3");
        g.removeNode(2);
        g.printGraph();


    }

}
