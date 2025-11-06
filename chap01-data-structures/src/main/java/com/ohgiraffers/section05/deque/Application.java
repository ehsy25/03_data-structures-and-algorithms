package com.ohgiraffers.section05.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Application {

    public static void main(String[] args) {
        /*
        * Java Collection Framework에서는 Deque인터페이스와 이를 구현한 구현체가 있다.
        * 배열 기반의 동적 큐인 ArrayDeque클래스를 활용한다.
        * */
        Deque<Integer> deque = new ArrayDeque<>();

        // 요소 추가
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addFirst(5);

        System.out.println("deque = " + deque);

        // 요소확인
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());

        // 요소 제거
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());

        System.out.println("deque = " + deque);
    }
}
