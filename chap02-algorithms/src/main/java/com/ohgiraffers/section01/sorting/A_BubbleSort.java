package com.ohgiraffers.section01.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class A_BubbleSort {

    /* 버블 정렬을 이해할 수 있다. */
    /*
    * 정렬 알고리즘
    *   데이터를 특정 순서대로 배열하는데 사용한다.
    * */
    /* 버블 정렬
     * 인접한 두 요소를 비교하여 크기가 순서대로 정렬되지 않았으면 교환하는 방식의 정렬이다.
     * 배열 전체를 여러 번 반복하며 각 반복마다 가장 큰 요소가 끝으로 이동한다.
     * 시간 복잡도는 O(n^2)이며, 데이터가 거의 정렬 된 경우 최선의 경우 O(n)이 될 수도 있다.
     * 하지만 교환 연산이 많아 다른 O(n^2) 정렬보다 느릴 수 있다.
     * */
    public static void main(String[] args) {
        /* 설명.
         *  문제 내용
         *   : N개의 정수가 주어졌을 때, 버블 정렬 알고리즘을 사용하여 오름차순으로 정렬하는 프로그램을 작성하시오.
         *  입력
         *   - 첫 번째 줄에 자연수 N(1 <= N <= 100)이 주어진다.
         *   - 두 번째 줄에 N개의 정수가 공백으로 구분되어 입력된다. 각 정수는 -10^9 이상, 10^9 이하이다.
         *  출력
         *   - 오름차순으로 정렬된 수열을 공백으로 구분하여 출력한다.
         *
         *  설명.
         *   예시 입력 1
         *     - 7
         *       34 23 5 24 1 9 12
         *   예시 출력 1
         *     - 1 5 9 12 23 24 34
         *
         *  설명.
         *   예시 입력 2
         *     - 6
         *       40 47 38 8 33 35
         *   예시 출력 2
         *     - 8 33 35 38 40 47
         * */

        /* 입력 데이터 받기 */
//        Scanner sc = new Scanner(System.in);
//        int length = sc.nextInt();
//        int[] arr = new int[length];
//        for (int i = 0; i < length; i++) {
//            arr[i] = sc.nextInt();
//        }
//        System.out.println("lenth = " + arr.length);
//        System.out.println("arr = " + Arrays.toString(arr));

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            int length = Integer.parseInt(br.readLine());
            IntStream intStream = Arrays.stream(br.readLine().split(" "))
                                        .mapToInt(x -> Integer.parseInt(x));
            int[] arr = intStream.toArray();
            System.out.println("length = " + length);
            System.out.println("arr = " + Arrays.toString(arr));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void solution(int length, int[] arr){

        for(int i = 0; i < length - 1; i++){
            System.out.println((i + 1) + " " + Arrays.toString(arr));
            for(int j= 0; j < length - 1 - i; j++){
//                if(arr[j] > arr[j + 1]) {  // 오름차순
                if(arr[j] < arr[j + 1]) {  // 내림차순
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
