package come.E.section01.timecomplexity;

public class Application {

    public static void main(String[] args) {

        int[] a = {3,1,2,15,4,9,10,7};
        System.out.println(getFirst(a));
    }

    //O(1)
    private static int getFirst(int[] a) {
        return a[0];
    }
//O(log n)
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; //while문을 돌 때마다 범위가 ½씩 줄어 듦!
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
//O(n)
    public static int[] reverse(int[] nums) {
        int[] reversed = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            reversed[nums.length - i - 1] = nums[i];
        }
        return reversed;
    }


}

