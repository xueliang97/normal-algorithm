package sort;

public class BubbleSort {

    public static void bubbleSort(int[] nums){ //大的沉后面
        for(int i=0;i<nums.length-1;i++){ //总排序次数，n个数进行n-1次
            for(int j=0;j<nums.length-1-i;j++){ //每次的比较次数
                if(nums[j]>nums[j+1]){
                    int t = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = t;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {5,3,7,1,3,5,0};
        bubbleSort(nums);
        for(int i:nums)
            System.out.print(i+" ");
    }

}
