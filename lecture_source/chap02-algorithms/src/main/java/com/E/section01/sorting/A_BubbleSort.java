package com.E.section01.sorting;


import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/*버블 정렬을 이해할 수 있다
 *
 * 정렬 알고리즘
 * 데이터를 특정 순서대로 배열하는데 사용한다
 *
 *  버블 정렬
 * 인접한 두 요소를 비교하여 크기가 순서대로 정렬되지 않았으면 교환하는 방식의 정렬이다.
 * 배열 전체를 여러 번 반복하며 각 반복마다 가장 큰 요소가 끝으로 이동한다.
 * 시간 복잡도는 O(n^2)이며, 데이터가 거의 정렬 된 경우 최선의 경우 O(n)이 될 수도 있다.
 * 하지만 교환 연산이 많아 다른 O(n^2) 정렬보다 느릴 수 있다.
 * */
public class A_BubbleSort {

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



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try(BufferedReader br = new BufferedReader (new InputStreamReader(System.in)))
        {int length = Integer.parseInt(br.readLine());

IntStream iS = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt);
int[] a = iS.toArray();
            System.out.println(length);
            System.out.println(Arrays.toString(a));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        A_BubbleSort a = new A_BubbleSort();
        a.solution(6, new int[] {40, 47, 38, 8, 33, 35} );
    }

    public static void solution(int n, int[] a){
        for (int i=0 ;i < n-1; i++){
            for(int j = 0; j <n-1-i; j++){
                if(a[j] > a[j+1]){
                int temp = a[j];
                a[j] = a[j+1];
                a[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

}
