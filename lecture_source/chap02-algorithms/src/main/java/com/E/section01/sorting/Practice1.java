package com.E.section01.sorting;

/*Tim Sort 구현하기
 *
 * 삽입정렬과 병합 정렬의 장점을 결합한 하이브리드 정렬 알고리즘
 * 작은 배열 (길이 32이하)은 삽입 정렬로 정렬한 후, 병합 정렬 방식으로 전체 배열을 병합한다
 * */

public class Practice1 {

    //Tim Sort에서 사용할 RUN의 크기 (작은 배열은 삽입 정렬로 정렬)
    private static final int RUN = 32;

    public static void timSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i+=RUN){
            insertionSort(arr, i, Math.min(( i+ RUN -1), n-1));
        }
    }

    private static void insertionSort(int[] arr, int i, int min){
    }

    /* 두 개의 정렬된 부분 배열을 병합하여 하나의 정렬된 배열로 만드는 메소드 */
    private static void merge(int[] arr, int left, int mid, int right) {
        int len1 = mid - left + 1;
        int len2 = right - mid;

        // 임시 배열 생성
        int[] leftArr = new int[len1];
        int[] rightArr = new int[len2];

        System.arraycopy(arr, left, leftArr, 0, len1);
        System.arraycopy(arr, mid + 1, rightArr, 0, len2);

        int i = 0, j = 0, k = left;

        // 두 임시 배열을 비교하여 정렬된 순서로 원본 배열에 복사
        while (i < len1 && j < len2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        // 남은 요소들을 복사
        while (i < len1) {
            arr[k++] = leftArr[i++];
        }
    }
}
