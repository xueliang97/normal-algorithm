package 二分;

public class 有序矩阵中第k小的元素 {

    public static void main(String[] args){
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        kthSmallest(matrix,8);

    }

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0],right = matrix[n-1][n-1];

        while(left<right){
            int mid = (left+right)>>>1;
            if(check(matrix,k,mid)){ //左上角小于等于target元素的个数是否大于等于k 小于k的话向右找
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    public static boolean check(int[][] matrix, int k,int mid){
        int i=matrix.length-1,j = 0 ;//从右下角开始找
        int count = 0;
        while(i>=0&&j<matrix.length){
            if(matrix[i][j]<=mid){//向左找，数量加上右边的列
                count += i+1;
                j++;
            }else{
                i--;
            }
        }
        return count>=k;
    }
}
