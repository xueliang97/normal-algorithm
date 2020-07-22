package 面试中出现过的题;

public class 行列有序的数组查找元素 {

    /**
     * 从右上角开始搜，当前值小于target i++;当前值大于target j--
     * @param nums
     * @param target
     * @return
     */
    public boolean solve(int[][] nums,int target){
        int m = nums.length,n = nums.length;
        int i = 0,j = n-1;
        while(i<m&&j>=0){
            if(nums[i][j]>target){
                j--;
            }else if(nums[i][j]<target){
                i++;
            }else{
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args){
        int[][] nums = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        行列有序的数组查找元素 t = new 行列有序的数组查找元素();
        System.out.println(t.solve(nums,14));
    }


}
