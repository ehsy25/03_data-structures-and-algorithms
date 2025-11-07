package com.E.section05.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Gs {
    static class Balloon {
        int order;
        int noteValue;

        Balloon(int order, int noteValue) {
            this.order = order;
            this.noteValue = noteValue;
        }

        public int getOrder() {
            return order;
        }

        public int getNoteValue() {
            return noteValue;
        }
    }

    public String solution(Integer[] n) {
        Deque<Balloon> deque = new ArrayDeque<>();

        for (int i = 1; i <= n.length; i++) {
            Balloon balloon = new Balloon(i, n[i - 1]);
            deque.addLast(balloon);
        }

        StringBuilder result = new StringBuilder();
        while (true) {
            Balloon balloon = deque.removeFirst();
            result.append(balloon.order);

            if(deque.isEmpty()) break;
            else result.append(" ");

            boolean isLeft = balloon.noteValue < 0;
            int count = Math.abs(balloon.noteValue) + booleanToInt(isLeft);
            for (int i = 0; i < count; i++) {
                if(isLeft) left(deque);
                else right(deque);
            }
        }

        return result.toString();
    }

    private static void left(Deque<Balloon> deque) {
        Balloon balloon = deque.removeLast();
        deque.addFirst(balloon);
    }

    private static void right(Deque<Balloon> deque) {
        Balloon balloon = deque.removeFirst();
        deque.addLast(balloon);
    }

    private static int booleanToInt(boolean bool) {
        return Boolean.compare(bool, true);
    }

}


