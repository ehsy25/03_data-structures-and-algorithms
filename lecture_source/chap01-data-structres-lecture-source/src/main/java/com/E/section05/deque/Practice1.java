package com.E.section05.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Practice1 {


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

    public String solution(Integer[] notes) {
        Deque<Balloon> deque = new ArrayDeque<>();
        for (int i = 0; i < notes.length; i++) {
            deque.offer(
                    new Balloon(i + 1, (notes[i])));
        }

        StringBuilder result = new StringBuilder();
        Balloon current = deque.poll();
        int shift = current.getNoteValue();
        result.append(current.getOrder());
        result.append(" ");

        while (!deque.isEmpty()) {
            if (shift > 0) {
                for (int i = 0; i < shift - 1; i++) {
                    deque.addLast(deque.removeFirst());
                }

                result.append(deque.poll().order);

                if (!deque.isEmpty()) {
                    result.append(" ");
                }

            } else {
                for (int i = 0; i < Math.abs(shift)-1; i++) {
                    deque.addFirst(deque.removeLast());
                }
                result.append(deque.removeLast().order);
            }

            if (!deque.isEmpty()) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}



