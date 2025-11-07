package com.E.section01.sorting;

/*퀵 정렬
 * 기준 값(pivot)을 선정하여 해당 값을 기준으로 작은 값과 큰 값으로 ""분할"하는 방식이다.
 * 분할 후 각각의 부분 배열을 재귀적을 ㅗ정렬하여 정렬을 완성한다
 * 평균적으로 O(n log n)의 시간 복잡도를 가지며, 일반적으로 매우 빠르다
 * 하지만 피벗이 최악으로 선택 된 경우 O(n^2)의 성능을 가질 수 있다
 * 메모리 사용이 적고, 대부분의 실제 데이터에서 우수한 성능을 보인다*/

public class D_QuickSort {

    /*문제 n 개의 정수가 주어졌을 대, 퀵 정렬 알고리즘을 사용하여 오름차순으로 정렬하는
    프로그램을 작성한다*/

    public static void solution(int[] arr) {
        //5,3,8,9,2,4,7
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low >= high) return;
        int partition = partition(arr,low,high);
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[(low + high) /2];

        while(low <= high){
            while(arr[low] < pivot) low++;
            while(arr[high] > pivot) high--;

            if(low <= high){
                swap(arr, low, high);
                low++;
                high--;
            }
        }
        return low;
    }

    public static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}