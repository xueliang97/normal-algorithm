package sort;

public class InsertSort {


    public static void main(String[] args){
        int[] nums = {9,5,6,2,3,7,3,0};
        insertSort(nums);
        for(int k:nums)
            System.out.print(k+" ");
    }

    private static void insertSort(int[] nums) {
        for(int i=1;i<nums.length;i++){
            int cur = nums[i];
            int j = i-1;
            for(;j>=0&&nums[j]>cur;j--){
                nums[j+1] = nums[j];
            }
            nums[j+1] = cur;
        }

    }
}
